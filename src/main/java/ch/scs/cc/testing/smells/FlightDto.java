package ch.scs.cc.testing.smells;

import org.inferred.freebuilder.FreeBuilder;

@FreeBuilder
public interface FlightDto {

    static FlightDto fromOrigin(String city) {
        return new Builder().originCity(city).build();
    }

    String originCity();

    class Builder extends FlightDto_Builder {}
}
