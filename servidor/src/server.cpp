//
// Created by fmurillom on 06/05/18.
//

#include "../include/server.h"
#include "../live/liveMedia/include/liveMedia.hh"
#include "../live/BasicUsageEnvironment/include/BasicUsageEnvironment.hh"
#include <pthread.h>
#include "../include/tinyxml2.h"
#include <fstream>
#include "../include/cajun/json/reader.h"
#include "../include/cajun/json/writer.h"
#include "../include/Sorter.h"
#include <algorithm>

void error(const char *msg);

void quickSort(Song arr[], int low, int high);


//! Constructor para inicializar la clase StreamServer
//! \param port
StreamServer::StreamServer(int port) throw(StreamServerError)
        : port(port), notRunning(~0), thread(NULL)
{
    TaskScheduler* scheduler = BasicTaskScheduler::createNew();
    env = BasicUsageEnvironment::createNew(*scheduler);
    rtsp = RTSPServer::createNew(*env, port, NULL, 45);
    if (rtsp == NULL)
    {
        throw StreamServerError();
    }

    this->songList = new S_List<Song>;
    this->userTree = new BsearchTree<string, User>;
    User dummy;
    dummy.setUsrName("master");
    this->userTree->add("master", dummy);
    this->treeName = new BsearchTree<string, Song>;
    Song songDummy;
    songDummy.setName("master");
    treeName->add("master", songDummy);
    artistTree = new AVLTree;
    albumList = new S_List<Song>;
    this->pageCount = 0;
    this->login = false;
}


StreamServer::~StreamServer()
{
    Medium::close(rtsp);
    env->reclaim();
}


typedef MPEG1or2VideoFileServerMediaSubsession MPEGVidOnly;
typedef MPEG1or2FileServerDemux MPEG;
typedef MP3AudioFileServerMediaSubsession MP3;

#define DO_ADD_CHECKS() \
        if (name == NULL) \
        { \
                name = file; \
        } \
        ServerMediaSession* look = rtsp->lookupServerMediaSession(name); \
        if (isRunning() && look != NULL) \
        { \
                throw StreamServerRunError(); \
        } \
        else \
        { \
                remove(name); \
        }


        //! Funcion encargada de agregar cancion mp3 al servidor RTSP
        //! \param file direccion del archivo a cargar
        //! \param name nombre de identificador para la direccion rtsp unica
void StreamServer::addMP3(char const* file, char const* name = NULL)
throw(StreamServerRunError)
{
    DO_ADD_CHECKS();

    unsigned char interleaveCycle[] = {0,2,1,3};
    unsigned const interleaveCycleSize =
            sizeof(interleaveCycle)/sizeof(unsigned char);
    Interleaving* interleaving;

    interleaving = new Interleaving(interleaveCycleSize, interleaveCycle);
    ServerMediaSession* sms = NULL;
    sms = ServerMediaSession::createNew(*env, name, name);
    sms->addSubsession(MP3::createNew(*env, file, False, False,
                                      interleaving));
    rtsp->addServerMediaSession(sms);
}


void StreamServer::addMPEGVideo(char const* file, char const* name)
throw(StreamServerRunError)
{
    DO_ADD_CHECKS();

    ServerMediaSession *sms = NULL;
    sms = ServerMediaSession::createNew(*env, name, name);
    sms->addSubsession(MPEGVidOnly::createNew(*env, file, False, False));
    rtsp->addServerMediaSession(sms);
}


void StreamServer::addMPEG(char const* file, char const* name)
throw(StreamServerRunError)
{
    DO_ADD_CHECKS();

    ServerMediaSession *sms = NULL;
    sms = ServerMediaSession::createNew(*env, name, name);
    MPEG* demux = MPEG::createNew(*env, file, False);
    sms->addSubsession(demux->newVideoServerMediaSubsession());
    sms->addSubsession(demux->newAudioServerMediaSubsession());
    rtsp->addServerMediaSession(sms);
}

