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
include CMakeFiles/prueba.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/prueba.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/prueba.dir/flags.make

CMakeFiles/prueba.dir/main.cpp.o: CMakeFiles/prueba.dir/flags.make
CMakeFiles/prueba.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/prueba.dir/main.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/prueba.dir/main.cpp.o -c /home/fmurillom/Documents/Tec/DatosII/Prueba/main.cpp

CMakeFiles/prueba.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/prueba.dir/main.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/fmurillom/Documents/Tec/DatosII/Prueba/main.cpp > CMakeFiles/prueba.dir/main.cpp.i

CMakeFiles/prueba.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/prueba.dir/main.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/fmurillom/Documents/Tec/DatosII/Prueba/main.cpp -o CMakeFiles/prueba.dir/main.cpp.s

CMakeFiles/prueba.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/prueba.dir/main.cpp.o.requires

CMakeFiles/prueba.dir/main.cpp.o.provides: CMakeFiles/prueba.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/prueba.dir/build.make CMakeFiles/prueba.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/prueba.dir/main.cpp.o.provides

CMakeFiles/prueba.dir/main.cpp.o.provides.build: CMakeFiles/prueba.dir/main.cpp.o


# Object files for target prueba
prueba_OBJECTS = \
"CMakeFiles/prueba.dir/main.cpp.o"

# External object files for target prueba
prueba_EXTERNAL_OBJECTS =

../bin/prueba: CMakeFiles/prueba.dir/main.cpp.o
../bin/prueba: CMakeFiles/prueba.dir/build.make
../bin/prueba: CMakeFiles/prueba.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable ../bin/prueba"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/prueba.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/prueba.dir/build: ../bin/prueba

.PHONY : CMakeFiles/prueba.dir/build

CMakeFiles/prueba.dir/requires: CMakeFiles/prueba.dir/main.cpp.o.requires

.PHONY : CMakeFiles/prueba.dir/requires

CMakeFiles/prueba.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/prueba.dir/cmake_clean.cmake
.PHONY : CMakeFiles/prueba.dir/clean

CMakeFiles/prueba.dir/depend:
	cd /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/fmurillom/Documents/Tec/DatosII/Prueba /home/fmurillom/Documents/Tec/DatosII/Prueba /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug /home/fmurillom/Documents/Tec/DatosII/Prueba/cmake-build-debug/CMakeFiles/prueba.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/prueba.dir/depend

