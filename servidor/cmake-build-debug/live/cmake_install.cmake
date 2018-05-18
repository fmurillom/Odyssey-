# Install script for directory: /home/fmurillom/Documents/Tec/DatosII/Prueba/live

# Set the install prefix
if(NOT DEFINED CMAKE_INSTALL_PREFIX)
  set(CMAKE_INSTALL_PREFIX "/usr/local")
endif()
string(REGEX REPLACE "/$" "" CMAKE_INSTALL_PREFIX "${CMAKE_INSTALL_PREFIX}")

# Set the install configuration name.
if(NOT DEFINED CMAKE_INSTALL_CONFIG_NAME)
  if(BUILD_TYPE)
    string(REGEX REPLACE "^[^A-Za-z0-9_]+" ""
           CMAKE_INSTALL_CONFIG_NAME "${BUILD_TYPE}")
  else()
    set(CMAKE_INSTALL_CONFIG_NAME "Debug")
  endif()
  message(STATUS "Install configuration: \"${CMAKE_INSTALL_CONFIG_NAME}\"")
endif()

# Set the component getting installed.
if(NOT CMAKE_INSTALL_COMPONENT)
  if(COMPONENT)
    message(STATUS "Install component: \"${COMPONENT}\"")
    set(CMAKE_INSTALL_COMPONENT "${COMPONENT}")
  else()
    set(CMAKE_INSTALL_COMPONENT)
  endif()
endif()

# Install shared libraries without execute permission?
if(NOT DEFINED CMAKE_INSTALL_SO_NO_EXE)
  set(CMAKE_INSTALL_SO_NO_EXE "1")
endif()

# Is this installation the result of a crosscompile?
if(NOT DEFINED CMAKE_CROSSCOMPILING)
  set(CMAKE_CROSSCOMPILING "FALSE")
endif()

if("x${CMAKE_INSTALL_COMPONENT}x" STREQUAL "xUnspecifiedx" OR NOT CMAKE_INSTALL_COMPONENT)
  list(APPEND CMAKE_ABSOLUTE_DESTINATION_FILES
   "/usr/local/include/live555/UsageEnvironment/Boolean.hh;/usr/local/include/live555/UsageEnvironment/HashTable.hh;/usr/local/include/live555/UsageEnvironment/strDup.hh;/usr/local/include/live555/UsageEnvironment/UsageEnvironment.hh;/usr/local/include/live555/UsageEnvironment/UsageEnvironment_version.hh")
  if(CMAKE_WARN_ON_ABSOLUTE_INSTALL_DESTINATION)
    message(WARNING "ABSOLUTE path INSTALL DESTINATION : ${CMAKE_ABSOLUTE_DESTINATION_FILES}")
  endif()
  if(CMAKE_ERROR_ON_ABSOLUTE_INSTALL_DESTINATION)
    message(FATAL_ERROR "ABSOLUTE path INSTALL DESTINATION forbidden (by caller): ${CMAKE_ABSOLUTE_DESTINATION_FILES}")
  endif()
file(INSTALL DESTINATION "/usr/local/include/live555/UsageEnvironment" TYPE FILE FILES
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/UsageEnvironment/include/Boolean.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/UsageEnvironment/include/HashTable.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/UsageEnvironment/include/strDup.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/UsageEnvironment/include/UsageEnvironment.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/UsageEnvironment/include/UsageEnvironment_version.hh"
    )
endif()

