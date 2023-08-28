package pl.ramzessoo.travelagency.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.ramzessoo.travelagency.dto.AirportDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.Airport;
import pl.ramzessoo.travelagency.service.AirportService;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;

    @GetMapping("/")
    public List<Airport> getAllAirports() {
        return airportService.allAirports();
    }

    @GetMapping("/{iata}")
    public AirportDto getAirportByIata(@PathVariable(value = "iata") String iata){
        try {
            return airportService.airportDtoByIata(iata);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found", e);
        }
    }

    @GetMapping("/cityId={cityId}")
    public Set<AirportDto> getAirportForCity(@PathVariable("cityId")Long cityId){
        return airportService.airportsDtoForCity(cityId);
    }

    @PostMapping("/")
    public Airport createAirport(@Valid @RequestBody Airport airport) {
        return airportService.addAirport(airport);
    }

    @PutMapping("/{iata}")
    public ResponseEntity<Airport> updateAirport(@Valid @PathVariable(value = "iata") String iata, @RequestBody Airport airportDetails) throws ResourceNotFoundException {
        return ResponseEntity.ok(airportService.updateAirport(iata, airportDetails));
    }
}
