#ifndef C___BACKING_CODE_INVALID_REQUEST_EXCEPTION_H_
#define C___BACKING_CODE_INVALID_REQUEST_EXCEPTION_H_

#include <exception>
#include <string>

class InvalidRequestException : public std::exception {
 private:
    std::string message;

 public:
    explicit InvalidRequestException(std::string message) : message(message) {}

    virtual const char* what() const noexcept {
       return message.c_str();
    }
};

#endif  // C___BACKING_CODE_INVALID_REQUEST_EXCEPTION_H_