if("x${CMAKE_INSTALL_COMPONENT}x" STREQUAL "xUnspecifiedx" OR NOT CMAKE_INSTALL_COMPONENT)
  list(APPEND CMAKE_ABSOLUTE_DESTINATION_FILES
   "/usr/local/include/live555/BasicUsageEnvironment/BasicHashTable.hh;/usr/local/include/live555/BasicUsageEnvironment/BasicUsageEnvironment.hh;/usr/local/include/live555/BasicUsageEnvironment/BasicUsageEnvironment_version.hh;/usr/local/include/live555/BasicUsageEnvironment/BasicUsageEnvironment0.hh;/usr/local/include/live555/BasicUsageEnvironment/DelayQueue.hh;/usr/local/include/live555/BasicUsageEnvironment/HandlerSet.hh")
  if(CMAKE_WARN_ON_ABSOLUTE_INSTALL_DESTINATION)
    message(WARNING "ABSOLUTE path INSTALL DESTINATION : ${CMAKE_ABSOLUTE_DESTINATION_FILES}")
  endif()
  if(CMAKE_ERROR_ON_ABSOLUTE_INSTALL_DESTINATION)
    message(FATAL_ERROR "ABSOLUTE path INSTALL DESTINATION forbidden (by caller): ${CMAKE_ABSOLUTE_DESTINATION_FILES}")
  endif()
file(INSTALL DESTINATION "/usr/local/include/live555/BasicUsageEnvironment" TYPE FILE FILES
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/BasicUsageEnvironment/include/BasicHashTable.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/BasicUsageEnvironment/include/BasicUsageEnvironment.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/BasicUsageEnvironment/include/BasicUsageEnvironment_version.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/BasicUsageEnvironment/include/BasicUsageEnvironment0.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/BasicUsageEnvironment/include/DelayQueue.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/BasicUsageEnvironment/include/HandlerSet.hh"
    )
endif()

if("x${CMAKE_INSTALL_COMPONENT}x" STREQUAL "xUnspecifiedx" OR NOT CMAKE_INSTALL_COMPONENT)
  list(APPEND CMAKE_ABSOLUTE_DESTINATION_FILES
   "/usr/local/include/live555/groupsock/GroupEId.hh;/usr/local/include/live555/groupsock/Groupsock.hh;/usr/local/include/live555/groupsock/groupsock_version.hh;/usr/local/include/live555/groupsock/GroupsockHelper.hh;/usr/local/include/live555/groupsock/IOHandlers.hh;/usr/local/include/live555/groupsock/NetAddress.hh;/usr/local/include/live555/groupsock/NetCommon.h;/usr/local/include/live555/groupsock/NetInterface.hh;/usr/local/include/live555/groupsock/TunnelEncaps.hh")
  if(CMAKE_WARN_ON_ABSOLUTE_INSTALL_DESTINATION)
    message(WARNING "ABSOLUTE path INSTALL DESTINATION : ${CMAKE_ABSOLUTE_DESTINATION_FILES}")
  endif()
  if(CMAKE_ERROR_ON_ABSOLUTE_INSTALL_DESTINATION)
    message(FATAL_ERROR "ABSOLUTE path INSTALL DESTINATION forbidden (by caller): ${CMAKE_ABSOLUTE_DESTINATION_FILES}")
  endif()
file(INSTALL DESTINATION "/usr/local/include/live555/groupsock" TYPE FILE FILES
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/groupsock/include/GroupEId.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/groupsock/include/Groupsock.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/groupsock/include/groupsock_version.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/groupsock/include/GroupsockHelper.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/groupsock/include/IOHandlers.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/groupsock/include/NetAddress.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/groupsock/include/NetCommon.h"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/groupsock/include/NetInterface.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/groupsock/include/TunnelEncaps.hh"
    )
endif()

