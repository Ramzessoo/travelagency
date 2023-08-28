package pl.ramzessoo.travelagency.converter;

import pl.ramzessoo.travelagency.dto.CityDto;
import pl.ramzessoo.travelagency.dto.TourDto;
import pl.ramzessoo.travelagency.model.City;
import pl.ramzessoo.travelagency.model.Tour;

public class CityConverter {

    public static City fromDto(CityDto cityDto) {
        return City.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .country(CountryConverter.fromDto(cityDto.getCountry()))
                .build();
    }

    public static CityDto toDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .country((CountryConverter.toDto(city.getCountry())))
                .build();
    }

}

