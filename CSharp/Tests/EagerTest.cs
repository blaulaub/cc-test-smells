using System;
using NUnit.Framework;
using BackingCode;

/// See 'Cause: Eager Test' on page 187
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
        int actualKilometres = newFlight.GetMileageAsKm();
        // verify results
        int expectedKilometres = 1810;
        Assert.AreEqual(expectedKilometres, actualKilometres);
        // now try it with a canceled flight
        newFlight.Cancel();
        try
        {
            newFlight.GetMileageAsKm();
            Assert.Fail("Expected exception");
        }
        catch (InvalidOperationException e)
        {
            Assert.AreEqual("Cannot get cancelled flight mileage", e.Message);
        }
    }

    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    // above originates from the text book
    // ------------------------------------
    // below was added to make it work
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    private string validFlightNumber = "1";
}
