package pl.ramzessoo.travelagency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ramzessoo.travelagency.converter.HotelConverter;
import pl.ramzessoo.travelagency.dto.HotelDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.Hotel;
import pl.ramzessoo.travelagency.repository.HotelRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {
    @Autowired
    private final HotelRepository hotelRepository;

    public List<Hotel> allHotels() {
        return hotelRepository.findAll();
    }

    public Hotel hotelById(Long id) throws ResourceNotFoundException {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found for this id ::" + id));
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public HotelDto hotelDtoById(Long id) throws ResourceNotFoundException {
        return HotelConverter.toDto(hotelById(id));
    }

    public Set<HotelDto> hotelsDtoForCity(Long cityId) {
        List<Hotel> hotels = hotelRepository.findByCity_Id(cityId);
        return hotels.stream()
                .map(hotel -> HotelConverter.toDto(hotel))
                .collect(Collectors.toSet());
    }
}
