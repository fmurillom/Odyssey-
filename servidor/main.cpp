#include "live/liveMedia/include/liveMedia.hh"
#include "live/BasicUsageEnvironment/include/BasicUsageEnvironment.hh"
#include "live/groupsock/include/GroupsockHelper.hh"
#include <iostream>
#include "include/server.h"
#include "include/BsearchTree.h"

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <fstream>
#include <tinyxml.h>

TiXmlDocument *doc2 = new TiXmlDocument();

void dostuff(int sock, StreamServer *server); /* function prototype */
void error(const char *msg)
{
    perror(msg);
    exit(1);
}

void socketServer(int port, StreamServer *server);


//192.168.1.11
int main(int argc, char *argv[])
{
    StreamServer *server = new StreamServer();
    server->loadUserDB();
    server->loadSongInfo();
    server->sendLibrary("../coms/coms.xml", server->songList);
    cout << "Starting Streaming Server" << endl;
    server->run();
    server->printAdress();
    while(true){
        socketServer(8080, server);
    }
}


void socketServer(int port, StreamServer *server){
    int sockfd, newsockfd, portno;
    socklen_t clilen;
    char buffer[100];
    struct sockaddr_in serv_addr, cli_addr;
    int n;
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0)
        error("ERROR opening socket");
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
        error("ERROR on accept");
    int k = 0;
    std::ofstream file("../coms/coms.xml" , std::ios::out | std::ios::binary);
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
    server->parseXML("../coms/coms.xml", doc2);
    usleep(1000000);
}