package pl.ramzessoo.travelagency.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HotelDto {
    private Long id;
    private String name;
    private CityDto city;
    private String standard;
    private String description;
}
