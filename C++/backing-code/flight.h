#ifndef C___BACKING_CODE_FLIGHT_H_
#define C___BACKING_CODE_FLIGHT_H_

#include <string>

class Flight {
 public:
    const std::string flightNumber;
    explicit Flight(std::string &flightNumber) : flightNumber(flightNumber) {}
};

#endif  // C___BACKING_CODE_FLIGHT_H_
