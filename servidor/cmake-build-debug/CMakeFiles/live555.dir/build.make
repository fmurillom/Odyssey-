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
include CMakeFiles/live555.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/live555.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/live555.dir/flags.make

CMakeFiles/live555.dir/main.cpp.o: CMakeFiles/live555.dir/flags.make
CMakeFiles/live555.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/live555.dir/main.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/live555.dir/main.cpp.o -c /home/fmurillom/Documents/Tec/DatosII/Prueba/main.cpp

CMakeFiles/live555.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/live555.dir/main.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/fmurillom/Documents/Tec/DatosII/Prueba/main.cpp > CMakeFiles/live555.dir/main.cpp.i

CMakeFiles/live555.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/live555.dir/main.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/fmurillom/Documents/Tec/DatosII/Prueba/main.cpp -o CMakeFiles/live555.dir/main.cpp.s

CMakeFiles/live555.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/live555.dir/main.cpp.o.requires

CMakeFiles/live555.dir/main.cpp.o.provides: CMakeFiles/live555.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/live555.dir/build.make CMakeFiles/live555.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/live555.dir/main.cpp.o.provides

CMakeFiles/live555.dir/main.cpp.o.provides.build: CMakeFiles/live555.dir/main.cpp.o


CMakeFiles/live555.dir/src/server.cpp.o: CMakeFiles/live555.dir/flags.make
CMakeFiles/live555.dir/src/server.cpp.o: ../src/server.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/live555.dir/src/server.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/live555.dir/src/server.cpp.o -c /home/fmurillom/Documents/Tec/DatosII/Prueba/src/server.cpp

CMakeFiles/live555.dir/src/server.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/live555.dir/src/server.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/fmurillom/Documents/Tec/DatosII/Prueba/src/server.cpp > CMakeFiles/live555.dir/src/server.cpp.i

CMakeFiles/live555.dir/src/server.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/live555.dir/src/server.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/fmurillom/Documents/Tec/DatosII/Prueba/src/server.cpp -o CMakeFiles/live555.dir/src/server.cpp.s

CMakeFiles/live555.dir/src/server.cpp.o.requires:

.PHONY : CMakeFiles/live555.dir/src/server.cpp.o.requires

CMakeFiles/live555.dir/src/server.cpp.o.provides: CMakeFiles/live555.dir/src/server.cpp.o.requires
	$(MAKE) -f CMakeFiles/live555.dir/build.make CMakeFiles/live555.dir/src/server.cpp.o.provides.build
.PHONY : CMakeFiles/live555.dir/src/server.cpp.o.provides

CMakeFiles/live555.dir/src/server.cpp.o.provides.build: CMakeFiles/live555.dir/src/server.cpp.o


CMakeFiles/live555.dir/src/User.cpp.o: CMakeFiles/live555.dir/flags.make
CMakeFiles/live555.dir/src/User.cpp.o: ../src/User.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object CMakeFiles/live555.dir/src/User.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/live555.dir/src/User.cpp.o -c /home/fmurillom/Documents/Tec/DatosII/Prueba/src/User.cpp

CMakeFiles/live555.dir/src/User.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/live555.dir/src/User.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/fmurillom/Documents/Tec/DatosII/Prueba/src/User.cpp > CMakeFiles/live555.dir/src/User.cpp.i

CMakeFiles/live555.dir/src/User.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/live555.dir/src/User.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/fmurillom/Documents/Tec/DatosII/Prueba/src/User.cpp -o CMakeFiles/live555.dir/src/User.cpp.s

CMakeFiles/live555.dir/src/User.cpp.o.requires:

.PHONY : CMakeFiles/live555.dir/src/User.cpp.o.requires

CMakeFiles/live555.dir/src/User.cpp.o.provides: CMakeFiles/live555.dir/src/User.cpp.o.requires
	$(MAKE) -f CMakeFiles/live555.dir/build.make CMakeFiles/live555.dir/src/User.cpp.o.provides.build
