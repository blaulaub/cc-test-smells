using NUnit.Framework;

using BackingCode;

public class EagerTest
{
    [Test]
    public void TestFlightMileage_asKm2()
    {
        // set up fixture
        // exercise constructor
        Flight newFlight = new Flight(validFlightNumber);
        // verify constructed object
        Assert.AreEqual(validFlightNumber, newFlight.FlightNumber);

        // TODO this test is a stub
    }

    private string validFlightNumber = "1";
}
