# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.10

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /snap/clion/19/bin/cmake/bin/cmake

# The command to remove a file.
RM = /snap/clion/19/bin/cmake/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/fmurillom/Documents/Tec/DatosII/Prueba

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug

# Include any dependencies generated for this target.
include live/testProgs/CMakeFiles/testH264VideoStreamer.dir/depend.make

# Include the progress variables for this target.
include live/testProgs/CMakeFiles/testH264VideoStreamer.dir/progress.make

# Include the compile flags for this target's objects.
include live/testProgs/CMakeFiles/testH264VideoStreamer.dir/flags.make

live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o: live/testProgs/CMakeFiles/testH264VideoStreamer.dir/flags.make
live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o: ../live/testProgs/testH264VideoStreamer.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o"
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs && /usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o -c /home/fmurillom/Documents/Tec/DatosII/Prueba/live/testProgs/testH264VideoStreamer.cpp

live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.i"
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/fmurillom/Documents/Tec/DatosII/Prueba/live/testProgs/testH264VideoStreamer.cpp > CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.i

live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.s"
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/fmurillom/Documents/Tec/DatosII/Prueba/live/testProgs/testH264VideoStreamer.cpp -o CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.s

live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o.requires:

.PHONY : live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o.requires

live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o.provides: live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o.requires
	$(MAKE) -f live/testProgs/CMakeFiles/testH264VideoStreamer.dir/build.make live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o.provides.build
.PHONY : live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o.provides

live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o.provides.build: live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o


# Object files for target testH264VideoStreamer
testH264VideoStreamer_OBJECTS = \
"CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o"

# External object files for target testH264VideoStreamer
testH264VideoStreamer_EXTERNAL_OBJECTS =

../bin/testH264VideoStreamer: live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o
../bin/testH264VideoStreamer: live/testProgs/CMakeFiles/testH264VideoStreamer.dir/build.make
../bin/testH264VideoStreamer: ../lib/libBasicUsageEnvironment.a
../bin/testH264VideoStreamer: ../lib/libgroupsock.a
../bin/testH264VideoStreamer: ../lib/libliveMedia.a
../bin/testH264VideoStreamer: ../lib/libUsageEnvironment.a
../bin/testH264VideoStreamer: live/testProgs/CMakeFiles/testH264VideoStreamer.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable ../../../bin/testH264VideoStreamer"
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/testH264VideoStreamer.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
live/testProgs/CMakeFiles/testH264VideoStreamer.dir/build: ../bin/testH264VideoStreamer

.PHONY : live/testProgs/CMakeFiles/testH264VideoStreamer.dir/build

live/testProgs/CMakeFiles/testH264VideoStreamer.dir/requires: live/testProgs/CMakeFiles/testH264VideoStreamer.dir/testH264VideoStreamer.cpp.o.requires

.PHONY : live/testProgs/CMakeFiles/testH264VideoStreamer.dir/requires

live/testProgs/CMakeFiles/testH264VideoStreamer.dir/clean:
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs && $(CMAKE_COMMAND) -P CMakeFiles/testH264VideoStreamer.dir/cmake_clean.cmake
.PHONY : live/testProgs/CMakeFiles/testH264VideoStreamer.dir/clean

live/testProgs/CMakeFiles/testH264VideoStreamer.dir/depend:
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/fmurillom/Documents/Tec/DatosII/Prueba /home/fmurillom/Documents/Tec/DatosII/Prueba/live/testProgs /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs/CMakeFiles/testH264VideoStreamer.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : live/testProgs/CMakeFiles/testH264VideoStreamer.dir/depend
