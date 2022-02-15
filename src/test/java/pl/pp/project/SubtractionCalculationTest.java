package pl.pp.project;

import org.junit.jupiter.api.Test;
import pl.pp.project.model.Due;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionCalculationTest {

    @Test
    void calculateEasterDay1998() {
        LocalDate dayEaster = LocalDate.of(1998,Month.APRIL, 12);

        LocalDate dateDue = LocalDate.of(1998, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDay(dateDue.getYear());
        assertEquals(dayEaster, result);
    }

    @Test
    void calculateEasterDay1999() {
        LocalDate dayEaster = LocalDate.of(1999,Month.APRIL, 4);

        LocalDate dateDue = LocalDate.of(1999, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDay(dateDue.getYear());
        assertEquals(dayEaster, result);
    }

    @Test
    void calculateEasterDay2000() {
        LocalDate dayEaster = LocalDate.of(2000,Month.APRIL, 23);

        LocalDate dateDue = LocalDate.of(2000, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDay(dateDue.getYear());
        assertEquals(dayEaster, result);
    }

}