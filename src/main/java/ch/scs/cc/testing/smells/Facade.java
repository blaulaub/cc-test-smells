package ch.scs.cc.testing.smells;

import java.util.Collections;
import java.util.List;

public class Facade {

    private final FlightRepository flightRepository;

    public Facade(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDto> getFlightsByOriginAirportCode(String airportCode) {
        // TODO this is a stub
        return flightRepository.findByOriginAirportCode(airportCode);
    }

    public List<FlightDto> getFlightsByOriginAirport(String airportId) {
        // TODO this is a stub
        return null;
    }
}
