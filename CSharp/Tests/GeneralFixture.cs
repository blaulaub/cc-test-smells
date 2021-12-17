using System;
using System.Collections.Generic;

using NUnit.Framework;

using BackingCode;

/// See 'Cause: Mystery Guest' on page 188
public class GeneralFixture
{
    [Test]
    public void TestGetFlightsByFromAirport_OneOutboundFlight()
    {
        SetupStandardAirportsAndFlights();
    }

    [Test]
    public void TestGetFlightsByFromAirport_TwoOutboundFlights()
    {
        SetupStandardAirportsAndFlights();
    }

    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    // above originates from the text book
    // ------------------------------------
    // below was added to make it work
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    private readonly FixtureHelper helper;
    private readonly Facade facade;

    public GeneralFixture()
    {
        var flightRepository = new FlightRepository();
        helper = new FixtureHelper(flightRepository);
        facade = new Facade(flightRepository);
    }

    private void SetupStandardAirportsAndFlights() => helper.SetupStandardAirportsAndFlights();
}
