package pl.ramzessoo.travelagency.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.ramzessoo.travelagency.dto.TourOrderDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.Tour;
import pl.ramzessoo.travelagency.model.TourOrder;
import pl.ramzessoo.travelagency.service.TourOrderService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class TourOrderController {

    private final TourOrderService tourOrderService;

    @PostMapping("/")
    public void createTourOrder(@Valid @RequestBody TourOrderDto tourOrder) {
        try {
            tourOrderService.save(tourOrder);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found", e);
        }
    }

}
