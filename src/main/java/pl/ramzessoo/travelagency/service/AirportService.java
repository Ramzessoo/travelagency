package pl.ramzessoo.travelagency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.ramzessoo.travelagency.converter.AirportConverter;
import pl.ramzessoo.travelagency.dto.AirportDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.Airport;
import pl.ramzessoo.travelagency.repository.AirportRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public List<Airport> allAirports() {
        return airportRepository.findAll();
    }

    public Airport airportByIata(String iata) throws ResourceNotFoundException {
        Airport airport = airportRepository.findById(iata)
                .orElseThrow(() -> new ResourceNotFoundException("Airport not found by this IATA ::" + iata));
        return airport;
    }

    public AirportDto airportDtoByIata(String iata) throws ResourceNotFoundException {
        return AirportConverter.toDto(airportByIata(iata));
    }

    public Airport addAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(String iata, Airport airportDetails) throws ResourceNotFoundException {
        Airport airport = airportRepository.findById(iata)
                .orElseThrow(() -> new ResourceNotFoundException("Airport not found by this IATA ::" + iata));
        airport.setIata(airportDetails.getIata());
        airport.setName(airportDetails.getName());
        airport.setCity(airportDetails.getCity());

        return airport;
    }

    public Set<AirportDto> airportsDtoForCity(Long cityId) {
        List<Airport> airports = airportRepository.findByCity_Id(cityId);

        return airports.stream()
                .map(airport -> AirportConverter.toDto(airport))
                .collect(Collectors.toSet());
    }
}
