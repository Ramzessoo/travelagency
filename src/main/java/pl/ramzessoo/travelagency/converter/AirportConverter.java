package pl.ramzessoo.travelagency.converter;

import pl.ramzessoo.travelagency.dto.AirportDto;
import pl.ramzessoo.travelagency.dto.CityDto;
import pl.ramzessoo.travelagency.model.Airport;
import pl.ramzessoo.travelagency.model.City;

public class AirportConverter {

    public static Airport fromDto(AirportDto airportDto) {
        return Airport.builder()
                .iata(airportDto.getIata())
                .name(airportDto.getName())
                .build();
    }

    public static AirportDto toDto(Airport airport) {
        return AirportDto.builder()
                .iata(airport.getIata())
                .name(airport.getName())
                .build();
    }

}

