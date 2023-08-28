package pl.ramzessoo.travelagency.converter;

import pl.ramzessoo.travelagency.dto.CityDto;
import pl.ramzessoo.travelagency.dto.CountryDto;
import pl.ramzessoo.travelagency.model.City;
import pl.ramzessoo.travelagency.model.Country;

public class CountryConverter {

    public static Country fromDto(CountryDto countryDto) {
        return Country.builder()
                .id(countryDto.getId())
                .name(countryDto.getName())
                .continent(ContinentConverter.fromDto(countryDto.getContinent()))
                .build();
    }

    public static CountryDto toDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .continent(ContinentConverter.toDto(country.getContinent()))
                .build();
    }

}

