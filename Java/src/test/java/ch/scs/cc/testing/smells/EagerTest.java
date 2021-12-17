package ch.scs.cc.testing.smells;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** See 'Cause: Eager Test' on page 187 */
public class EagerTest {

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

    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    // above originates from the text book
    // ------------------------------------
    // below was added to make it work
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    private FlightNumber validFlightNumber = FlightNumber.fromString("1");
}
