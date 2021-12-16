package ch.scs.cc.testing.smells;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(newFlight.getNumber(), validFlightNumber);
        assertEquals(newFlight.getAirlineCode(), "");
        assertNull(newFlight.getAirline());
        // set up mileage
        newFlight.setMileage(1122);
        // exercise mileage translator
        int actualKilometres = newFlight.getMileageAsKm();
        // verify results
        int expectedKilometres = 1810;
        assertEquals(expectedKilometres, actualKilometres);
        // now try it with a canceled flight
        newFlight.cancel();
        try {
            newFlight.getMileageAsKm();
            fail("Expected exception");
        } catch (InvalidRequestException e) {
            assertEquals("Cannot get cancelled flight mileage", e.getMessage());
        }
    }
}
