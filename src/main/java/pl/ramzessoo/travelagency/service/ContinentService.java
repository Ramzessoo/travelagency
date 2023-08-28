package pl.ramzessoo.travelagency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ramzessoo.travelagency.converter.ContinentConverter;
import pl.ramzessoo.travelagency.dto.ContinentDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.Continent;
import pl.ramzessoo.travelagency.repository.ContinentRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContinentService {

    @Autowired
    private final ContinentRepository continentRepository;

    public List<Continent> allContinents() {
        return continentRepository.findAll();
    }

    public Continent continentById(Long id) throws ResourceNotFoundException {
        return continentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Continent not found for this id :: " + id));
    }

    public ContinentDto continentDtoById(Long id) throws ResourceNotFoundException {
        return ContinentConverter.toDto(continentById(id));
    }
}
