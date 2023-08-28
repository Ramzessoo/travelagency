package pl.ramzessoo.travelagency.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CountryDto {
    private Long id;
    private String name;

    private ContinentDto continent;
}
