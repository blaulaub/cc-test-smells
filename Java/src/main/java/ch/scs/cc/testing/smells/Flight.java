package ch.scs.cc.testing.smells;

public class Flight {

    private final FlightNumber flightNumber;
    private boolean cancelled;

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

    public int getMileageAsKm() throws InvalidRequestException {
        // TODO this is a stub
        if (cancelled) {
            throw new InvalidRequestException("Cannot get cancelled flight mileage");
        } else {
            return 1810;
        }
    }

    public void cancel() {
        // TODO this is a stub
        cancelled = true;
    }
}
