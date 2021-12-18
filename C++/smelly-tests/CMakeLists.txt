project( SmellyTests )

include(FetchContent)
FetchContent_Declare(
  googletest
  URL https://github.com/google/googletest/archive/609281088cfefc76f9d0ce82e1ff6c30cc3591e5.zip
)
# For Windows: Prevent overriding the parent project's compiler/linker settings
set(gtest_force_shared_crt ON CACHE BOOL "" FORCE)
FetchContent_MakeAvailable(googletest)

enable_testing()

add_executable( cc-test-smells
  eager_test.cpp
)

target_link_libraries( cc-test-smells
  backing_code
  gtest_main
)

include_directories(${BackingCode_SOURCE_DIR})

include(GoogleTest)
gtest_discover_tests(cc-test-smells)