.PHONY : CMakeFiles/live555.dir/src/User.cpp.o.provides

CMakeFiles/live555.dir/src/User.cpp.o.provides.build: CMakeFiles/live555.dir/src/User.cpp.o


CMakeFiles/live555.dir/base64/base64.cpp.o: CMakeFiles/live555.dir/flags.make
CMakeFiles/live555.dir/base64/base64.cpp.o: ../base64/base64.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building CXX object CMakeFiles/live555.dir/base64/base64.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/live555.dir/base64/base64.cpp.o -c /home/fmurillom/Documents/Tec/DatosII/Prueba/base64/base64.cpp

CMakeFiles/live555.dir/base64/base64.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/live555.dir/base64/base64.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/fmurillom/Documents/Tec/DatosII/Prueba/base64/base64.cpp > CMakeFiles/live555.dir/base64/base64.cpp.i

CMakeFiles/live555.dir/base64/base64.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/live555.dir/base64/base64.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/fmurillom/Documents/Tec/DatosII/Prueba/base64/base64.cpp -o CMakeFiles/live555.dir/base64/base64.cpp.s

CMakeFiles/live555.dir/base64/base64.cpp.o.requires:

.PHONY : CMakeFiles/live555.dir/base64/base64.cpp.o.requires

CMakeFiles/live555.dir/base64/base64.cpp.o.provides: CMakeFiles/live555.dir/base64/base64.cpp.o.requires
	$(MAKE) -f CMakeFiles/live555.dir/build.make CMakeFiles/live555.dir/base64/base64.cpp.o.provides.build
.PHONY : CMakeFiles/live555.dir/base64/base64.cpp.o.provides

CMakeFiles/live555.dir/base64/base64.cpp.o.provides.build: CMakeFiles/live555.dir/base64/base64.cpp.o


CMakeFiles/live555.dir/src/Sorter.cpp.o: CMakeFiles/live555.dir/flags.make
CMakeFiles/live555.dir/src/Sorter.cpp.o: ../src/Sorter.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Building CXX object CMakeFiles/live555.dir/src/Sorter.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/live555.dir/src/Sorter.cpp.o -c /home/fmurillom/Documents/Tec/DatosII/Prueba/src/Sorter.cpp

CMakeFiles/live555.dir/src/Sorter.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/live555.dir/src/Sorter.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/fmurillom/Documents/Tec/DatosII/Prueba/src/Sorter.cpp > CMakeFiles/live555.dir/src/Sorter.cpp.i

CMakeFiles/live555.dir/src/Sorter.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/live555.dir/src/Sorter.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/fmurillom/Documents/Tec/DatosII/Prueba/src/Sorter.cpp -o CMakeFiles/live555.dir/src/Sorter.cpp.s

CMakeFiles/live555.dir/src/Sorter.cpp.o.requires:

.PHONY : CMakeFiles/live555.dir/src/Sorter.cpp.o.requires

CMakeFiles/live555.dir/src/Sorter.cpp.o.provides: CMakeFiles/live555.dir/src/Sorter.cpp.o.requires
	$(MAKE) -f CMakeFiles/live555.dir/build.make CMakeFiles/live555.dir/src/Sorter.cpp.o.provides.build
.PHONY : CMakeFiles/live555.dir/src/Sorter.cpp.o.provides

CMakeFiles/live555.dir/src/Sorter.cpp.o.provides.build: CMakeFiles/live555.dir/src/Sorter.cpp.o


CMakeFiles/live555.dir/src/tinyxml2.cpp.o: CMakeFiles/live555.dir/flags.make
CMakeFiles/live555.dir/src/tinyxml2.cpp.o: ../src/tinyxml2.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Building CXX object CMakeFiles/live555.dir/src/tinyxml2.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/live555.dir/src/tinyxml2.cpp.o -c /home/fmurillom/Documents/Tec/DatosII/Prueba/src/tinyxml2.cpp

