package pl.ramzessoo.travelagency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ramzessoo.travelagency.converter.CityConverter;
import pl.ramzessoo.travelagency.dto.CityDto;
import pl.ramzessoo.travelagency.dto.CountryDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.City;
import pl.ramzessoo.travelagency.repository.CityRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CityService {

    @Autowired
    private final CityRepository cityRepository;


    public Set<CityDto> allCities() {
        List<City> cities = cityRepository.findAll();
        return cities.stream()
                .map(city -> CityConverter.toDto(city))
                .collect(Collectors.toSet());
    }

    public City cityById(Long id) throws ResourceNotFoundException {
        return cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not found for this id ::" + id));
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City cityDetails) throws ResourceNotFoundException {
        City city = cityRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("City not found for this id :: " + id));
        city.setName(cityDetails.getName());
        city.setCountry(cityDetails.getCountry());

        return city;
    }

    public CityDto cityDtoById(Long id) throws ResourceNotFoundException {
        return CityConverter.toDto(cityById(id));
    }

    public Set<CityDto> citiesDtoForCountry(Long countryId) throws ResourceNotFoundException {
        List<City> cities = cityRepository.findByCountryId(countryId);

        return cities.stream()
                .map(city -> CityConverter.toDto(city))
                .collect(Collectors.toSet());
    }
}
