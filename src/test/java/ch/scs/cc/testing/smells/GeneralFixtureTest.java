package ch.scs.cc.testing.smells;

import ch.scs.cc.testing.helpers.FixtureHelper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ch.scs.cc.testing.helpers.AssertionHelper.assertExactlyTwoFlightsInDtoList;
import static ch.scs.cc.testing.helpers.AssertionHelper.assertOnlyFlightInDtoList;

public class GeneralFixtureTest {

    private FlightRepository flightRepository = new FlightRepository();
    private FixtureHelper helper = new FixtureHelper(flightRepository);
    private Facade facade = new Facade(flightRepository);

    private void setupStandardAirportsAndFlights() {
        helper.setupStandardAirportsAndFlights();
    }

    private FlightDto findOneOutboundFlight() {
        return helper.findOneOutboundFlight();
    }

    private List<FlightDto> findTwoOutboundFlightsFromOneAirport() {
        return helper.findTwoOutboundFlightsFromOneAirport();
    }

    @Test
    void testGetFlightsByFromAirport_OneOutboundFlight() throws Exception {
        setupStandardAirportsAndFlights();
        FlightDto outboundFlight = findOneOutboundFlight();
        // Exercise System
        List<FlightDto> flightsAtOrigin = facade.getFlightsByOriginAirport(outboundFlight.originAirportCode());
        // Verify Outcome
        assertOnlyFlightInDtoList("Flights at origin", outboundFlight, flightsAtOrigin);
    }

    @Test
    void testGetFlightsByFromAirport_TwoOutboundFlights() throws Exception {
        setupStandardAirportsAndFlights();
        List<FlightDto> outboundFlights = findTwoOutboundFlightsFromOneAirport();
        // Exercise System
        List<FlightDto> flightsAtOrigin = facade.getFlightsByOriginAirport(outboundFlights.get(0).originAirportCode());
        // Verify Outcome
        assertExactlyTwoFlightsInDtoList("Flights at origin", outboundFlights, flightsAtOrigin);
    }
}
