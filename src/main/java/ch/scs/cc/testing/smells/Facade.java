package ch.scs.cc.testing.smells;

import java.util.Collections;
import java.util.List;

public class Facade {

    public List<FlightDto> getFlightsByOriginAirportCode(String airportCode) {
        // TODO this is a stub
        return Collections.singletonList(FlightDto.fromOrigin("Calgary"));
    }
}
