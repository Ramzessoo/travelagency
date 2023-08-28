package pl.ramzessoo.travelagency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ramzessoo.travelagency.converter.CountryConverter;
import pl.ramzessoo.travelagency.dto.CountryDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.Continent;
import pl.ramzessoo.travelagency.model.Country;
import pl.ramzessoo.travelagency.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> allCountries() {
        return countryRepository.findAll();
    }

    public Country countryById(Long id) throws ResourceNotFoundException {
        return countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country not found for this id :: "));
    }

    public List<Country> countriesByContinent(Continent name){
        return countryRepository.findByContinent(name);
    }
    public Optional<Country> countryByName(String name){
        return countryRepository.findByName(name);
    }
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(Long id, Country countryDetails) throws ResourceNotFoundException {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found for this id :: " + id));
        country.setName(countryDetails.getName());
        country.setContinent(countryDetails.getContinent());

        return country;
    }

    public CountryDto countryDtoById(Long id) throws ResourceNotFoundException {
        return CountryConverter.toDto(countryById(id));
    }
}
