package ch.scs.cc.testing.smells;

import org.junit.jupiter.api.Test;

public class SomeTest {

    private FlightNumber validFlightNumber = FlightNumber.fromString("1");

    @Test
    void testFlightMileage_asKm2() throws Exception {
        // set up fixture
        // exercise constructor
        Flight newFlight = new Flight(validFlightNumber);
    }
}