CMakeFiles/live555.dir/src/tinyxml2.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/live555.dir/src/tinyxml2.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/fmurillom/Documents/Tec/DatosII/Prueba/src/tinyxml2.cpp > CMakeFiles/live555.dir/src/tinyxml2.cpp.i

CMakeFiles/live555.dir/src/tinyxml2.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/live555.dir/src/tinyxml2.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/fmurillom/Documents/Tec/DatosII/Prueba/src/tinyxml2.cpp -o CMakeFiles/live555.dir/src/tinyxml2.cpp.s

CMakeFiles/live555.dir/src/tinyxml2.cpp.o.requires:

.PHONY : CMakeFiles/live555.dir/src/tinyxml2.cpp.o.requires

CMakeFiles/live555.dir/src/tinyxml2.cpp.o.provides: CMakeFiles/live555.dir/src/tinyxml2.cpp.o.requires
	$(MAKE) -f CMakeFiles/live555.dir/build.make CMakeFiles/live555.dir/src/tinyxml2.cpp.o.provides.build
.PHONY : CMakeFiles/live555.dir/src/tinyxml2.cpp.o.provides

CMakeFiles/live555.dir/src/tinyxml2.cpp.o.provides.build: CMakeFiles/live555.dir/src/tinyxml2.cpp.o


# Object files for target live555
live555_OBJECTS = \
"CMakeFiles/live555.dir/main.cpp.o" \
"CMakeFiles/live555.dir/src/server.cpp.o" \
"CMakeFiles/live555.dir/src/User.cpp.o" \
"CMakeFiles/live555.dir/base64/base64.cpp.o" \
"CMakeFiles/live555.dir/src/Sorter.cpp.o" \
"CMakeFiles/live555.dir/src/tinyxml2.cpp.o"

# External object files for target live555
live555_EXTERNAL_OBJECTS =

../bin/live555: CMakeFiles/live555.dir/main.cpp.o
../bin/live555: CMakeFiles/live555.dir/src/server.cpp.o
../bin/live555: CMakeFiles/live555.dir/src/User.cpp.o
../bin/live555: CMakeFiles/live555.dir/base64/base64.cpp.o
../bin/live555: CMakeFiles/live555.dir/src/Sorter.cpp.o
../bin/live555: CMakeFiles/live555.dir/src/tinyxml2.cpp.o
../bin/live555: CMakeFiles/live555.dir/build.make
../bin/live555: ../bin/liblive.so
../bin/live555: ../bin/libticpp.a
../bin/live555: CMakeFiles/live555.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_7) "Linking CXX executable ../bin/live555"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/live555.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/live555.dir/build: ../bin/live555

.PHONY : CMakeFiles/live555.dir/build

CMakeFiles/live555.dir/requires: CMakeFiles/live555.dir/main.cpp.o.requires
CMakeFiles/live555.dir/requires: CMakeFiles/live555.dir/src/server.cpp.o.requires
CMakeFiles/live555.dir/requires: CMakeFiles/live555.dir/src/User.cpp.o.requires
CMakeFiles/live555.dir/requires: CMakeFiles/live555.dir/base64/base64.cpp.o.requires
CMakeFiles/live555.dir/requires: CMakeFiles/live555.dir/src/Sorter.cpp.o.requires
CMakeFiles/live555.dir/requires: CMakeFiles/live555.dir/src/tinyxml2.cpp.o.requires

.PHONY : CMakeFiles/live555.dir/requires

CMakeFiles/live555.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/live555.dir/cmake_clean.cmake
.PHONY : CMakeFiles/live555.dir/clean

CMakeFiles/live555.dir/depend:
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/fmurillom/Documents/Tec/DatosII/Prueba /home/fmurillom/Documents/Tec/DatosII/Prueba /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles/live555.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/live555.dir/depend

