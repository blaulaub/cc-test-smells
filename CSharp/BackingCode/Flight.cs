namespace BackingCode
{

    using System;

    public class Flight
    {

        public string FlightNumber { get; }
        public string AirlineCode { get; }
        public object Airline { get; }

        public Flight(string flightNumber)
        {
            FlightNumber = flightNumber;
            AirlineCode = string.Empty;
        }
    }
}
