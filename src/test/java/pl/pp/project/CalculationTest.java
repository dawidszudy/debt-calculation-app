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
    void modifiedDaySubtractionFor10NovemberSundayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2019, Month.NOVEMBER, 10);
        LocalDate datePayment = LocalDate.of(2019, Month.NOVEMBER, 20);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor01JanuarySaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2022, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor01JanuaryFridayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2021, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2021, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor01JanuaryAfter01012017() {
        LocalDate dateDue = LocalDate.of(2019, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2019, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor31DecemberSundayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2017, Month.DECEMBER, 31);
        LocalDate datePayment = LocalDate.of(2018, Month.JANUARY, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor31DecemberSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2022, Month.DECEMBER, 31);
        LocalDate datePayment = LocalDate.of(2023, Month.JANUARY, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor30DecemberSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2017, Month.DECEMBER, 30);
        LocalDate datePayment = LocalDate.of(2018, Month.JANUARY, 9);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor6JanuarySaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2018, Month.JANUARY, 6);
        LocalDate datePayment = LocalDate.of(2018, Month.JANUARY, 16);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor6JanuaryFridayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2017, Month.JANUARY, 6);
        LocalDate datePayment = LocalDate.of(2017, Month.JANUARY, 16);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor6JanuaryAfter01012017() {
        LocalDate dateDue = LocalDate.of(2020, Month.JANUARY, 6);
        LocalDate datePayment = LocalDate.of(2020, Month.JANUARY, 16);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor5JanuarySundayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2020, Month.JANUARY, 5);
        LocalDate datePayment = LocalDate.of(2020, Month.JANUARY, 15);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor5JanuarySaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2019, Month.JANUARY, 5);
        LocalDate datePayment = LocalDate.of(2019, Month.JANUARY, 15);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor4JanuarySaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2020, Month.JANUARY, 4);
        LocalDate datePayment = LocalDate.of(2020, Month.JANUARY, 14);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionForSundayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2018, Month.MAY, 13);
        LocalDate datePayment = LocalDate.of(2018, Month.MAY, 23);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2018, Month.MAY, 5);
        LocalDate datePayment = LocalDate.of(2018, Month.MAY, 15);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }



}