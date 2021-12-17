package ch.scs.cc.testing.smells;

import ch.scs.cc.testing.helpers.FixtureHelper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ch.scs.cc.testing.helpers.AssertionHelper.assertExactlyTwoFlightsInDtoList;
import static ch.scs.cc.testing.helpers.AssertionHelper.assertOnlyFlightInDtoList;

/** See 'Cause: General Fixture' on page 190 */
public class GeneralFixtureTest {

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

    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    // above originates from the text book
    // ------------------------------------
    // below was added to make it work
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    private final FlightRepository flightRepository = new FlightRepository();
    private final FixtureHelper helper = new FixtureHelper(flightRepository);
    private final Facade facade = new Facade(flightRepository);

    private void setupStandardAirportsAndFlights() {
        helper.setupStandardAirportsAndFlights();
    }

    private FlightDto findOneOutboundFlight() {
        return helper.findOneOutboundFlight();
    }

    private List<FlightDto> findTwoOutboundFlightsFromOneAirport() {
        return helper.findTwoOutboundFlightsFromOneAirport();
    }
}
