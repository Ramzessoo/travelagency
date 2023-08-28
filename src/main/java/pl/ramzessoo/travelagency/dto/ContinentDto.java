package pl.ramzessoo.travelagency.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContinentDto {

    private Long id;
    private String name;
}
