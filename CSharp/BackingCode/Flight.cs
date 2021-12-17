namespace BackingCode
{

    using System;

    public class Flight
    {

        public string FlightNumber { get; }
        public string AirlineCode { get; }
        public object Airline { get; }
        public int Mileage { get; set; }

        public Flight(string flightNumber)
        {
            FlightNumber = flightNumber;
            AirlineCode = string.Empty;
        }

        public int MileageAsKm
        {
            // TODO this is a stub
            get { return 1810; }
        }
    }
}
