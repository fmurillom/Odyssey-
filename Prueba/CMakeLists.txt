cmake_minimum_required(VERSION 2.6)

PROJECT( live555 )

add_definitions(${GCC_COVERAGE_COMPILE_FLAGS})

SET(EXECUTABLE_OUTPUT_PATH ${live555_SOURCE_DIR}/bin)
SET(LIBRARY_OUTPUT_PATH ${live555_SOURCE_DIR}/lib)
SET(RUNTIME_OUTPUT_DIRECTORY ${live555_SOURCE_DIR}/bin)

set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${live555_SOURCE_DIR}/lib)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${live555_SOURCE_DIR}/bin)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${live555_SOURCE_DIR}/bin)

# includes
SET(live555Includes
${live555_SOURCE_DIR}/live/BasicUsageEnvironment/include
${live555_SOURCE_DIR}/live/groupsock/include
${live555_SOURCE_DIR}/live/liveMedia/include
${live555_SOURCE_DIR}/live/UsageEnvironment/include
)

ADD_SUBDIRECTORY(live)

find_package (Threads)


add_executable(live555 main.cpp include/server.h src/server.cpp)
target_link_libraries(live555 ${CMAKE_SOURCE_DIR}/bin/liblive.so ${CMAKE_THREAD_LIBS_INIT})
add_definitions(${GCC_COVERAGE_LINK_FLAGS})