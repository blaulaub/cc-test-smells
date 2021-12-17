package ch.scs.cc.testing.smells;

import ch.scs.cc.testing.helpers.FixtureHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MysteryGuestTest {

    private FlightRepository flightRepository = new FlightRepository();
    private FixtureHelper helper = new FixtureHelper(flightRepository);
    private Facade facade = new Facade(flightRepository);

    private void loadAirportsAndFlightsFromFile(String fileName) throws IOException {
        helper.loadAirportsAndFlightsFromFile(fileName);
    }

    /**
     * page 188
     */
    @Test
    void testGetFlightsByFromAirport_OneOutboundFlight_mg() throws Exception {
        loadAirportsAndFlightsFromFile("test-flights.csv");
        // Exercise System
        List<FlightDto> flightsAtOrigin = facade.getFlightsByOriginAirportCode("YYC");
        // Verify Outcome
        assertEquals(1, flightsAtOrigin.size());
        FlightDto firstFlight = flightsAtOrigin.get(0);
        assertEquals("Calgary", firstFlight.originCity());
    }
}
