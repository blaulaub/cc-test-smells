cmake_minimum_required(VERSION 3.14)
project( CleanCodersTestSmells )

# GoogleTest requires at least C++11
set(CMAKE_CXX_STANDARD 11)

add_subdirectory(backing-code)
add_subdirectory(smelly-tests)
