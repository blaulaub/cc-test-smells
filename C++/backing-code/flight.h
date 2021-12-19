#ifndef C___BACKING_CODE_FLIGHT_H_
#define C___BACKING_CODE_FLIGHT_H_

#include <string>

#include "invalid-request-exception.h"

class Flight {
 private:
    bool canceled = false;

 public:
    const std::string flightNumber;

    explicit Flight(std::string &flightNumber) : flightNumber(flightNumber) {}

    const std::string getAirlineCode() { /* TODO this is a stub */ return ""; }
    const void* getAirline() { /* TODO this is a stub */ return nullptr; }
    void setMileage(int value) { /* TODO this is a stub */ }

    int getMileageAsKm() {
        /* TODO this is a stub */
        if (canceled) {
            throw InvalidRequestException("Cannot get cancelled flight mileage");
        } else {
            return 1810;
        }
    }

    void cancel() {
        canceled = true;
    }
};

#endif  // C___BACKING_CODE_FLIGHT_H_
