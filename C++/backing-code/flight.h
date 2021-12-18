#include <string>

class Flight {
private:
    const std::string flightNumber;
public:
    Flight(std::string &flightNumber)
    : flightNumber(flightNumber)
    {}
};