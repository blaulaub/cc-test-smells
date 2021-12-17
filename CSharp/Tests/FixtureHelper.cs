using System;
using BackingCode;

public class FixtureHelper
{
    private readonly FlightRepository flightRepository;

    public FixtureHelper(FlightRepository flightRepository)
    {
        this.flightRepository = flightRepository;
    }
}
