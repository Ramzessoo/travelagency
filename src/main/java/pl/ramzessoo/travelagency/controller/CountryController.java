package pl.ramzessoo.travelagency.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.ramzessoo.travelagency.dto.CountryDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.Continent;
import pl.ramzessoo.travelagency.model.Country;
import pl.ramzessoo.travelagency.service.CountryService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/countries")
@RestController
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/")
    private List<Country> getAllCountries() {
        return countryService.allCountries();
    }

    @GetMapping("/{id}")
    private CountryDto getCountryById(@PathVariable("id") Long id) {
        try {
            return countryService.countryDtoById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found", e);
        }
    }

    @PostMapping("/")
    private Country addTour(@Valid @RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Country> updateCountry (@Valid @PathVariable("id") Long id, Country countryDetails) throws ResourceNotFoundException {
        return ResponseEntity.ok(countryService.updateCountry(id, countryDetails));
    }
}
