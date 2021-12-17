namespace BackingCode
{

    using System;

    public class Facade
    {
        private readonly FlightRepository flightRepository;

        public Facade(FlightRepository flightRepository)
        {
            this.flightRepository = flightRepository;
        }
    }
}