//! Metodo encargado de remover una cancion del stream de RTSP
//! \param name nombre del archivo que se desea remover del stream
void StreamServer::remove(char const* name) throw(StreamServerRunError)
{
    ServerMediaSession* sms = NULL;
    sms = rtsp->lookupServerMediaSession(name);
    if (sms != NULL)
    {
        if (isRunning())
        {
            throw StreamServerRunError();
        }
        else
        {
            rtsp->removeServerMediaSession(sms);
        }

    }
}

//! Funcion que verificara si el servidor esta corriendo
//! \param instance instancia del servidor
//! \return
void* StreamServer::listenClose(void* instance) // Will run in its own thread.
{
    StreamServer* inst = (StreamServer*)instance;
    inst->env->taskScheduler().doEventLoop(&(inst->notRunning));
    return NULL;
}

//! Metodo encargado de iniciar el stream del servidor
void StreamServer::run() throw(StreamServerRunError)
{
    if (isRunning() == false)
    {
        notRunning = 0;
        pthread_create(&thread, NULL, StreamServer::listenClose,
                       (void*)this);
    }
    else
    {
        throw StreamServerRunError();
    }
}

/*!
 * Metodo encargado de detener el servidor para realizar ajustes o finalizarlo
 */
void StreamServer::stop() throw(StreamServerRunError)
{
    if (isRunning() == false)
    {
        throw StreamServerRunError();
    }
    else
    {
        notRunning = ~0;
    }
}

/*!
 * Instancia singleton que verificara si el servidor ya se encuentra corriendo e instanciado
 * @return booleano que identifica si el servidor se encuentra corriendo
 */
bool StreamServer::isRunning() const
{
    return ~notRunning;
}

/*!
 * Retornara la direccion de algun stream especifico
 * @param name nombre del stream que se desea buscar
 * @return string que sera la direccion donde se encuentra el stream
 */
const char* StreamServer::getURL(char const* name) const
throw(StreamServerNameError)
{
    ServerMediaSession* sms = NULL;
    sms = rtsp->lookupServerMediaSession(name);

    if (sms == NULL)
    {
        throw StreamServerNameError();
    }
    return rtsp->rtspURL(sms);
}

/*!
 *Metodo encargado de generar un archivo xml con la informacion del estado del login al servidor
 * @param status estado del login del servidor
 */
void StreamServer::sendLoginInfo(string status){
    string xml = "<?xml version=\"1.0\" ?>\n";
    string friendStart = "<LogIn>\n";
    string friendEnd = "</LogIn>\n";
    string statusStart = "  <Status>";
    string statusEnd = "</Status>\n";
    xml.append(friendStart);
    xml.append(statusStart);
    xml.append(status);
    xml.append(statusEnd);
    xml.append(friendEnd);
    ofstream file("../coms/coms.xml");
    file << xml;
    file.close();

}

/*!
 * Metodo encargado de leeer el archivo xml recibido por socket
 * @param file ruta del archivo a leer
 * @param doc2 instancia del parseador xml
 */
