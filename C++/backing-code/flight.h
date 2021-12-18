#ifndef C___BACKING_CODE_FLIGHT_H_
#define C___BACKING_CODE_FLIGHT_H_

#include <string>

class Flight {
 private:
    std::string airlineCode = "";

 public:
    const std::string flightNumber;

    explicit Flight(std::string &flightNumber) : flightNumber(flightNumber) {}

    const std::string& getAirlineCode() {
        return airlineCode;
    }

    const void* getAirline() {
        return nullptr;
    }
};

#endif  // C___BACKING_CODE_FLIGHT_H_
