package pl.ramzessoo.travelagency.converter;

import pl.ramzessoo.travelagency.dto.TourDto;
import pl.ramzessoo.travelagency.model.Tour;

import java.time.LocalDate;

public class TourConverter {

    public static Tour fromDto(TourDto tourDto) {
        return Tour.builder()
                .id(tourDto.getId())
                .departureDate(LocalDate.parse(tourDto.getDepartureDate()))
                .fromCity(CityConverter.fromDto(tourDto.getFromCity()))
                .fromAirport(AirportConverter.fromDto(tourDto.getFromAirport()))
                .toCity(CityConverter.fromDto(tourDto.getToCity()))
                .toAirport(AirportConverter.fromDto(tourDto.getToAirport()))
                .hotel(HotelConverter.fromDto(tourDto.getHotel()))
                .returnDate(LocalDate.parse(tourDto.getReturnDate()))
                .numberOfDays(tourDto.getNumberOfDays())
                .typeOfBoard(tourDto.getTypeOfBoard())
                .priceForAdult(tourDto.getPriceForAdult())
                .priceForKid(tourDto.getPriceForKid())
                .isPromoted(tourDto.getIsPromoted())
                .numberOfAdults(tourDto.getNumberOfAdults())
                .numberOfKids(tourDto.getNumberOfKids())
                .build();
    }

    public static TourDto toDto(Tour tour) {
        return TourDto.builder()
                .id(tour.getId())
                .departureDate(tour.getDepartureDate().toString())
                .fromCity(CityConverter.toDto(tour.getFromCity()))
                .fromAirport(AirportConverter.toDto(tour.getFromAirport()))
                .toCity(CityConverter.toDto(tour.getToCity()))
                .toAirport(AirportConverter.toDto(tour.getToAirport()))
                .hotel(HotelConverter.toDto(tour.getHotel()))
                .returnDate(tour.getReturnDate().toString())
                .numberOfDays(tour.getNumberOfDays())
                .typeOfBoard(tour.getTypeOfBoard())
                .priceForAdult(tour.getPriceForAdult())
                .priceForKid(tour.getPriceForKid())
                .isPromoted(tour.getIsPromoted())
                .numberOfAdults(tour.getNumberOfAdults())
                .numberOfKids(tour.getNumberOfKids())
                .build();
    }

}