void StreamServer::parseXML(std::string file, TiXmlDocument *doc2) {
    doc2->LoadFile(file);
    TiXmlElement *pRoot, *pParm;
    pRoot = doc2->FirstChildElement("LogIn");
    if(pRoot){
        pParm = pRoot->FirstChildElement("UserName");
        User login;
        login.setUsrName(pParm->GetText());
        pParm = pRoot->FirstChildElement("Password");
        login.setHashPass(this->generateHash(pParm->GetText()));
        User *aux = this->userTree->searchUsr(login.getUsrName());
        if(aux){
            if(aux->getUsrName() == login.getUsrName() && aux->getHashPass() == login.getHashPass()){
                this->login = true;
                cout << "Login Succesful" << endl;
                this->sendLoginInfo("success");
                usleep(500000);
                this->sendFileJava(8081, "../coms/coms.xml");
                return;
            }
        }else{
            this->sendLoginInfo("failed");
            usleep(500000);
            this->sendFileJava(8081, "../coms/coms.xml");
        }
    }
    pRoot = doc2->FirstChildElement("Register");
    if (this->login || pRoot) {
        pRoot = doc2->FirstChildElement("Song");
        Song add;
        if (pRoot) {
            pParm = pRoot->FirstChildElement("Title");
            string name = pParm->GetText();
            std::replace(name.begin(), name.end(), ' ', '_');
            add.setName(name);
            pParm = pRoot->FirstChildElement("Album");
            add.setAlbum(pParm->GetText());
            pParm = pRoot->FirstChildElement("Genre");
            add.setGenre(pParm->GetText());
            pParm = pRoot->FirstChildElement("Artist");
            add.setArtist(pParm->GetText());
            pParm = pRoot->FirstChildElement("Rating");
            add.setRating(pParm->GetText());
            add.setFilename("../library/" + add.getName() + ".mp3");
            cout << "Receiving" << endl;
            this->recieveFile(add.getFilename());
            this->addMP3(add.getFilename().c_str(), add.getName().c_str());
            add.setStreamAdress(this->getURL(add.getName().c_str()));
            this->songList->add(add);
            this->treeName->add(add.getName(), add);
            this->artistTree->insert(add.getArtist());
            this->generateAlbumList();
        }
        pRoot = doc2->FirstChildElement("Register");
        User userAux;
        if(pRoot){
            pParm = pRoot->FirstChildElement("UserName");
            userAux.setUsrName(pParm->GetText());
            pParm = pRoot->FirstChildElement("Password");
            userAux.setHashPass(this->generateHash(pParm->GetText()));
            pParm = pRoot->FirstChildElement("Age");
            userAux.setAge(pParm->GetText());
            pParm = pRoot->FirstChildElement("Name");
            userAux.setName(pParm->GetText());
            pParm = pRoot->FirstChildElement("Genre");
            while(pParm){
                userAux.addFavGenre(pParm->GetText());
                pParm = pParm->NextSiblingElement("Genre");
            }
            pParm = pRoot->FirstChildElement("Friend");
            while(pParm){
                userAux.addFriend(pParm->GetText());
                pParm = pParm->NextSiblingElement("Friend");
            }
            cout << userAux << endl;
            this->userTree->add(userAux.getUsrName(), userAux);
            saveUserDB();
        }
        pRoot = doc2->FirstChildElement("Delete");
        Song del;
        if(pRoot){
            pParm = pRoot->FirstChildElement("Title");
            del.setName(pParm->GetText());
            pParm = pRoot->FirstChildElement("Album");
            del.setAlbum(pParm->GetText());
            pParm = pRoot->FirstChildElement("Artist");
            del.setArtist(pParm->GetText());
            this->stop();
            this->songList->del(del);
            this->remove(del.getName().c_str());
            this->artistTree->remove(del.getArtist());
            this->treeName->deleteValue(del.getName());
            string path = "../library/";
            path.append(del.getName());
            path.append(".mp3");
            unlink(path.c_str());
            this->run();
        }
        pRoot = doc2->FirstChildElement("Friend");
        if(pRoot){
            pParm = pRoot->FirstChildElement("UserName");
            User *aux = this->userTree->searchUsr(pParm->GetText());
            if(aux){
                S_List<string> *aux3 = &aux->getFriendList();
                pParm = pRoot->FirstChildElement("Friend");
                while(pParm){
                    S_List<string> *aux2 = &this->userTree->searchUsr(pParm->GetText())->getFriendList();
                    if(aux2){
                        aux3->add(pParm->GetText());
                    }
                    pParm = pParm->NextSiblingElement("Friend");
                }
            }
            saveUserDB();
        }
        pRoot = doc2->FirstChildElement("Recomendation");
        if(pRoot) {
            pParm = pRoot->FirstChildElement("UserName");
            S_List<string> *aux = &this->userTree->searchUsr(pParm->GetText())->getFriendList();
            if (aux) {
                pParm = pRoot->FirstChildElement("Recomend");
                while (pParm) {
                    int search = 0;
                    Song auxS;
                    auxS.setName(pParm->GetText());
                    search = this->songList->search(auxS);
                    if (search != 0) {
                        aux->add(pParm->GetText());
                    }
                    pParm = pParm->NextSiblingElement("Recommend");
                }
            }
            saveUserDB();
        }
        pRoot = doc2->FirstChildElement("Edit");
        if (pRoot) {
            Song edit;
            pParm = pRoot->FirstChildElement("Title");
            edit.setName(pParm->GetText());
            int index = 0;
            index = songList->search(edit);
            if(index != 0){
                pParm = pRoot->FirstChildElement("Album");
                edit.setAlbum(pParm->GetText());
                pParm = pRoot->FirstChildElement("Genre");
                edit.setGenre(pParm->GetText());
                pParm = pRoot->FirstChildElement("Artist");
                edit.setArtist(pParm->GetText());
                pParm = pRoot->FirstChildElement("Rating");
                edit.setRating(pParm->GetText());
                this->albumList->del(edit);
                this->albumList->add(edit);
                this->artistTree->remove(edit.getArtist());
                this->artistTree->insert(edit.getArtist());
                this->treeName->deleteValue(edit.getName());
                this->treeName->add(edit.getName(), edit);
            }
        }
        pRoot = doc2->FirstChildElement("Library");
        if(pRoot){
            sendLibrary("../coms/coms.xml", this->sortByTitle());
            this->sendFileJava(8081, "../coms/coms.xml");
            this->pageCount++;

        }
        cout << this->songList->getSize() << endl;
        saveSongInfo();
    }
}

