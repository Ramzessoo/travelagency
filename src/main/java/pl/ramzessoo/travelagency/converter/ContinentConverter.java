package pl.ramzessoo.travelagency.converter;

import pl.ramzessoo.travelagency.dto.ContinentDto;
import pl.ramzessoo.travelagency.model.Continent;

public class ContinentConverter {

    public static Continent fromDto(ContinentDto continentDto) {
        return Continent.builder()
                .id(continentDto.getId())
                .name(continentDto.getName())
                .build();
    }

    public static ContinentDto toDto(Continent continent) {
        return ContinentDto.builder()
                .id(continent.getId())
                .name(continent.getName())
                .build();
    }

}

