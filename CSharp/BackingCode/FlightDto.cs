namespace BackingCode
{
    public record FlightDto
    {
        public string OriginCity { get; init; }
        public string OriginAirportCode { get; init; }
        public string DestinationCity { get; init; }
        public string DestinationAirportCode { get; init; }
    }
}
