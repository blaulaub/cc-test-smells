package ch.scs.cc.testing.smells;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MysteryGuestTest {

    private Facade facade = new Facade();

    private void loadAirportsAndFlightsFromFile(String fileName) {
        // TODO this test helper is a stub
    }

    /**
     * page 188
     */
    @Test
    void testGetFlightsByFromAirport_OneOutboundFlight_mg() {
        loadAirportsAndFlightsFromFile("test-flights.csv");
        // Exercise System
        List<FlightDto> flightsAtOrigin = facade.getFlightsByOriginAirportCode("YYC");
        // Verify Outcome
        assertEquals(1, flightsAtOrigin.size());
        FlightDto firstFlight = flightsAtOrigin.get(0);
        assertEquals("Calgary", firstFlight.originCity());
    }
}
