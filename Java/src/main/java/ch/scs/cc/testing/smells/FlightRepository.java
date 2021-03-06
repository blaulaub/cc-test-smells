package ch.scs.cc.testing.smells;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FlightRepository {

    private List<FlightDto> flights = new ArrayList<>();

    public void save(FlightDto flight) {
        flights.add(flight);
    }

    public Stream<FlightDto> findAll() {
        return flights.stream();
    }

    public Stream<FlightDto> findByOriginAirportCode(String airportCode) {
        return flights.stream()
                .filter(it -> it.originAirportCode().equals(airportCode));
    }
}
