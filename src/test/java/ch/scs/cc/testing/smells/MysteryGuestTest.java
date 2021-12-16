package ch.scs.cc.testing.smells;

import org.junit.jupiter.api.Test;

import java.util.List;

public class MysteryGuestTest {

    private Facade facade = new Facade();

    private void loadAirportsAndFlightsFromFile(String s) {
        // TODO this is a stub
    }

    @Test
    void dummy() {
        loadAirportsAndFlightsFromFile("test-flights.csv");
        // Exercise System
        List flightsAtOrigin = facade.getFlightsByOriginAirportCode("YYC");
    }
}
