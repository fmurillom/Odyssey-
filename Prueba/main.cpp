#include "live/liveMedia/include/liveMedia.hh"
#include "live/BasicUsageEnvironment/include/BasicUsageEnvironment.hh"
#include "live/groupsock/include/GroupsockHelper.hh"
#include <iostream>
#include "include/server.h"

///////////////////////////////////////////////////////////////////////////////
// TESTS
int main()
{
    StreamServer stream;
    int retval = 0;

    // This is how we add files to the streaming server. Both these files
    // should exist in our working directory.
    stream.addMP3("../test.mp3", "test_mp3");
    std::cout << stream.getURL("test_mp3") << std::endl;
    stream.run();
    //stream.stop();
    while(true){
        std::cout << stream.getURL("test_mp3") << std::endl;
    }

    return 0;
}