if("x${CMAKE_INSTALL_COMPONENT}x" STREQUAL "xUnspecifiedx" OR NOT CMAKE_INSTALL_COMPONENT)
  list(APPEND CMAKE_ABSOLUTE_DESTINATION_FILES
   "/usr/local/include/live555/liveMedia/AC3AudioFileServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/AC3AudioRTPSink.hh;/usr/local/include/live555/liveMedia/AC3AudioRTPSource.hh;/usr/local/include/live555/liveMedia/AC3AudioStreamFramer.hh;/usr/local/include/live555/liveMedia/ADTSAudioFileServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/ADTSAudioFileSource.hh;/usr/local/include/live555/liveMedia/AMRAudioFileServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/AMRAudioFileSink.hh;/usr/local/include/live555/liveMedia/AMRAudioFileSource.hh;/usr/local/include/live555/liveMedia/AMRAudioRTPSink.hh;/usr/local/include/live555/liveMedia/AMRAudioRTPSource.hh;/usr/local/include/live555/liveMedia/AMRAudioSource.hh;/usr/local/include/live555/liveMedia/AudioInputDevice.hh;/usr/local/include/live555/liveMedia/AudioRTPSink.hh;/usr/local/include/live555/liveMedia/AVIFileSink.hh;/usr/local/include/live555/liveMedia/Base64.hh;/usr/local/include/live555/liveMedia/BasicUDPSink.hh;/usr/local/include/live555/liveMedia/BasicUDPSource.hh;/usr/local/include/live555/liveMedia/BitVector.hh;/usr/local/include/live555/liveMedia/ByteStreamFileSource.hh;/usr/local/include/live555/liveMedia/ByteStreamMemoryBufferSource.hh;/usr/local/include/live555/liveMedia/ByteStreamMultiFileSource.hh;/usr/local/include/live555/liveMedia/DeviceSource.hh;/usr/local/include/live555/liveMedia/DigestAuthentication.hh;/usr/local/include/live555/liveMedia/DVVideoFileServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/DVVideoRTPSink.hh;/usr/local/include/live555/liveMedia/DVVideoRTPSource.hh;/usr/local/include/live555/liveMedia/DVVideoStreamFramer.hh;/usr/local/include/live555/liveMedia/export.h;/usr/local/include/live555/liveMedia/FileServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/FileSink.hh;/usr/local/include/live555/liveMedia/FramedFileSource.hh;/usr/local/include/live555/liveMedia/FramedFilter.hh;/usr/local/include/live555/liveMedia/FramedSource.hh;/usr/local/include/live555/liveMedia/GenericMediaServer.hh;/usr/local/include/live555/liveMedia/GSMAudioRTPSink.hh;/usr/local/include/live555/liveMedia/H261VideoRTPSource.hh;/usr/local/include/live555/liveMedia/H263plusVideoFileServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/H263plusVideoRTPSink.hh;/usr/local/include/live555/liveMedia/H263plusVideoRTPSource.hh;/usr/local/include/live555/liveMedia/H263plusVideoStreamFramer.hh;/usr/local/include/live555/liveMedia/H264or5VideoFileSink.hh;/usr/local/include/live555/liveMedia/H264or5VideoRTPSink.hh;/usr/local/include/live555/liveMedia/H264or5VideoStreamDiscreteFramer.hh;/usr/local/include/live555/liveMedia/H264or5VideoStreamFramer.hh;/usr/local/include/live555/liveMedia/H264VideoFileServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/H264VideoFileSink.hh;/usr/local/include/live555/liveMedia/H264VideoRTPSink.hh;/usr/local/include/live555/liveMedia/H264VideoRTPSource.hh;/usr/local/include/live555/liveMedia/H264VideoStreamDiscreteFramer.hh;/usr/local/include/live555/liveMedia/H264VideoStreamFramer.hh;/usr/local/include/live555/liveMedia/H265VideoFileServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/H265VideoFileSink.hh;/usr/local/include/live555/liveMedia/H265VideoRTPSink.hh;/usr/local/include/live555/liveMedia/H265VideoRTPSource.hh;/usr/local/include/live555/liveMedia/H265VideoStreamDiscreteFramer.hh;/usr/local/include/live555/liveMedia/H265VideoStreamFramer.hh;/usr/local/include/live555/liveMedia/InputFile.hh;/usr/local/include/live555/liveMedia/JPEGVideoRTPSink.hh;/usr/local/include/live555/liveMedia/JPEGVideoRTPSource.hh;/usr/local/include/live555/liveMedia/JPEGVideoSource.hh;/usr/local/include/live555/liveMedia/liveMedia.hh;/usr/local/include/live555/liveMedia/liveMedia_version.hh;/usr/local/include/live555/liveMedia/Locale.hh;/usr/local/include/live555/liveMedia/MatroskaFile.hh;/usr/local/include/live555/liveMedia/MatroskaFileServerDemux.hh;/usr/local/include/live555/liveMedia/Media.hh;/usr/local/include/live555/liveMedia/MediaSession.hh;/usr/local/include/live555/liveMedia/MediaSink.hh;/usr/local/include/live555/liveMedia/MediaSource.hh;/usr/local/include/live555/liveMedia/MediaTranscodingTable.hh;/usr/local/include/live555/liveMedia/MP3ADU.hh;/usr/local/include/live555/liveMedia/MP3ADUinterleaving.hh;/usr/local/include/live555/liveMedia/MP3ADURTPSink.hh;/usr/local/include/live555/liveMedia/MP3ADURTPSource.hh;/usr/local/include/live555/liveMedia/MP3ADUTranscoder.hh;/usr/local/include/live555/liveMedia/MP3AudioFileServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/MP3FileSource.hh;/usr/local/include/live555/liveMedia/MP3Transcoder.hh;/usr/local/include/live555/liveMedia/MPEG1or2AudioRTPSink.hh;/usr/local/include/live555/liveMedia/MPEG1or2AudioRTPSource.hh;/usr/local/include/live555/liveMedia/MPEG1or2AudioStreamFramer.hh;/usr/local/include/live555/liveMedia/MPEG1or2Demux.hh;/usr/local/include/live555/liveMedia/MPEG1or2DemuxedElementaryStream.hh;/usr/local/include/live555/liveMedia/MPEG1or2DemuxedServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/MPEG1or2FileServerDemux.hh;/usr/local/include/live555/liveMedia/MPEG1or2VideoFileServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/MPEG1or2VideoRTPSink.hh;/usr/local/include/live555/liveMedia/MPEG1or2VideoRTPSource.hh;/usr/local/include/live555/liveMedia/MPEG1or2VideoStreamDiscreteFramer.hh;/usr/local/include/live555/liveMedia/MPEG1or2VideoStreamFramer.hh;/usr/local/include/live555/liveMedia/MPEG2IndexFromTransportStream.hh;/usr/local/include/live555/liveMedia/MPEG2TransportFileServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/MPEG2TransportStreamAccumulator.hh;/usr/local/include/live555/liveMedia/MPEG2TransportStreamFramer.hh;/usr/local/include/live555/liveMedia/MPEG2TransportStreamFromESSource.hh;/usr/local/include/live555/liveMedia/MPEG2TransportStreamFromPESSource.hh;/usr/local/include/live555/liveMedia/MPEG2TransportStreamIndexFile.hh;/usr/local/include/live555/liveMedia/MPEG2TransportStreamMultiplexor.hh;/usr/local/include/live555/liveMedia/MPEG2TransportStreamTrickModeFilter.hh;/usr/local/include/live555/liveMedia/MPEG2TransportUDPServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/MPEG4ESVideoRTPSink.hh;/usr/local/include/live555/liveMedia/MPEG4ESVideoRTPSource.hh;/usr/local/include/live555/liveMedia/MPEG4GenericRTPSink.hh;/usr/local/include/live555/liveMedia/MPEG4GenericRTPSource.hh;/usr/local/include/live555/liveMedia/MPEG4LATMAudioRTPSink.hh;/usr/local/include/live555/liveMedia/MPEG4LATMAudioRTPSource.hh;/usr/local/include/live555/liveMedia/MPEG4VideoFileServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/MPEG4VideoStreamDiscreteFramer.hh;/usr/local/include/live555/liveMedia/MPEG4VideoStreamFramer.hh;/usr/local/include/live555/liveMedia/MPEGVideoStreamFramer.hh;/usr/local/include/live555/liveMedia/MultiFramedRTPSink.hh;/usr/local/include/live555/liveMedia/MultiFramedRTPSource.hh;/usr/local/include/live555/liveMedia/OggFile.hh;/usr/local/include/live555/liveMedia/OggFileServerDemux.hh;/usr/local/include/live555/liveMedia/OggFileSink.hh;/usr/local/include/live555/liveMedia/OnDemandServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/ourMD5.hh;/usr/local/include/live555/liveMedia/OutputFile.hh;/usr/local/include/live555/liveMedia/PassiveServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/ProxyServerMediaSession.hh;/usr/local/include/live555/liveMedia/QCELPAudioRTPSource.hh;/usr/local/include/live555/liveMedia/QuickTimeFileSink.hh;/usr/local/include/live555/liveMedia/QuickTimeGenericRTPSource.hh;/usr/local/include/live555/liveMedia/RTCP.hh;/usr/local/include/live555/liveMedia/RTPInterface.hh;/usr/local/include/live555/liveMedia/RTPSink.hh;/usr/local/include/live555/liveMedia/RTPSource.hh;/usr/local/include/live555/liveMedia/RTSPClient.hh;/usr/local/include/live555/liveMedia/RTSPCommon.hh;/usr/local/include/live555/liveMedia/RTSPRegisterSender.hh;/usr/local/include/live555/liveMedia/RTSPServer.hh;/usr/local/include/live555/liveMedia/RTSPServerSupportingHTTPStreaming.hh;/usr/local/include/live555/liveMedia/ServerMediaSession.hh;/usr/local/include/live555/liveMedia/SimpleRTPSink.hh;/usr/local/include/live555/liveMedia/SimpleRTPSource.hh;/usr/local/include/live555/liveMedia/SIPClient.hh;/usr/local/include/live555/liveMedia/StreamReplicator.hh;/usr/local/include/live555/liveMedia/T140TextRTPSink.hh;/usr/local/include/live555/liveMedia/TCPStreamSink.hh;/usr/local/include/live555/liveMedia/TextRTPSink.hh;/usr/local/include/live555/liveMedia/TheoraVideoRTPSink.hh;/usr/local/include/live555/liveMedia/TheoraVideoRTPSource.hh;/usr/local/include/live555/liveMedia/uLawAudioFilter.hh;/usr/local/include/live555/liveMedia/VideoRTPSink.hh;/usr/local/include/live555/liveMedia/VorbisAudioRTPSink.hh;/usr/local/include/live555/liveMedia/VorbisAudioRTPSource.hh;/usr/local/include/live555/liveMedia/VP8VideoRTPSink.hh;/usr/local/include/live555/liveMedia/VP8VideoRTPSource.hh;/usr/local/include/live555/liveMedia/VP9VideoRTPSink.hh;/usr/local/include/live555/liveMedia/VP9VideoRTPSource.hh;/usr/local/include/live555/liveMedia/WAVAudioFileServerMediaSubsession.hh;/usr/local/include/live555/liveMedia/WAVAudioFileSource.hh")
  if(CMAKE_WARN_ON_ABSOLUTE_INSTALL_DESTINATION)
    message(WARNING "ABSOLUTE path INSTALL DESTINATION : ${CMAKE_ABSOLUTE_DESTINATION_FILES}")
  endif()
  if(CMAKE_ERROR_ON_ABSOLUTE_INSTALL_DESTINATION)
    message(FATAL_ERROR "ABSOLUTE path INSTALL DESTINATION forbidden (by caller): ${CMAKE_ABSOLUTE_DESTINATION_FILES}")
  endif()
