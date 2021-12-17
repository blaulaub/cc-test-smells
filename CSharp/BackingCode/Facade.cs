namespace BackingCode
{

    using System.Collections.Generic;
    using System.Linq;

    public class Facade
    {
        private readonly FlightRepository flightRepository;

        public Facade(FlightRepository flightRepository)
        {
            this.flightRepository = flightRepository;
        }

        public List<FlightDto> GetFlightsByOriginAirportCode(string airportCode)
        {
            return flightRepository.FindByOriginAirportCode(airportCode).ToList<FlightDto>();
        }
    }
}
