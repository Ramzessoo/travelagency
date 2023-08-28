package pl.ramzessoo.travelagency.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.ramzessoo.travelagency.dto.TourDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.Tour;
import pl.ramzessoo.travelagency.service.TourService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tours")
public class TourController {

    private final TourService tourService;

    @GetMapping("/")
    public List<TourDto> getAllTours(){
        return tourService.allTours();
    }

    @GetMapping("/bestOffers")
    public List<TourDto> getPromotedTours() {
        return tourService.promotedTours();
    }

    @GetMapping("/lastMinute")
    public List<TourDto> getLastMinute() {
        return tourService.lastMinuteTours();
    }

    @GetMapping("/lastBought")
    public List<TourDto> getLastBought() {
        return tourService.lastBoughtTours();
    }

    @GetMapping("/airportId={airportId}")
    public List<TourDto> getByAirport(@PathVariable(value = "airportId") String airportId) {
        try {
            return tourService.toursByAirportId(airportId);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found", e);
        }
    }

    @GetMapping("/cityId={cityId}")
    public List<TourDto> getByCiy(@PathVariable(value = "cityId") Long id) {
        try {
            return tourService.toursByCityId(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found", e);
        }
    }

    @GetMapping("/countryId={countryId}")
    public List<TourDto> getByCountry(@PathVariable(value = "countryId") Long id) {
        try {
            return tourService.toursByCountryId(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found", e);
        }
    }

    @GetMapping("/continentId={continentId}")
    public List<TourDto> getByContinent(@PathVariable(value = "continentId") Long id) {
        try {
            return tourService.toursByContinentId(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(tourService.tourById(id));
    }

    @PostMapping("/")
    public Tour createTour(@Valid @RequestBody Tour tour) {
        return tourService.addTour(tour);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tour> updateTour(@Valid @PathVariable(value = "id") Long id, @RequestBody Tour tourDetails)
            throws ResourceNotFoundException {
        return ResponseEntity.ok(tourService.updateTour(id, tourDetails));
    }

    @DeleteMapping("/{id}")
    public void deleteTour(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        tourService.deleteTour(id);
    }
}
