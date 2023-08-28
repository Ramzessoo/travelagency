package pl.ramzessoo.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ramzessoo.travelagency.model.TourOrder;

import java.util.List;

@Repository
public interface TourOrderRepository extends JpaRepository<TourOrder, Long> {

    List<TourOrder> findTop10ByOrderByOrderDateDesc();
}