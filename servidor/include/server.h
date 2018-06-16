//
// Created by fmurillom on 06/05/18.
//

#ifndef LIVE555_SERVER_H
#define LIVE555_SERVER_H

#include <tinyxml.h>
#include "../live/liveMedia/include/liveMedia.hh"
#include "../live/BasicUsageEnvironment/include/BasicUsageEnvironment.hh"
#include "BsearchTree.h"
#include "AVLTree.h"
#include "Connector.h"


class StreamServerError {};
class StreamServerRunError {};
class StreamServerNameError {};



class StreamServer
{
public:
    S_List<Song> *songList;

    S_List<Song> *albumList;

    BsearchTree<std::string, User> *userTree;

    StreamServer(int port = 8544)
    throw(StreamServerError);

    ~StreamServer();

    void addMP3(char const* file, char const* name)
    throw(StreamServerRunError);

    void addMPEGVideo(char const* file, char const* name)
    throw(StreamServerRunError);

    void addMKV(char const* file, char const* name)throw(StreamServerRunError);

    void addMPEG(char const* file, char const* name)
    throw(StreamServerRunError);

    void run()
    throw(StreamServerRunError);

    void stop()
    throw(StreamServerRunError);

    void remove(char const* name)
    throw(StreamServerRunError);

    const char* getURL(char const* name) const
    throw(StreamServerNameError);

    bool isRunning() const;

    int recieveFile(std::string filename);

    void parseXML(std::string parse, TiXmlDocument *doc2);

    void loadSongInfo();

    void loadUserDB();

    int recieveMetaData(int port);

    void printAdress();

    void generateAlbumList();

    string generateHash(std::string pass);

    void sendLibrary(std::string file, S_List<Song> *songList);

    S_List<Song>* sortByAlbum();

    S_List<Song>* sortByArtist();

    S_List<Song>* sortByTitle();

    void sendFriend(string usrName);

    void sendRecomend(string usrName);

    UsageEnvironment* getEnv();

private:
    const int port;

    RTSPServer* rtsp;

    UsageEnvironment* env;

    char notRunning;

    pthread_t thread;

    BsearchTree<string, Song> *treeName;

    AVLTree *artistTree;

    Connector *c;

    bool login;

    static void* listenClose(void* inst);

    void saveUserDB();

    void saveSongInfo();

    void sendLoginInfo(string status);

    int sendFileJava(int port, char *lfile);

    int pageCount;


    void query(std::string query);

    void sendUsrs();

    void usrXML(S_List<string> *usrs);

    void recXML(S_List<string> *recList);




};


#endif //LIVE555_SERVER_H
