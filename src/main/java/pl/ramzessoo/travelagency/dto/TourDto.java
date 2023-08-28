package pl.ramzessoo.travelagency.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class TourDto {
    private Long id;

    private String departureDate;
    private CityDto fromCity;
    private AirportDto fromAirport;
    private CityDto toCity;
    private AirportDto toAirport;
    private HotelDto hotel;
    private String returnDate;
    private Integer numberOfDays;
    private String typeOfBoard;
    private BigDecimal priceForAdult;
    private BigDecimal priceForKid;
    private Boolean isPromoted;
    private Integer numberOfAdults;
    private Integer numberOfKids;
}
