package pl.ramzessoo.travelagency.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tours")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private LocalDate departureDate;

    @ManyToOne
    @JoinColumn(name = "from_city")
    @NonNull
    private City fromCity;

    @ManyToOne
    @JoinColumn(name = "from_airport")
    @NonNull
    private Airport fromAirport;

    @ManyToOne
    @JoinColumn(name = "to_city")
    @NonNull
    private City toCity;

    @ManyToOne
    @JoinColumn(name = "to_airport")
    @NonNull
    private Airport toAirport;

    @ManyToOne
    @JoinColumn(name = "hotel")
    @NonNull
    private Hotel hotel;

    @NonNull
    private LocalDate returnDate;

    private Integer numberOfDays;

    @NonNull
    private String typeOfBoard;

    @JoinColumn(name = "price_for_adult")
    @NonNull
    private BigDecimal priceForAdult;

    @JoinColumn(name = "price_for_kid")
    @NonNull
    private BigDecimal priceForKid;

    private Boolean isPromoted = false;

    @NonNull
    private Integer numberOfAdults;

    @NonNull
    private Integer numberOfKids;

    @PrePersist
    void numberOfDays(){
        this.numberOfDays = (int) DAYS.between(this.departureDate, this.returnDate);
    }
}
