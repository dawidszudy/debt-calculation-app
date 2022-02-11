package pl.pp.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.pp.project.model.Due;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void modifiedDaySubtraction() {
        LocalDate dateDue = LocalDate.of(2019, Month.NOVEMBER, 10);
        LocalDate datePayment = LocalDate.of(2019, Month.NOVEMBER, 20);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();

        assertEquals(8, result);
    }

}