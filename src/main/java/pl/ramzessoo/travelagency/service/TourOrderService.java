package pl.ramzessoo.travelagency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.ramzessoo.travelagency.converter.TourOrderConverter;
import pl.ramzessoo.travelagency.dto.TourOrderDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.Tour;
import pl.ramzessoo.travelagency.model.TourOrder;
import pl.ramzessoo.travelagency.repository.TourOrderRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TourOrderService {

    private final TourOrderRepository tourOrderRepository;
    private final TourService tourService;

    public void save(TourOrderDto tourOrderDto) throws ResourceNotFoundException {
        Tour tour = tourService.tourById(tourOrderDto.getTour().getId());
        TourOrder tourOrder = tourOrderRepository.save(TourOrderConverter.fromDto(tourOrderDto));
    }

}
