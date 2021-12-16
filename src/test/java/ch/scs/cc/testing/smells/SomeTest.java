package ch.scs.cc.testing.smells;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeTest {

    private FlightNumber validFlightNumber = FlightNumber.fromString("1");


    /**
     * page 187
     */
    @Test
    void testFlightMileage_asKm2() throws Exception {
        // set up fixture
        // exercise constructor
        Flight newFlight = new Flight(validFlightNumber);
        // verify constructed object
        assertEquals(validFlightNumber, newFlight.getNumber());
    }
}
