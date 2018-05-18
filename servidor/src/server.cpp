//
// Created by fmurillom on 06/05/18.
//

#include "../include/server.h"
#include "../live/liveMedia/include/liveMedia.hh"
#include "../live/BasicUsageEnvironment/include/BasicUsageEnvironment.hh"
#include <pthread.h>
#include <tinyxml.h>
#include <fstream>
#include "../include/cajun/json/reader.h"
#include "../include/cajun/json/writer.h"

void error(const char *msg);

void quickSort(Song arr[], int low, int high);

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


void* StreamServer::listenClose(void* instance) // Will run in its own thread.
{
    StreamServer* inst = (StreamServer*)instance;
    inst->env->taskScheduler().doEventLoop(&(inst->notRunning));
    return NULL;
}


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


bool StreamServer::isRunning() const
{
    return ~notRunning;
}


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

void StreamServer::parseXML(std::string file) {
    TiXmlDocument doc2(file);
    doc2.LoadFile();
    if (true) {
        TiXmlElement *pRoot, *pParm;
        pRoot = doc2.FirstChildElement("Song");
        Song add;
        if (pRoot) {
            pParm = pRoot->FirstChildElement("Title");
            add.setName(pParm->GetText());
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
        }
        pRoot = doc2.FirstChildElement("Register");
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
        pRoot = doc2.FirstChildElement("Delete");
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
    }
    cout << this->songList->getSize() << endl;
    saveSongInfo();
}

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
        }

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

int StreamServer::recieveMetaData(int port) {
    int sockfd, newsockfd, portno;
    socklen_t clilen;
    char buffer[110000];
    struct sockaddr_in serv_addr, cli_addr;
    int n;
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0)
        //error("ERROR opening socket");
    bzero((char *) &serv_addr, sizeof(serv_addr));
    portno = port;
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
        //error("ERROR on accept");
    bzero(buffer, 110000);
    n = read(newsockfd,buffer, 110000);
    this->parseXML(buffer);
    if (n < 0) //error("ERROR reading from socket");
    printf("Here is the message: %s\n",buffer);
    cout << "Entro" << endl;
    n = write(newsockfd,"I got your message",18);
    if (n < 0) //error("ERROR writing to socket");
    close(newsockfd);
    close(sockfd);

    ofstream file;
    file.open("../testing.mp3");
    file.write(buffer, sizeof(buffer));
    return 0;
}

int parseARGS(char **args, char *line){
    int tmp=0;
    args[tmp] = strtok( line, ":" );
    while ( (args[++tmp] = strtok(NULL, ":" ) ) != NULL );
    return tmp - 1;
}

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

void StreamServer::saveUserDB() {
            this->userTree->toJson();
}

void StreamServer::sortByAlbum(){
            S_List<Song> *albumList = new S_List<Song>;
            Song songArray[songList->getSize()];
            for(int i = 0; i < songList->getSize(); i++){
                songArray[i] = songList->get(i);
            }
            int n = songList->getSize();
            quickSort(songArray, 0, n-1);
            for(int i = 0; i < n; i++){
                albumList->add(songArray[i]);
            }
            cout << albumList->getSize() << endl;

        }

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
                    this->userTree->add(aux.getUsrName(), aux);
                }
            }
    return;
}

bool comesFirst(std::string wordA, std::string wordB){
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

void swap(Song* a, Song* b)
{
    Song t = *a;
    *a = *b;
    *b = t;
}

/* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
int partition (Song arr[], int low, int high)
{
    Song pivot = arr[high];    // pivot
    int i = (low - 1);  // Index of smaller element

    for (int j = low; j <= high- 1; j++)
    {
        if (!comesFirst(arr[j].getArtist(), pivot.getArtist()))
        {
            i++;    // increment index of smaller element
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

/* The main function that implements QuickSort
 arr[] --> Array to be sorted,
  low  --> Starting index,
  high  --> Ending index */
void quickSort(Song arr[], int low, int high)
{
    if (low < high)
    {
        /* pi is partitioning index, arr[p] is now
           at right place */
        int pi = partition(arr, low, high);

        // Separately sort elements before
        // partition and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

void StreamServer::printAdress() {
    for(int i = 0; i < this->songList->getSize(); i++){
        cout << this->songList->get(i) << endl;
    }
}

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
    //"1S1OLI11H1"
    return hashPass;

}

void StreamServer::testNewParser(std::string file) {
    TiXmlDocument *doc2 = new TiXmlDocument(file);
    doc2->LoadFile();
    if (true) {
        TiXmlElement *pRoot, *pParm;
        pRoot = doc2->FirstChildElement("Song");
        if (pRoot) {
            Song add;
            pParm = pRoot->FirstChildElement("Title");
            cout << pParm->GetText() << endl;
            pParm = pRoot->FirstChildElement("Album");
            cout << pParm->GetText() << endl;
        }
    }
}