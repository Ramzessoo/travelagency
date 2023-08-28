package pl.ramzessoo.travelagency.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class TourTest {

    private Tour tour;

    @BeforeEach
    void setUp() {
        tour = new Tour();
    }

    @Test
    void shouldSet2InNumberOfDaysBetweenFirstAndThirdOfApril() {
        //        given
        tour.setDepartureDate(LocalDate.of(2023, Month.APRIL, 1));
        tour.setReturnDate(LocalDate.of(2023, Month.APRIL, 3));

        //        when
        tour.numberOfDays();

        //        then
        assertEquals(2, tour.getNumberOfDays());
    }
}