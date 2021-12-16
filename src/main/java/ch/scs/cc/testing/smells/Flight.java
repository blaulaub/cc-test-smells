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
        // TODO this is a stub
        return "";
    }

    public Object getAirline() {
        // TODO this is a stub
        return null;
    }

    public void setMileage(int value) {
        // TODO this is a stub
    }

    public int getMileageAsKm() {
        // TODO this is a stub
        return 1810;
    }
}
