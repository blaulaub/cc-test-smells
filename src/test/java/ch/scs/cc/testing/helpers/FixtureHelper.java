package ch.scs.cc.testing.helpers;

import ch.scs.cc.testing.smells.FlightDto;
import ch.scs.cc.testing.smells.FlightRepository;
import org.apache.commons.csv.CSVFormat;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

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
                                            .build());
                        });
    }

    public void setupStandardAirportsAndFlights() {
        // TODO this test helper is a stub
    }

    public FlightDto findOneOutboundFlight() {
        // TODO this test helper is a stub
        return null;
    }

    public List<FlightDto> findTwoOutboundFlightsFromOneAirport() {
        // TODO this test helper is a stub
        return Collections.emptyList();
    }

}
