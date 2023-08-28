package pl.ramzessoo.travelagency.converter;

import pl.ramzessoo.travelagency.dto.AirportDto;
import pl.ramzessoo.travelagency.dto.TourOrderDto;
import pl.ramzessoo.travelagency.model.Airport;
import pl.ramzessoo.travelagency.model.TourOrder;

public class TourOrderConverter {

    public static TourOrder fromDto(TourOrderDto tourOrderDto) {
        return TourOrder.builder()
                .tour(TourConverter.fromDto(tourOrderDto.getTour()))
                .build();
    }
}

