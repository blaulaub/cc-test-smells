using System;
using System.Collections.Generic;

using NUnit.Framework;

using BackingCode;

/// See 'Cause: Mystery Guest' on page 188
public class MysteryGuest
{
    [Test]
    public void TestGetFlightsByFromAirport_OneOutboundFlight_mg()
    {
        LoadAirportsAndFlightsFromFile("test-flights.csv");
        // Exercise System
        List<FlightDto> flightsAtOrigin = facade.GetFlightsByOriginAirportCode("YYC");
        // Verify Outcome
        Assert.AreEqual(1, flightsAtOrigin.Count);
        FlightDto firstFlight = flightsAtOrigin[0];
        Assert.AreEqual("Calgary", firstFlight.OriginCity);
    }

    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    // above originates from the text book
    // ------------------------------------
    // below was added to make it work
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    private readonly FixtureHelper helper;
    private readonly Facade facade;

    public MysteryGuest()
    {
        var flightRepository = new FlightRepository();
        helper = new FixtureHelper(flightRepository);
        facade = new Facade(flightRepository);
    }

    private void LoadAirportsAndFlightsFromFile(string fileName) => helper.LoadAirportsAndFlightsFromFile(fileName);
}
