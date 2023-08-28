package pl.ramzessoo.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ramzessoo.travelagency.model.Continent;

import java.util.Optional;

@Repository
public interface ContinentRepository extends JpaRepository <Continent, Long>{
    @Override
    Optional<Continent> findById(Long id);
}
