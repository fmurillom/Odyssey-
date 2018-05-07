//
// Created by fmurillom on 06/05/18.
//

#include "../include/server.h"
#include "../live/liveMedia/include/liveMedia.hh"
#include "../live/BasicUsageEnvironment/include/BasicUsageEnvironment.hh"
#include <pthread.h>

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
        // TODO: This join does not seem to finish if there is no
        //       client activity.
        //pthread_join(thread, NULL);
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