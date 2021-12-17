package ch.scs.cc.testing.smells;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Facade {

    private final FlightRepository flightRepository;

    public Facade(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDto> getFlightsByOriginAirportCode(String airportCode) {
        // TODO this is a stub
        return flightRepository.findByOriginAirportCode(airportCode).collect(toList());
    }

    public List<FlightDto> getFlightsByOriginAirport(String airportId) {
        // TODO this is a stub
        return null;
    }
}
