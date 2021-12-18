#ifndef C___BACKING_CODE_FLIGHT_DTO_H_
#define C___BACKING_CODE_FLIGHT_DTO_H_

#include <string>

struct FlightDto {
    const std::string originCity;
    const std::string originAirportCode;
    const std::string destinationCity;
    const std::string destinationAirportCode;
};

#endif  // C___BACKING_CODE_FLIGHT_DTO_H_