/*!
 * Metodo encargado de cargar toda la informacion de la libreria musical a la hora de iniciar el servidor
 */
void StreamServer::loadSongInfo() {
            using namespace json;
            Object jsonInfo;
            ifstream libInfo("../library/info.json");
            Reader::Read(jsonInfo, libInfo);
            int size = Number(jsonInfo["size"]).Value();
            Array songArray = jsonInfo["library"];
            for(int i = 0; i < size; i++){
                Object tempSong = songArray[i];
                string title = String(tempSong["Title"]).Value();
                string album = String(tempSong["Album"]).Value();
                string genre = String(tempSong["Genre"]).Value();
                string artist = String(tempSong["Artist"]).Value();
                string rating = String(tempSong["Rating"]).Value();
                string fileName = String(tempSong["FileName"]).Value();
                Song songAux(title, artist, rating, "", genre, fileName, album);
                this->addMP3(songAux.getFilename().c_str(), songAux.getName().c_str());
                songAux.setStreamAdress(this->getURL(songAux.getName().c_str()));
                this->songList->add(songAux);
                this->treeName->add(songAux.getName(), songAux);
                this->artistTree->insert(songAux.getArtist());
            }
            cout << this->songList->getSize() << endl;
            this->generateAlbumList();
        }

        /*!
         * Metodo enargado de guardar toda la biblioteca en un archivo json
         */
void StreamServer::saveSongInfo() {
            using namespace json;
            Object jsonInfo;
            Array songArray;
            int size = this->songList->getSize();
            for(int i = 0; i < this->songList->getSize(); i++){
                Object tempSong;
                Song aux = this->songList->get(i);
                tempSong["Title"] = String(aux.getName());
                tempSong["Album"] = String(aux.getAlbum());
                tempSong["Genre"] = String(aux.getGenre());
                tempSong["Artist"] = String(aux.getArtist());
                tempSong["Rating"] = String(aux.getRating());
                tempSong["FileName"] = String(aux.getFilename());
                tempSong["StreamAdress"] = String(aux.getStreamAdress());
                songArray.Insert(tempSong);
            }
            jsonInfo["size"] = Number(size);
            jsonInfo["library"] = songArray;

            ofstream lib;
            lib.open("../library/info.json");
            Writer::Write(jsonInfo, lib);
            lib.close();
}

/*!
 * Metodo encargado de recibir un archivo por socket enviado desde java
 * @param filename ruta y nombre de como se debe guardar el archivo
 * @return
 */
