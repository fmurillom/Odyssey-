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
include live/testProgs/CMakeFiles/openRTSP.dir/depend.make

# Include the progress variables for this target.
include live/testProgs/CMakeFiles/openRTSP.dir/progress.make

# Include the compile flags for this target's objects.
include live/testProgs/CMakeFiles/openRTSP.dir/flags.make

live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.o: live/testProgs/CMakeFiles/openRTSP.dir/flags.make
live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.o: ../live/testProgs/openRTSP.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.o"
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs && /usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/openRTSP.dir/openRTSP.cpp.o -c /home/fmurillom/Documents/Tec/DatosII/Prueba/live/testProgs/openRTSP.cpp

live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/openRTSP.dir/openRTSP.cpp.i"
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/fmurillom/Documents/Tec/DatosII/Prueba/live/testProgs/openRTSP.cpp > CMakeFiles/openRTSP.dir/openRTSP.cpp.i

live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/openRTSP.dir/openRTSP.cpp.s"
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/fmurillom/Documents/Tec/DatosII/Prueba/live/testProgs/openRTSP.cpp -o CMakeFiles/openRTSP.dir/openRTSP.cpp.s

live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.o.requires:

.PHONY : live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.o.requires

live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.o.provides: live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.o.requires
	$(MAKE) -f live/testProgs/CMakeFiles/openRTSP.dir/build.make live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.o.provides.build
.PHONY : live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.o.provides

live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.o.provides.build: live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.o


live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.o: live/testProgs/CMakeFiles/openRTSP.dir/flags.make
live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.o: ../live/testProgs/playCommon.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.o"
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs && /usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/openRTSP.dir/playCommon.cpp.o -c /home/fmurillom/Documents/Tec/DatosII/Prueba/live/testProgs/playCommon.cpp

live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/openRTSP.dir/playCommon.cpp.i"
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/fmurillom/Documents/Tec/DatosII/Prueba/live/testProgs/playCommon.cpp > CMakeFiles/openRTSP.dir/playCommon.cpp.i

live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/openRTSP.dir/playCommon.cpp.s"
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/fmurillom/Documents/Tec/DatosII/Prueba/live/testProgs/playCommon.cpp -o CMakeFiles/openRTSP.dir/playCommon.cpp.s

live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.o.requires:

.PHONY : live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.o.requires

live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.o.provides: live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.o.requires
	$(MAKE) -f live/testProgs/CMakeFiles/openRTSP.dir/build.make live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.o.provides.build
.PHONY : live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.o.provides

live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.o.provides.build: live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.o


# Object files for target openRTSP
openRTSP_OBJECTS = \
"CMakeFiles/openRTSP.dir/openRTSP.cpp.o" \
"CMakeFiles/openRTSP.dir/playCommon.cpp.o"

# External object files for target openRTSP
openRTSP_EXTERNAL_OBJECTS =

../bin/openRTSP: live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.o
../bin/openRTSP: live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.o
../bin/openRTSP: live/testProgs/CMakeFiles/openRTSP.dir/build.make
../bin/openRTSP: ../lib/libBasicUsageEnvironment.a
../bin/openRTSP: ../lib/libgroupsock.a
../bin/openRTSP: ../lib/libliveMedia.a
../bin/openRTSP: ../lib/libUsageEnvironment.a
../bin/openRTSP: live/testProgs/CMakeFiles/openRTSP.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX executable ../../../bin/openRTSP"
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/openRTSP.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
live/testProgs/CMakeFiles/openRTSP.dir/build: ../bin/openRTSP

.PHONY : live/testProgs/CMakeFiles/openRTSP.dir/build

live/testProgs/CMakeFiles/openRTSP.dir/requires: live/testProgs/CMakeFiles/openRTSP.dir/openRTSP.cpp.o.requires
live/testProgs/CMakeFiles/openRTSP.dir/requires: live/testProgs/CMakeFiles/openRTSP.dir/playCommon.cpp.o.requires

.PHONY : live/testProgs/CMakeFiles/openRTSP.dir/requires

live/testProgs/CMakeFiles/openRTSP.dir/clean:
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs && $(CMAKE_COMMAND) -P CMakeFiles/openRTSP.dir/cmake_clean.cmake
.PHONY : live/testProgs/CMakeFiles/openRTSP.dir/clean

live/testProgs/CMakeFiles/openRTSP.dir/depend:
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/fmurillom/Documents/Tec/DatosII/Prueba /home/fmurillom/Documents/Tec/DatosII/Prueba/live/testProgs /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/live/testProgs/CMakeFiles/openRTSP.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : live/testProgs/CMakeFiles/openRTSP.dir/depend

