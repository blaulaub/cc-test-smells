package ch.scs.cc.testing.smells;

import org.inferred.freebuilder.FreeBuilder;

@FreeBuilder
public interface FlightDto {

    String originCity();
    String originAirportCode();
    String destinationCity();
    String destinationAirportCode();

    class Builder extends FlightDto_Builder {
    }
}