int StreamServer::recieveFile(string filename)
{
    int sockfd, newsockfd, portno;
    socklen_t clilen;
    char buffer[100];
    struct sockaddr_in serv_addr, cli_addr;
    int n;
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0)
        error("ERROR opening socket");
    bzero((char *) &serv_addr, sizeof(serv_addr));
    portno = 8081;
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = INADDR_ANY;
    serv_addr.sin_port = htons(portno);
    if (bind(sockfd, (struct sockaddr *) &serv_addr,
             sizeof(serv_addr)) < 0)
        error("ERROR on binding");
    listen(sockfd,5);
    clilen = sizeof(cli_addr);
    newsockfd = accept(sockfd,
                       (struct sockaddr *) &cli_addr,
                       &clilen);
    if (newsockfd < 0)
        error("ERROR on accept");
    int k = 0;
    std::ofstream file(filename , std::ios::out | std::ios::binary);
    while(true){
        n = recv(newsockfd, buffer, 100, 0);
        k += n;
        std::cout << n << std::endl;
        if(n == 0){
            break;
        }
        file.write(buffer, n);
    }
    file.close();
    printf("Here is the message: %s\n",buffer);
    close(newsockfd);
    close(sockfd);
    cout << "File accepted" << endl;
    return 0;
}


/*!
 * Metodo encargado de guardar en un archivo json toda la informacion de los usuarios
 */
void StreamServer::saveUserDB() {
            this->userTree->toJson();
}

/*!
 * Metodo encargado de generar la listaenlazada del Album;
 */
void StreamServer::generateAlbumList(){
            albumList->delAll();
            albumList = sortByAlbum();
        }

        /*!
         * Metodo encargado de cargar los datos de los usuarios desde el archivo json
         */
void StreamServer::loadUserDB() {
            using namespace json;
            Object jsonData;
            Array jsonArray;
            ifstream file("../coms/userDb.json");
            Reader::Read(jsonData, file);
            file.close();

            int size = Number(jsonData["size"]).Value();
            jsonArray = jsonData["users"];
            for(int i = 0; i < size; i++){
                User aux;
                aux.setUsrName(String(jsonArray[i]["UserName"]).Value());
                if(aux.getUsrName() != "master"){
                    aux.setHashPass(String(jsonArray[i]["Password"]).Value());
                    aux.setAge(String(jsonArray[i]["Age"]).Value());
                    aux.setName(String(jsonArray[i]["Name"]).Value());
                    int contAux = Number(jsonArray[i]["Fsize"]).Value();
                    Array arrayAux = jsonArray[i]["Friend"];
                    for(int j = 0; j < contAux; j++){
                        aux.addFriend(String(arrayAux[j]).Value());
                    }
                    arrayAux = jsonArray[i]["Genre"];
                    contAux = Number(jsonArray[i]["Gsize"]);
                    for(int j = 0; j < contAux; j++){
                        aux.addFavGenre(String(arrayAux[j]).Value());
                    }
                    arrayAux = jsonArray[i]["Recomend"];
                    contAux = Number(jsonArray[i]["Rsize"]);
                    for(int j = 0; j < contAux; j++){
                        aux.addRecomendation(String(arrayAux[j]).Value());
                    }
                    this->userTree->add(aux.getUsrName(), aux);
                }
            }
    return;
}

/*!
 * Metodo encargado de enviar un archivo xml con todos los nombres de los amigos del usuario
 * @param usrName nombre del usuario que se desean obtener los amigos
 */
void StreamServer::sendFriend(string usrName) {
    User *aux = this->userTree->searchUsr(usrName);
    if(aux){
        string xml = "<?xml version=\"1.0\" ?>\n";
        string friendStart = "<Friend>\n";
        string friendEnd = "</Friend>\n";
        xml.append(friendStart);
        for(int i = 0; i < aux->getFriendList().getSize(); i++){
            string fOpen = "    <UserName>";
            string fClose = "</UserName>\n";
            fOpen.append(aux->getFriendList().get(i));
            fOpen.append(fClose);
            xml.append(fOpen);
        }
        xml.append(friendEnd);
        ofstream file("../coms/coms.xml");
        file << xml;
        file.close();
    }
}

