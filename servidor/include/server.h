//
// Created by fmurillom on 06/05/18.
//

#ifndef LIVE555_SERVER_H
#define LIVE555_SERVER_H

#include "../live/liveMedia/include/liveMedia.hh"
#include "../live/BasicUsageEnvironment/include/BasicUsageEnvironment.hh"
#include "BsearchTree.h"
#include "AVLTree.h"

#define PORT 8080

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

    void parseXML(std::string parse);

    void loadSongInfo();

    void loadUserDB();

    int recieveMetaData(int port);

    void printAdress();

    void sortByAlbum();

    string generateHash(std::string pass);

    void testNewParser(std::string file);

private:
    const int port;
    RTSPServer* rtsp;
    UsageEnvironment* env;
    char notRunning;
    pthread_t thread;
    BsearchTree<string, Song> *treeName;
    AVLTree *artistTree;
    static void* listenClose(void* inst);
    void saveUserDB();

    void saveSongInfo();


};


#endif //LIVE555_SERVER_H
