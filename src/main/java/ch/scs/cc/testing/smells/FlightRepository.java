package ch.scs.cc.testing.smells;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightRepository {

    private List<FlightDto> flights = new ArrayList<>();

    public void save(FlightDto flight) {
        flights.add(flight);
    }

    public List<FlightDto> findByOriginAirportCode(String airportCode) {
        return flights.stream()
                .filter(it -> it.originAirportCode().equals(airportCode))
                .collect(toList());
    }
}
