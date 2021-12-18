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
        FlightDto outboundFlight = FindOneOutboundFlight();
        // Exercise System
        List<FlightDto> flightsAtOrigin = facade.GetFlightsByOriginAirportCode(outboundFlight.OriginAirportCode);
        // Verify Outcome
        AssertOnlyFlightInDtoList("Flights at origin", outboundFlight, flightsAtOrigin);
    }

    [Test]
    public void TestGetFlightsByFromAirport_TwoOutboundFlights()
    {
        SetupStandardAirportsAndFlights();
        List<FlightDto> outboundFlights = FindTwoOutboundFlightsFromOneAirport();
        // Exercise System
        List<FlightDto> flightsAtOrigin = facade.GetFlightsByOriginAirportCode(outboundFlights[0].OriginAirportCode);
        // Verify Outcome
        AssertExactlyTwoFlightsInDtoList("Flights at origin", outboundFlights, flightsAtOrigin);
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
    private FlightDto FindOneOutboundFlight() => helper.FindOneOutboundFlight();
    private List<FlightDto> FindTwoOutboundFlightsFromOneAirport() => helper.FindTwoOutboundFlightsFromOneAirport();

    private void AssertOnlyFlightInDtoList(string message, FlightDto expected, IEnumerable<FlightDto> actual)
        => AssertionHelper.AssertOnlyFlightInDtoList(message, expected, actual);
    private void AssertExactlyTwoFlightsInDtoList(string message, IEnumerable<FlightDto> expected, IEnumerable<FlightDto> actual)
        => AssertionHelper.AssertExactlyTwoFlightsInDtoList(message, expected, actual);
}
