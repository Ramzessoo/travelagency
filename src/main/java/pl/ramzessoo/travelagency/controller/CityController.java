package pl.ramzessoo.travelagency.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.ramzessoo.travelagency.dto.CityDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.City;
import pl.ramzessoo.travelagency.service.CityService;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @GetMapping("/")
    public Set<CityDto> getAllCities() {
        return cityService.allCities();
    }

    @GetMapping("/{id}")
    public CityDto getCityById(@PathVariable("id") Long id){
        try {
            return cityService.cityDtoById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found", e);
        }
    }

    @PostMapping("/")
    public City createCity(@RequestBody City city) {
        return cityService.addCity(city);
    }
}
