package ch.scs.cc.testing.helpers;

import ch.scs.cc.testing.smells.FlightDto;
import ch.scs.cc.testing.smells.FlightRepository;
import org.apache.commons.csv.CSVFormat;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;

public class FixtureHelper {

    private final FlightRepository flightRepository;

    public FixtureHelper(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void loadAirportsAndFlightsFromFile(String fileName) throws IOException {

        CSVFormat.DEFAULT
                .parse(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName)))
                .forEach(record -> {
                    var originCity = record.get(0);
                    var originCode = record.get(1);
                    flightRepository.save(
                            new FlightDto.Builder()
                                    .originCity(record.get(0))
                                    .originAirportCode(record.get(1))
                                    .destinationCity(record.get(2))
                                    .destinationAirportCode(record.get(2))
                                    .build());
                });
    }

    public void setupStandardAirportsAndFlights() {
        asList(
                new FlightDto.Builder()
                        .originCity("San Francisco")
                        .originAirportCode("SFO")
                        .destinationCity("Los Angeles")
                        .destinationAirportCode("LAX")
                        .build(),
                new FlightDto.Builder()
                        .originCity("San Francisco")
                        .originAirportCode("SFO")
                        .destinationCity("Zurich")
                        .destinationAirportCode("ZRH")
                        .build(),
                new FlightDto.Builder()
                        .originCity("Los Angeles")
                        .originAirportCode("LAX")
                        .destinationCity("Zurich")
                        .destinationAirportCode("ZRH")
                        .build()
        ).forEach(flightRepository::save);
    }

    public FlightDto findOneOutboundFlight() {
        return flightRepository.findAll()
                .collect(groupingBy(FlightDto::originAirportCode))
                .values().stream()
                .filter(it -> it.size() == 1)
                .findAny()
                .orElseThrow(NoSuchElementException::new)
                .get(0);
    }

    public List<FlightDto> findTwoOutboundFlightsFromOneAirport() {
        return flightRepository.findAll()
                .collect(groupingBy(FlightDto::originAirportCode))
                .values().stream()
                .filter(it -> it.size() == 2)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