file(INSTALL DESTINATION "/usr/local/include/live555/liveMedia" TYPE FILE FILES
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/AC3AudioFileServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/AC3AudioRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/AC3AudioRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/AC3AudioStreamFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/ADTSAudioFileServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/ADTSAudioFileSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/AMRAudioFileServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/AMRAudioFileSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/AMRAudioFileSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/AMRAudioRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/AMRAudioRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/AMRAudioSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/AudioInputDevice.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/AudioRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/AVIFileSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/Base64.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/BasicUDPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/BasicUDPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/BitVector.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/ByteStreamFileSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/ByteStreamMemoryBufferSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/ByteStreamMultiFileSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/DeviceSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/DigestAuthentication.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/DVVideoFileServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/DVVideoRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/DVVideoRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/DVVideoStreamFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/export.h"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/FileServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/FileSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/FramedFileSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/FramedFilter.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/FramedSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/GenericMediaServer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/GSMAudioRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H261VideoRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H263plusVideoFileServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H263plusVideoRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H263plusVideoRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H263plusVideoStreamFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H264or5VideoFileSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H264or5VideoRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H264or5VideoStreamDiscreteFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H264or5VideoStreamFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H264VideoFileServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H264VideoFileSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H264VideoRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H264VideoRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H264VideoStreamDiscreteFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H264VideoStreamFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H265VideoFileServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H265VideoFileSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H265VideoRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H265VideoRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H265VideoStreamDiscreteFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/H265VideoStreamFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/InputFile.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/JPEGVideoRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/JPEGVideoRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/JPEGVideoSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/liveMedia.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/liveMedia_version.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/Locale.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MatroskaFile.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MatroskaFileServerDemux.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/Media.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MediaSession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MediaSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MediaSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MediaTranscodingTable.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MP3ADU.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MP3ADUinterleaving.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MP3ADURTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MP3ADURTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MP3ADUTranscoder.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MP3AudioFileServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MP3FileSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MP3Transcoder.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG1or2AudioRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG1or2AudioRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG1or2AudioStreamFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG1or2Demux.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG1or2DemuxedElementaryStream.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG1or2DemuxedServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG1or2FileServerDemux.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG1or2VideoFileServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG1or2VideoRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG1or2VideoRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG1or2VideoStreamDiscreteFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG1or2VideoStreamFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG2IndexFromTransportStream.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG2TransportFileServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG2TransportStreamAccumulator.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG2TransportStreamFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG2TransportStreamFromESSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG2TransportStreamFromPESSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG2TransportStreamIndexFile.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG2TransportStreamMultiplexor.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG2TransportStreamTrickModeFilter.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG2TransportUDPServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG4ESVideoRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG4ESVideoRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG4GenericRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG4GenericRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG4LATMAudioRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG4LATMAudioRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG4VideoFileServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG4VideoStreamDiscreteFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEG4VideoStreamFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MPEGVideoStreamFramer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MultiFramedRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/MultiFramedRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/OggFile.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/OggFileServerDemux.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/OggFileSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/OnDemandServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/ourMD5.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/OutputFile.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/PassiveServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/ProxyServerMediaSession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/QCELPAudioRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/QuickTimeFileSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/QuickTimeGenericRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/RTCP.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/RTPInterface.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/RTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/RTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/RTSPClient.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/RTSPCommon.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/RTSPRegisterSender.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/RTSPServer.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/RTSPServerSupportingHTTPStreaming.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/ServerMediaSession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/SimpleRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/SimpleRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/SIPClient.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/StreamReplicator.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/T140TextRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/TCPStreamSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/TextRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/TheoraVideoRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/TheoraVideoRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/uLawAudioFilter.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/VideoRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/VorbisAudioRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/VorbisAudioRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/VP8VideoRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/VP8VideoRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/VP9VideoRTPSink.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/VP9VideoRTPSource.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/WAVAudioFileServerMediaSubsession.hh"
    "/home/fmurillom/Documents/Tec/DatosII/Prueba/live/liveMedia/include/WAVAudioFileSource.hh"
    )
endif()

if("x${CMAKE_INSTALL_COMPONENT}x" STREQUAL "xUnspecifiedx" OR NOT CMAKE_INSTALL_COMPONENT)
  if(EXISTS "$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/liblive666-debug.so" AND
     NOT IS_SYMLINK "$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/liblive666-debug.so")
    file(RPATH_CHECK
         FILE "$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/liblive666-debug.so"
         RPATH "")
  endif()
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/lib" TYPE SHARED_LIBRARY FILES "/home/fmurillom/Documents/Tec/DatosII/Prueba/bin/liblive666-debug.so")
  if(EXISTS "$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/liblive666-debug.so" AND
     NOT IS_SYMLINK "$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/liblive666-debug.so")
    if(CMAKE_INSTALL_DO_STRIP)
      execute_process(COMMAND "/usr/bin/strip" "$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/liblive666-debug.so")
    endif()
  endif()
endif()

