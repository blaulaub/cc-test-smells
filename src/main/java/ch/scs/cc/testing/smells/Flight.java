package ch.scs.cc.testing.smells;

public class Flight {

    private final FlightNumber flightNumber;

    public Flight(FlightNumber flightNumber) {
        this.flightNumber = flightNumber;
    }

    public FlightNumber getNumber() {
        return this.flightNumber;
    }

    public String getAirlineCode() {
        return "";
    }
}
