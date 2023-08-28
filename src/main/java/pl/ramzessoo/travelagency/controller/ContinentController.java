package pl.ramzessoo.travelagency.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.ramzessoo.travelagency.dto.ContinentDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.Continent;
import pl.ramzessoo.travelagency.service.ContinentService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/continents")
public class ContinentController {

    private final ContinentService continentService;

    @GetMapping("/")
    public List<Continent> getAllContinents() {
        return continentService.allContinents();
    }

    @GetMapping("/{id}")
    public ContinentDto getContinentById(@PathVariable(value = "id") Long id) {
        try {
            return continentService.continentDtoById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found", e);
        }
    }
}
