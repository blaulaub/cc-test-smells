using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Globalization;
using System.Reflection;

using CsvHelper;
using CsvHelper.Configuration;

using BackingCode;

public class FixtureHelper
{
    private readonly FlightRepository flightRepository;

    public FixtureHelper(FlightRepository flightRepository)
    {
        this.flightRepository = flightRepository;
    }

    public void LoadAirportsAndFlightsFromFile(string fileName)
    {
        var assembly = Assembly.GetAssembly(typeof(FixtureHelper));
        var assemblyName = assembly.GetName().Name;
        var csvConfig = new CsvConfiguration(CultureInfo.InvariantCulture) { HasHeaderRecord = false };
        using (var stream = assembly.GetManifestResourceStream($"{assemblyName}.{fileName}"))
        using (var reader = new StreamReader(stream))
        using (var csvParser = new CsvReader(reader, csvConfig))
        {
            foreach (FlightDto flightDto in csvParser.GetRecords<FlightDto>())
            {
                flightRepository.Save(flightDto);
            }
        }
    }

    public void SetupStandardAirportsAndFlights()
    {
        new[] {
            new FlightDto {
                OriginCity = "San Francisco",
                OriginAirportCode = "SFO",
                DestinationCity = "Los Angeles",
                DestinationAirportCode = "LAX"
            },
            new FlightDto {
                OriginCity = "San Francisco",
                OriginAirportCode = "SFO",
                DestinationCity = "Zurich",
                DestinationAirportCode = "ZRH"
            },
            new FlightDto {
                OriginCity = "Los Angeles",
                OriginAirportCode = "LAX",
                DestinationCity = "Zurich",
                DestinationAirportCode = "ZRH"
            }
        }.ToList<FlightDto>().ForEach(it => flightRepository.Save(it));
    }

    public FlightDto FindOneOutboundFlight()
    {
        return flightRepository.FindAll()
            .GroupBy(it => it.OriginAirportCode)
            .Where(it => it.Count() == 1)
            .Select(it => it.First())
            .First();
    }

    public List<FlightDto> FindTwoOutboundFlightsFromOneAirport()
    {
        return flightRepository.FindAll()
            .GroupBy(it => it.OriginAirportCode)
            .Where(it => it.Count() == 2)
            .Select(it => it.First())
            .ToList();
    }
}
