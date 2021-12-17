namespace BackingCode
{

    using System;

    public class Flight
    {

        public string FlightNumber { get; }
        public string AirlineCode { get; }
        public object Airline { get; }
        public int Mileage { get; set; }

        private bool cancelled;

        public Flight(string flightNumber)
        {
            FlightNumber = flightNumber;
            AirlineCode = string.Empty;
        }

        public int GetMileageAsKm()
        {
            // TODO this is a stub
            if (cancelled)
            {
                throw new InvalidOperationException("Cannot get cancelled flight mileage");
            }
            else
            {
                return 1810;
            }
        }

        public void Cancel()
        {
            // TODO this is a stub
            cancelled = true;
        }
    }
}
