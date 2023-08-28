package pl.ramzessoo.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ramzessoo.travelagency.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
