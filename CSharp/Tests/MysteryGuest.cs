using System;
using NUnit.Framework;
using BackingCode;

/// See 'Cause: Mystery Guest' on page 188
public class MysteryGuest
{
    [Test]
    public void TestGetFlightsByFromAirport_OneOutboundFlight_mg()
    {
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
}
