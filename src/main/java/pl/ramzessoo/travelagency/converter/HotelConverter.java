package pl.ramzessoo.travelagency.converter;

import pl.ramzessoo.travelagency.dto.AirportDto;
import pl.ramzessoo.travelagency.dto.HotelDto;
import pl.ramzessoo.travelagency.model.Airport;
import pl.ramzessoo.travelagency.model.Hotel;

public class HotelConverter {

    public static Hotel fromDto(HotelDto hotelDto) {
        return Hotel.builder()
                .id(hotelDto.getId())
                .name(hotelDto.getName())
                .city(CityConverter.fromDto(hotelDto.getCity()))
                .standard(hotelDto.getStandard())
                .description(hotelDto.getDescription())
                .build();
    }

    public static HotelDto toDto(Hotel hotel) {
        return HotelDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .city(CityConverter.toDto(hotel.getCity()))
                .standard(hotel.getStandard())
                .description(hotel.getDescription())
                .build();
    }

}

