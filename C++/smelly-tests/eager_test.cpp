#include <gtest/gtest.h>

#include <flight.h>

class EagerTest : public ::testing::Test {
 public:
    std::string validFlightNumber = "1";
};

// Demonstrate some basic assertions.
TEST_F(EagerTest, TestFlightMileage_asKm2) {
    // set up fixture
    // exercise constructor
    Flight newFlight(validFlightNumber);
    // verify constructed object
    EXPECT_EQ(newFlight.flightNumber, validFlightNumber);
    EXPECT_EQ(newFlight.getAirlineCode(), "");
    EXPECT_TRUE(newFlight.getAirline() == nullptr);
    // set up mileage
    newFlight.setMileage(1122);
    // exercise mileage translator
    int actualKilometres = newFlight.getMileageAsKm();
    // verify results
    int expectedKilometres = 1810;
    EXPECT_EQ(expectedKilometres, actualKilometres);
    // now try it with a canceled flight
    newFlight.cancel();
}
