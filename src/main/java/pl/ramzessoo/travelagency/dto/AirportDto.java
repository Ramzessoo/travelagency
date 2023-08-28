package pl.ramzessoo.travelagency.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AirportDto {

    private String iata;
    private String name;
}
