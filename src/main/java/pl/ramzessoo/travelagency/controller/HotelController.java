package pl.ramzessoo.travelagency.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.ramzessoo.travelagency.dto.HotelDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.Hotel;
import pl.ramzessoo.travelagency.service.HotelService;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/")
    public List<Hotel> getAllHotels() {
        return hotelService.allHotels();
    }

    @GetMapping("/cityId={cityId}")
    public Set<HotelDto> getHotelsForCity(@PathVariable("cityId") Long cityId) {
        return hotelService.hotelsDtoForCity(cityId);
    }

    @GetMapping("/{id}")
    public HotelDto getHotelById(@PathVariable(value = "id") Long id) {
        try {
            return hotelService.hotelDtoById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found", e);
        }
    }

    @PostMapping("/")
    public Hotel createHotel(@Valid @RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }
}
