using System;
using System.IO;
using System.Globalization;
using System.Linq;
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
}