/*!
 * metodo encargado de enviar las recomendaciones de un usuario en especifio
 * @param usrName nombre del usuario del que se queiren obtener las recomendaciones
 */
void StreamServer::sendRecomend(string usrName){
    User *aux = this->userTree->searchUsr(usrName);
    if(aux){
        string xml = "<?xml version=\"1.0\" ?>\n";
        string friendStart = "<Recomendations>\n";
        string friendEnd = "</Recomendations>\n";
        xml.append(friendStart);
        for(int i = 0; i < aux->getRecomendation()->getSize(); i++){
            string fOpen = "    <Title>";
            string fClose = "</Title>\n";
            fOpen.append(aux->getRecomendation()->get(i));
            fOpen.append(fClose);
            xml.append(fOpen);
        }
        xml.append(friendEnd);
        ofstream file("../coms/coms.xml");
        file << xml;
        file.close();
    }
}

/*!
 * metodo encargado de verificiar el orden alfabetico entre strings
 * @param wordA palabra 1
 * @param wordB parlabra 1
 * @return true si wordA > wordB
 */
bool comesFirstSwap(std::string wordA, std::string wordB){
    S_List<string> *letter = new S_List<string>;
    letter->add("A");
    letter->add("B");
    letter->add("C");
    letter->add("D");
    letter->add("E");
    letter->add("F");
    letter->add("G");
    letter->add("H");
    letter->add("I");
    letter->add("J");
    letter->add("K");
    letter->add("L");
    letter->add("M");
    letter->add("N");
    letter->add("O");
    letter->add("P");
    letter->add("Q");
    letter->add("R");
    letter->add("S");
    letter->add("T");
    letter->add("U");
    letter->add("V");
    letter->add("W");
    letter->add("X");
    letter->add("Y");
    letter->add("Z");
    for(int i = 0; i < wordA.size(); i++){
        string letter1(&wordA[i]);
        string letter2(&wordB[i]);
        letter1 = toupper(letter1[0]);
        letter2 = toupper(letter2[0]);
        if(letter->search(letter1) > letter->search(letter2)){
            return true;
        }
        if(letter->search(letter1) < letter->search(letter2)){
            return false;
        }
    }
}

/*!
 * metodo encargado de intercambiar datos para el quicksort
 * @param a dato1
 * @param b dato2
 */
void swapQuick(Song* a, Song* b)
{
    Song t = *a;
    *a = *b;
    *b = t;
}

/*!
 * Metodo encargado de partir el array para el quicksort
 * @param arr arreglo a partir
 * @param low indice minimo
 * @param high indice maximo
 * @return indice a partir
 */
int partition (Song arr[], int low, int high)
{
    Song pivot = arr[high];
    int i = (low - 1);

    for (int j = low; j <= high- 1; j++)
    {
        if (!comesFirstSwap(arr[j].getName(), pivot.getName()))
        {
            i++;
            swapQuick(&arr[i], &arr[j]);
        }
    }
    swapQuick(&arr[i + 1], &arr[high]);
    return (i + 1);
}
/*!
 * metodo encargado de realizar el quicksort
 * @param arr arreglo a ordenar
 * @param low indice minimo
 * @param high indice maximo
 */
