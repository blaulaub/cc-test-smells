package ch.scs.cc.testing.smells;

import org.inferred.freebuilder.FreeBuilder;

@FreeBuilder
public interface FlightNumber {

    String value();

    static FlightNumber fromString(String value) {
        return new Builder().value(value).build();
    }

    class Builder extends FlightNumber_Builder {}
}
