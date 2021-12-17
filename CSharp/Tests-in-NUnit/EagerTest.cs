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
        Assert.AreEqual("", newFlight.AirlineCode);
        Assert.IsNull(newFlight.Airline);
        // set up mileage
        newFlight.Mileage = 1122;
        // exercise mileage translator
        int actualKilometres = newFlight.MileageAsKm;
        // verify results
        int expectedKilometres = 1810;
        Assert.AreEqual(expectedKilometres, actualKilometres);

        // TODO this test is a stub
    }

    private string validFlightNumber = "1";
}
