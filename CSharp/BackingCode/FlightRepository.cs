namespace BackingCode
{

    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class FlightRepository
    {
        private List<FlightDto> flights = new List<FlightDto>();

        public void Save(FlightDto flight) => flights.Add(flight);
        public IEnumerable<FlightDto> FindAll() => flights.AsReadOnly();
        public IEnumerable<FlightDto> FindByOriginAirportCode(String airportCode) => flights.Where(it => it.OriginAirportCode == airportCode);
    }
}