void quickSort(Song arr[], int low, int high)
{
    if (low < high)
    {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

/*!
 * metodo encargado de mostrar en consola todas las direcciones para hacer streaming
 */
void StreamServer::printAdress() {
    for(int i = 0; i < this->songList->getSize(); i++){
        cout << this->songList->get(i) << endl;
    }
}

/*!
 * metodo encargado de generar el hash tipo hash2015
 * @param pass string a sacarle el hash
 * @return string que sera el hash
 */
string StreamServer::generateHash(std::string pass) {
    S_List<string> *letter = new S_List<string>;
    letter->add("A");
    letter->add("B");
    letter->add("C");
    letter->add("D");
    letter->add("E");
    letter->add("F");
    letter->add("G");
    letter->add("H");
    letter->add("I");
    letter->add("J");
    letter->add("K");
    letter->add("L");
    letter->add("M");
    letter->add("N");
    letter->add("O");
    letter->add("P");
    letter->add("Q");
    letter->add("R");
    letter->add("S");
    letter->add("T");
    letter->add("U");
    letter->add("V");
    letter->add("W");
    letter->add("X");
    letter->add("Y");
    letter->add("1");
    letter->add("2");
    letter->add("3");
    letter->add("4");
    letter->add("5");
    letter->add("6");
    letter->add("7");
    letter->add("8");
    letter->add("9");
    letter->add("0");

    S_List<string> *hash = new S_List<string>;
    for(int i = 0; i < pass.length(); i++){
        hash->add("1");
    }
    for(int i = 0; i < pass.length(); i++){
        string letter1(&pass[i]);
        letter1 = toupper(letter1[0]);
        int index = letter->search(letter1);
        int pos = 35 / index;
        while(pos >= hash->getSize()){
            pos--;
        }
        if(hash->get(pos) == "1"){
            hash->add(letter1, pos);
        }else{
            while(hash->get(pos) != "1"){
                if(pos < hash->getSize()){
                    pos++;
                }else{
                    pos = 0;
                }
            }
            hash->add(letter1, pos);
        }
    }
    string hashPass = "";
    for(int i = 0; i < hash->getSize(); i++){
        hashPass.append(hash->get(i));
    }
    return hashPass;

}

/*!
 * Metodo encargado de cargar una lsita dependiendo del orden que se desea enviar las canciones
 * @param file archivo en el cual guardar el xml
 * @param songList lista ordenada a enviar
 */
void StreamServer::sendLibrary(std::string file, S_List<Song> *songList) {
    string xml = "<?xml version=\"1.0\" ?>\n";
    string libraryStart = "<Library>\n";
    string libraryEnd = "</Library>\n";
    string titleStart = "       <Title>";
    string titleEnd = "</Title>\n";
    string songStart = "    <Song>\n";
    string songEnd = "    </Song>\n";
    string albumStart = "       <Album>";
    string albumEnd = "</Album>\n";
    string artistStart = "      <Artist>";
    string artistEnd = "</Artist>\n";
    string genreStart = "       <Genre>";
    string genreEnd = "</Genre>\n";
    string ratingStart = "      <Rating>";
    string ratingEnd = "</Rating>\n";
    string urlStart = "   <Path>";
    string urlEnd = "</Path>\n";
    xml.append(libraryStart);
    int start = this->pageCount * 10;
    int end = start + 10;
    if(end >= songList->getSize()){
        end = songList->getSize();
        if(songList->getSize() < 10){
            start = 0;
        }
        this->pageCount = 0;
    }
    for(int i = start; i < end; i++){
        xml.append(songStart);
        string topen = titleStart;
        string alopen = albumStart;
        string aropen = artistStart;
        string gopen = genreStart;
        string ropen = ratingStart;
        string uopen = urlStart;
        topen.append(songList->get(i).getName());
        topen.append(titleEnd);
        alopen.append(songList->get(i).getAlbum());
        alopen.append(albumEnd);
        aropen.append(songList->get(i).getArtist());
        aropen.append(artistEnd);
        gopen.append(songList->get(i).getGenre());
        gopen.append(genreEnd);
        ropen.append(songList->get(i).getRating());
        ropen.append(ratingEnd);
        uopen.append(songList->get(i).getStreamAdress());
        uopen.append(urlEnd);
        xml.append(topen);
        xml.append(alopen);
        xml.append(aropen);
        xml.append(gopen);
        xml.append(ropen);
        xml.append(uopen);
        xml.append(songEnd);
    }
    xml.append(libraryEnd);
    ofstream fileWrire(file);
    fileWrire << xml;
    fileWrire.close();
}

/*!
 * Metodo encargado de enviar archivos a java por medio de socket;
 * @param port puerto a abrir el socket
 * @param lfile nombre del archivo a enviar
 * @return
 */
int StreamServer::sendFileJava(int port, char *lfile ){
    int socketDESC;
    struct sockaddr_in serverADDRESS;
    struct hostent *hostINFO;
    FILE * file_to_send;
    int ch;
    char toSEND[1];
    char remoteFILE[4096];
    int count1=1,count2=1, percent;


    hostINFO = gethostbyname("192.168.1.7");
    if (hostINFO == NULL) {
        printf("Problem interpreting host\n");
        return 1;
    }

    socketDESC = socket(AF_INET, SOCK_STREAM, 0);
    if (socketDESC < 0) {
        printf("Cannot create socket\n");
        return 1;
    }

    serverADDRESS.sin_family = hostINFO->h_addrtype;
    memcpy((char *) &serverADDRESS.sin_addr.s_addr,    hostINFO->h_addr_list[0], hostINFO->h_length);
    serverADDRESS.sin_port = htons(port);

    if (connect(socketDESC, (struct sockaddr *) &serverADDRESS, sizeof(serverADDRESS)) < 0) {
    printf("Cannot connect\n");
        return 1;
    }


    file_to_send = fopen (lfile,"r");
    if(!file_to_send) {
        printf("Error opening file\n");
        close(socketDESC);
        return 0;
    } else {
        long fileSIZE;
        fseek (file_to_send, 0, SEEK_END);     fileSIZE =ftell (file_to_send);
        rewind(file_to_send);
        while((ch=getc(file_to_send))!=EOF){
            toSEND[0] = ch;
            send(socketDESC, toSEND, 1, 0);
            if( count1 == count2 ) {
                printf("33[0;0H");
                printf( "\33[2J");
                printf("Filename: %s\n", lfile);
                printf("Filesize: %d Kb\n", fileSIZE / 1024);
            }
        }
    }
    fclose(file_to_send);
    close(socketDESC);
    return 0;
    }


/*!
 * Metodo encargado de crear un archivo xml donde las canciones estaran ordenadas por ell titulo
 */
S_List<Song>* StreamServer::sortByTitle() {
            S_List<Song> *title = new S_List<Song>;
            Song titleArray[songList->getSize()];
            for(int i = 0; i < songList->getSize(); i++){
                titleArray[i] = songList->get(i);
            }
            quickSort(titleArray, 0, songList->getSize() - 1);
            for(int i = 0; i < songList->getSize(); i++){
                title->add(titleArray[i]);
            }
            sendLibrary("../coms/coms.xml", title);
            return title;
}

/*!
 * Metodo encargado de crear un archivo xml donde las canciones estaran ordenadas por ell album
 * @return
 */
S_List<Song>* StreamServer::sortByAlbum() {
    Sorter sorter;
    S_List<Song> *album = new S_List<Song>;
    Song songArray[songList->getSize()];
    for(int i = 0; i < songList->getSize(); i++){
        songArray[i] = songList->get(i);
    }
    sorter.BubbleSort(songArray, this->songList->getSize());
    for(int i = 0; i < songList->getSize(); i++){
        album->add(songArray[i]);
    }
    sendLibrary("../coms/coms.xml", album);
    return album;
}

/*!
 * Metodo encargado de crear un archivo xml donde las canciones estaran ordenadas por el artista
 */
void StreamServer::sortByArtist() {
            Sorter sorter;
            S_List<Song> *artist = new S_List<Song>;
            string artistArray[songList->getSize()];
            for(int i = 0; i < songList->getSize(); i++){
                artistArray[i] = songList->get(i).getArtist();
            }
            sorter.RadixSort(artistArray, songList->getSize());
            for(int i = 0; i < songList->getSize(); i++){
                Song songAux;
                songAux.setArtist(artistArray[i]);
                artist->add(songList->get(songList->search(songAux)));
            }
            sendLibrary("../coms/coms.xml", artist);
        }
