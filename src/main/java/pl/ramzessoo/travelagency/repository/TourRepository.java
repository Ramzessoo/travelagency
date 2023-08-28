package pl.ramzessoo.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ramzessoo.travelagency.model.Airport;
import pl.ramzessoo.travelagency.model.City;
import pl.ramzessoo.travelagency.model.Continent;
import pl.ramzessoo.travelagency.model.Country;
import pl.ramzessoo.travelagency.model.Tour;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    List<Tour> findByDepartureDateAfter(LocalDate departureDate);
    List<Tour> findByToCity_CountryAndDepartureDateAfter(Country country, LocalDate departureDate);
    List<Tour> findByToCityAndDepartureDateAfter(City fromCity, LocalDate departureDate);
    List<Tour> findByToAirportAndDepartureDateAfter(Airport fromAirport, LocalDate departureDate);
    List<Tour> findByToCity_Country_ContinentAndDepartureDateAfter(Continent continent, LocalDate departureDate);
    List<Tour> findTop3ByIsPromotedTrue();
    List<Tour> findTop3ByDepartureDateAfterOrderByDepartureDateAsc(LocalDate now);
}
