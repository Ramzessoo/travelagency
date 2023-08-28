package pl.ramzessoo.travelagency.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.ramzessoo.travelagency.converter.TourConverter;
import pl.ramzessoo.travelagency.dto.TourDto;
import pl.ramzessoo.travelagency.exception.ResourceNotFoundException;
import pl.ramzessoo.travelagency.model.Airport;
import pl.ramzessoo.travelagency.model.City;
import pl.ramzessoo.travelagency.model.Continent;
import pl.ramzessoo.travelagency.model.Country;
import pl.ramzessoo.travelagency.model.Tour;
import pl.ramzessoo.travelagency.model.TourOrder;
import pl.ramzessoo.travelagency.repository.TourOrderRepository;
import pl.ramzessoo.travelagency.repository.TourRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;
    private final TourOrderRepository tourOrderRepository;
    private final AirportService airportService;
    private final CityService cityService;
    private final CountryService countryService;
    private final ContinentService continentService;


    public List<TourDto> allTours() {
        List<Tour> tours = tourRepository.findByDepartureDateAfter(LocalDate.now());
        List<TourDto> tourDtos = tours.stream()
                .map(TourConverter::toDto)
                .collect(Collectors.toList());
        return tourDtos;
    }

    public Tour tourById(Long id) throws ResourceNotFoundException {
        return tourRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour not found for this id :: " + id));
    }

    public Tour addTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public Tour updateTour(Long id, Tour tourDetails) throws ResourceNotFoundException {
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour not found for this id :: " + id));

        tour.setDepartureDate(tourDetails.getDepartureDate());
        tour.setFromCity(tourDetails.getFromCity());
        tour.setFromAirport(tourDetails.getFromAirport());
        tour.setToCity(tourDetails.getToCity());
        tour.setToAirport(tourDetails.getToAirport());
        tour.setHotel(tourDetails.getHotel());
        tour.setReturnDate(tourDetails.getReturnDate());
        tour.setNumberOfDays(tourDetails.getNumberOfDays());
        tour.setTypeOfBoard(tourDetails.getTypeOfBoard());
        tour.setPriceForAdult(tourDetails.getPriceForAdult());
        tour.setPriceForKid(tourDetails.getPriceForKid());
        tour.setNumberOfAdults(tourDetails.getNumberOfAdults());
        tour.setNumberOfKids(tourDetails.getNumberOfKids());
        return tour;
    }

    public void deleteTour(Long id) throws ResourceNotFoundException {
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour not found for this id :: " + id));

        tourRepository.delete(tour);
    }

    public List<TourDto> promotedTours() {
        List<Tour> tours = tourRepository.findTop3ByIsPromotedTrue();
        List<TourDto> tourDtos = tours.stream()
                .map(TourConverter::toDto)
                .collect(Collectors.toList());
        return tourDtos;
    }

    public List<TourDto> lastMinuteTours() {
        List<Tour> tours = tourRepository.findTop3ByDepartureDateAfterOrderByDepartureDateAsc(
                LocalDate.now());
        List<TourDto> tourDtos = tours.stream()
                .map(TourConverter::toDto)
                .collect(Collectors.toList());
        return tourDtos;
    }

    public List<TourDto> lastBoughtTours() {
        List<TourOrder> lastOrders = tourOrderRepository.findTop10ByOrderByOrderDateDesc();

        return lastOrders.stream()
                .map(order -> order.getTour())
                .distinct()
                .map(tour -> TourConverter.toDto(tour))
                .collect(Collectors.toList());
    }

    public List<TourDto> toursByAirportId(@NonNull String airportIATA) throws ResourceNotFoundException {

        Airport airport = airportService.airportByIata(airportIATA);

        List<Tour> tours = tourRepository.findByToAirportAndDepartureDateAfter(airport, LocalDate.now());

        List<TourDto> tourDtos = tours.stream()
                .map(TourConverter::toDto)
                .collect(Collectors.toList());
        return tourDtos;
    }

    public List<TourDto> toursByCityId(@NonNull Long cityId) throws ResourceNotFoundException {

        City city = cityService.cityById(cityId);

        List<Tour> tours = tourRepository.findByToCityAndDepartureDateAfter(city, LocalDate.now());

        List<TourDto> tourDtos = tours.stream()
                .map(TourConverter::toDto)
                .collect(Collectors.toList());
        return tourDtos;
    }

    public List<TourDto> toursByCountryId(@NonNull Long countryId) throws ResourceNotFoundException {

        Country country = countryService.countryById(countryId);

        List<Tour> tours = tourRepository.findByToCity_CountryAndDepartureDateAfter(country, LocalDate.now());

        List<TourDto> tourDtos = tours.stream()
                .map(TourConverter::toDto)
                .collect(Collectors.toList());
        return tourDtos;
    }

    public List<TourDto> toursByContinentId(@NonNull Long continentId) throws ResourceNotFoundException {

        Continent continent = continentService.continentById(continentId);

        List<Tour> tours = tourRepository.findByToCity_Country_ContinentAndDepartureDateAfter(continent, LocalDate.now());

        List<TourDto> tourDtos = tours.stream()
                .map(TourConverter::toDto)
                .collect(Collectors.toList());
        return tourDtos;
    }
}
