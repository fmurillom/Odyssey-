cmake_minimum_required(VERSION 3.9)
project(servidor)

set(CMAKE_CXX_STANDARD 11)

add_executable(servidor main.cpp)

target_link_libraries(servidor -lcppcms)