using System;
using System.IO;
using System.Globalization;
using System.Linq;
using System.Reflection;

using NUnit.Framework;
using CsvHelper;

using BackingCode;

/// See 'Cause: Mystery Guest' on page 188
public class MysteryGuest
{
    [Test]
    public void TestGetFlightsByFromAirport_OneOutboundFlight_mg()
    {
        LoadAirportsAndFlightsFromFile("test-flights.csv");
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
