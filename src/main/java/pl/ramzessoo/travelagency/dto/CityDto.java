package pl.ramzessoo.travelagency.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CityDto {
    private Long id;
    private String name;
    private CountryDto country;
}
