package pl.pp.project;

import org.junit.jupiter.api.Test;
import pl.pp.project.model.Due;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationTest {

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
    void modifiedDaySubtractionFor1MaySaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2021, Month.MAY, 1);
        LocalDate datePayment = LocalDate.of(2021, Month.MAY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor1MayFridayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2020, Month.MAY, 1);
        LocalDate datePayment = LocalDate.of(2020, Month.MAY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor1MayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2019, Month.MAY, 1);
        LocalDate datePayment = LocalDate.of(2019, Month.MAY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor30AprilSundayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2017, Month.APRIL, 30);
        LocalDate datePayment = LocalDate.of(2017, Month.MAY, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor30AprilSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2022, Month.APRIL, 30);
        LocalDate datePayment = LocalDate.of(2022, Month.MAY, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor29AprilSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2023, Month.APRIL, 29);
        LocalDate datePayment = LocalDate.of(2023, Month.MAY, 9);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor3MaySaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2025, Month.MAY, 3);
        LocalDate datePayment = LocalDate.of(2025, Month.MAY, 13);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor3MayFridayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2019, Month.MAY, 3);
        LocalDate datePayment = LocalDate.of(2019, Month.MAY, 13);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor3MayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2018, Month.MAY, 3);
        LocalDate datePayment = LocalDate.of(2018, Month.MAY, 13);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor2MaySaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2020, Month.MAY, 2);
        LocalDate datePayment = LocalDate.of(2020, Month.MAY, 12);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor2MaySundayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2021, Month.MAY, 2);
        LocalDate datePayment = LocalDate.of(2021, Month.MAY, 12);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor15AugustSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2020, Month.AUGUST, 15);
        LocalDate datePayment = LocalDate.of(2020, Month.AUGUST, 25);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor15AugustFridayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2025, Month.AUGUST, 15);
        LocalDate datePayment = LocalDate.of(2025, Month.AUGUST, 25);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor15AugustAfter01012017() {
        LocalDate dateDue = LocalDate.of(2018, Month.AUGUST, 15);
        LocalDate datePayment = LocalDate.of(2018, Month.AUGUST, 25);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor14AugustSundayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2022, Month.AUGUST, 14);
        LocalDate datePayment = LocalDate.of(2022, Month.AUGUST, 24);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor14AugustSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2021, Month.AUGUST, 14);
        LocalDate datePayment = LocalDate.of(2021, Month.AUGUST, 24);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor13AugustSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2022, Month.AUGUST, 13);
        LocalDate datePayment = LocalDate.of(2022, Month.AUGUST, 23);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor1NovemberSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2025, Month.NOVEMBER, 1);
        LocalDate datePayment = LocalDate.of(2025, Month.NOVEMBER, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor1NovemberFridayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2019, Month.NOVEMBER, 1);
        LocalDate datePayment = LocalDate.of(2019, Month.NOVEMBER, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor1NovemberAfter01012017() {
        LocalDate dateDue = LocalDate.of(2017, Month.NOVEMBER, 1);
        LocalDate datePayment = LocalDate.of(2017, Month.NOVEMBER, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor31OctoberSundayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2021, Month.OCTOBER, 31);
        LocalDate datePayment = LocalDate.of(2021, Month.NOVEMBER, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor31OctoberSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2020, Month.OCTOBER, 31);
        LocalDate datePayment = LocalDate.of(2020, Month.NOVEMBER, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor30OctoberSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2021, Month.OCTOBER, 30);
        LocalDate datePayment = LocalDate.of(2021, Month.NOVEMBER, 9);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor11NovemberSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2017, Month.NOVEMBER, 11);
        LocalDate datePayment = LocalDate.of(2017, Month.NOVEMBER, 21);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor11NovemberFridayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2022, Month.NOVEMBER, 11);
        LocalDate datePayment = LocalDate.of(2022, Month.NOVEMBER, 21);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor11NovemberAfter01012017() {
        LocalDate dateDue = LocalDate.of(2020, Month.NOVEMBER, 11);
        LocalDate datePayment = LocalDate.of(2020, Month.NOVEMBER, 21);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
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
    void modifiedDaySubtractionFor10NovemberSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2018, Month.NOVEMBER, 10);
        LocalDate datePayment = LocalDate.of(2018, Month.NOVEMBER, 20);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor9NovemberSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2019, Month.NOVEMBER, 9);
        LocalDate datePayment = LocalDate.of(2019, Month.NOVEMBER, 19);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor25DecemberSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2021, Month.DECEMBER, 25);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 4);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor25DecemberFridayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2020, Month.DECEMBER, 25);
        LocalDate datePayment = LocalDate.of(2021, Month.JANUARY, 4);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor25DecemberThursdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2025, Month.DECEMBER, 25);
        LocalDate datePayment = LocalDate.of(2026, Month.JANUARY, 4);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(6, result);
    }

    @Test
    void modifiedDaySubtractionFor25DecemberAfter01012017() {
        LocalDate dateDue = LocalDate.of(2017, Month.DECEMBER, 25);
        LocalDate datePayment = LocalDate.of(2018, Month.JANUARY, 4);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor24DecemberSundayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2017, Month.DECEMBER, 24);
        LocalDate datePayment = LocalDate.of(2018, Month.JANUARY, 3);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor24DecemberSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2022, Month.DECEMBER, 24);
        LocalDate datePayment = LocalDate.of(2023, Month.JANUARY, 3);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor23DecemberSaturdayAfter01012017() {
        LocalDate dateDue = LocalDate.of(2017, Month.DECEMBER, 23);
        LocalDate datePayment = LocalDate.of(2018, Month.JANUARY, 2);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(6, result);
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

    @Test
    void modifiedDaySubtractionForEasterSunday2002() {
        LocalDate dateDue = LocalDate.of(2002, Month.MARCH, 31);
        LocalDate datePayment = LocalDate.of(2002, Month.APRIL, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionForEasterMonday2002() {
        LocalDate dateDue = LocalDate.of(2002, Month.APRIL, 1);
        LocalDate datePayment = LocalDate.of(2002, Month.APRIL, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSaturday2002() {
        LocalDate dateDue = LocalDate.of(2002, Month.MARCH, 30);
        LocalDate datePayment = LocalDate.of(2002, Month.APRIL, 9);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(10, result);
    }

    @Test
    void modifiedDaySubtractionForCorpusChristi2002() {
        LocalDate dateDue = LocalDate.of(2002, Month.MAY, 30);
        LocalDate datePayment = LocalDate.of(2002, Month.JUNE, 9);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSunday2007() {
        LocalDate dateDue = LocalDate.of(2007, Month.APRIL, 8);
        LocalDate datePayment = LocalDate.of(2007, Month.APRIL, 18);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionForEasterMonday2007() {
        LocalDate dateDue = LocalDate.of(2007, Month.APRIL, 9);
        LocalDate datePayment = LocalDate.of(2007, Month.APRIL, 19);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSaturday2007() {
        LocalDate dateDue = LocalDate.of(2007, Month.APRIL, 7);
        LocalDate datePayment = LocalDate.of(2007, Month.APRIL, 17);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(10, result);
    }

    @Test
    void modifiedDaySubtractionForCorpusChristi2007() {
        LocalDate dateDue = LocalDate.of(2007, Month.JUNE, 7);
        LocalDate datePayment = LocalDate.of(2007, Month.JUNE, 17);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSunday2011() {
        LocalDate dateDue = LocalDate.of(2011, Month.APRIL, 24);
        LocalDate datePayment = LocalDate.of(2011, Month.MAY, 4);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionForEasterMonday2011() {
        LocalDate dateDue = LocalDate.of(2011, Month.APRIL, 25);
        LocalDate datePayment = LocalDate.of(2011, Month.MAY, 5);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSaturday2011() {
        LocalDate dateDue = LocalDate.of(2011, Month.APRIL, 23);
        LocalDate datePayment = LocalDate.of(2011, Month.MAY, 3);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(10, result);
    }

    @Test
    void modifiedDaySubtractionForCorpusChristi2011() {
        LocalDate dateDue = LocalDate.of(2011, Month.JUNE, 23);
        LocalDate datePayment = LocalDate.of(2011, Month.JULY, 3);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSunday2013() {
        LocalDate dateDue = LocalDate.of(2013, Month.MARCH, 31);
        LocalDate datePayment = LocalDate.of(2013, Month.APRIL, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionForEasterMonday2013() {
        LocalDate dateDue = LocalDate.of(2013, Month.APRIL, 1);
        LocalDate datePayment = LocalDate.of(2013, Month.APRIL, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSaturday2013() {
        LocalDate dateDue = LocalDate.of(2013, Month.MARCH, 30);
        LocalDate datePayment = LocalDate.of(2013, Month.APRIL, 9);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(10, result);
    }

    @Test
    void modifiedDaySubtractionForCorpusChristi2013() {
        LocalDate dateDue = LocalDate.of(2013, Month.MAY, 30);
        LocalDate datePayment = LocalDate.of(2013, Month.JUNE, 9);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSunday2015() {
        LocalDate dateDue = LocalDate.of(2015, Month.APRIL, 5);
        LocalDate datePayment = LocalDate.of(2015, Month.APRIL, 15);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionForEasterMonday2015() {
        LocalDate dateDue = LocalDate.of(2015, Month.APRIL, 6);
        LocalDate datePayment = LocalDate.of(2015, Month.APRIL, 16);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSaturday2015() {
        LocalDate dateDue = LocalDate.of(2015, Month.APRIL, 4);
        LocalDate datePayment = LocalDate.of(2015, Month.APRIL, 14);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(10, result);
    }

    @Test
    void modifiedDaySubtractionForCorpusChristi2015() {
        LocalDate dateDue = LocalDate.of(2015, Month.JUNE, 4);
        LocalDate datePayment = LocalDate.of(2015, Month.JUNE, 14);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSunday2018() {
        LocalDate dateDue = LocalDate.of(2018, Month.APRIL, 1);
        LocalDate datePayment = LocalDate.of(2018, Month.APRIL, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionForEasterMonday2018() {
        LocalDate dateDue = LocalDate.of(2018, Month.APRIL, 2);
        LocalDate datePayment = LocalDate.of(2018, Month.APRIL, 12);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSaturday2018() {
        LocalDate dateDue = LocalDate.of(2018, Month.MARCH, 31);
        LocalDate datePayment = LocalDate.of(2018, Month.APRIL, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionForCorpusChristi2018() {
        LocalDate dateDue = LocalDate.of(2018, Month.MAY, 31);
        LocalDate datePayment = LocalDate.of(2018, Month.JUNE, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSunday2020() {
        LocalDate dateDue = LocalDate.of(2020, Month.APRIL, 12);
        LocalDate datePayment = LocalDate.of(2020, Month.APRIL, 22);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionForEasterMonday2020() {
        LocalDate dateDue = LocalDate.of(2020, Month.APRIL, 13);
        LocalDate datePayment = LocalDate.of(2020, Month.APRIL, 23);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSaturday2020() {
        LocalDate dateDue = LocalDate.of(2020, Month.APRIL, 11);
        LocalDate datePayment = LocalDate.of(2020, Month.APRIL, 21);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionForCorpusChristi2020() {
        LocalDate dateDue = LocalDate.of(2020, Month.JUNE, 11);
        LocalDate datePayment = LocalDate.of(2020, Month.JUNE, 21);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSunday2021() {
        LocalDate dateDue = LocalDate.of(2021, Month.APRIL, 4);
        LocalDate datePayment = LocalDate.of(2021, Month.APRIL, 14);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionForEasterMonday2021() {
        LocalDate dateDue = LocalDate.of(2021, Month.APRIL, 5);
        LocalDate datePayment = LocalDate.of(2021, Month.APRIL, 15);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSaturday2021() {
        LocalDate dateDue = LocalDate.of(2021, Month.APRIL, 3);
        LocalDate datePayment = LocalDate.of(2021, Month.APRIL, 13);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionForCorpusChristi2021() {
        LocalDate dateDue = LocalDate.of(2021, Month.JUNE, 3);
        LocalDate datePayment = LocalDate.of(2021, Month.JUNE, 13);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSunday2024() {
        LocalDate dateDue = LocalDate.of(2024, Month.MARCH, 31);
        LocalDate datePayment = LocalDate.of(2024, Month.APRIL, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionForEasterMonday2024() {
        LocalDate dateDue = LocalDate.of(2024, Month.APRIL, 1);
        LocalDate datePayment = LocalDate.of(2024, Month.APRIL, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionForEasterSaturday2024() {
        LocalDate dateDue = LocalDate.of(2024, Month.MARCH, 30);
        LocalDate datePayment = LocalDate.of(2024, Month.APRIL, 9);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionForCorpusChristi2024() {
        LocalDate dateDue = LocalDate.of(2024, Month.MAY, 30);
        LocalDate datePayment = LocalDate.of(2024, Month.JUNE, 9);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor01JanuarySaturdayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2011, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2011, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor01JanuaryBefore01012017() {
        LocalDate dateDue = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2015, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor31DecemberSundayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2006, Month.DECEMBER, 31);
        LocalDate datePayment = LocalDate.of(2007, Month.JANUARY, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor06JanuaryBefore01012017() {
        LocalDate dateDue = LocalDate.of(2016, Month.JANUARY, 6);
        LocalDate datePayment = LocalDate.of(2016, Month.JANUARY, 16);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor05JanuarySundayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2014, Month.JANUARY, 5);
        LocalDate datePayment = LocalDate.of(2014, Month.JANUARY, 15);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor01MaySaturdayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2010, Month.MAY, 1);
        LocalDate datePayment = LocalDate.of(2010, Month.MAY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor01MayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2009, Month.MAY, 1);
        LocalDate datePayment = LocalDate.of(2009, Month.MAY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor30AprilSundayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2006, Month.APRIL, 30);
        LocalDate datePayment = LocalDate.of(2006, Month.MAY, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor02MaySundayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2010, Month.MAY, 2);
        LocalDate datePayment = LocalDate.of(2010, Month.MAY, 12);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor03MaySaturdayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2014, Month.MAY, 3);
        LocalDate datePayment = LocalDate.of(2014, Month.MAY, 13);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor03MayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2016, Month.MAY, 3);
        LocalDate datePayment = LocalDate.of(2016, Month.MAY, 13);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor15AugustSaturdayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2015, Month.AUGUST, 15);
        LocalDate datePayment = LocalDate.of(2015, Month.AUGUST, 25);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor15AugustBefore01012017() {
        LocalDate dateDue = LocalDate.of(2013, Month.AUGUST, 15);
        LocalDate datePayment = LocalDate.of(2013, Month.AUGUST, 25);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor14AugustSundayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2016, Month.AUGUST, 14);
        LocalDate datePayment = LocalDate.of(2016, Month.AUGUST, 24);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor01NovemberSaturdayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2014, Month.NOVEMBER, 1);
        LocalDate datePayment = LocalDate.of(2014, Month.NOVEMBER, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor01NovemberBefore01012017() {
        LocalDate dateDue = LocalDate.of(2016, Month.NOVEMBER, 1);
        LocalDate datePayment = LocalDate.of(2016, Month.NOVEMBER, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor31OctoberSundayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2010, Month.OCTOBER, 31);
        LocalDate datePayment = LocalDate.of(2010, Month.NOVEMBER, 10);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor11NovemberSaturdayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2006, Month.NOVEMBER, 11);
        LocalDate datePayment = LocalDate.of(2006, Month.NOVEMBER, 21);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor11NovemberBefore01012017() {
        LocalDate dateDue = LocalDate.of(2015, Month.NOVEMBER, 11);
        LocalDate datePayment = LocalDate.of(2015, Month.NOVEMBER, 21);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor10NovemberSundayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2013, Month.NOVEMBER, 10);
        LocalDate datePayment = LocalDate.of(2013, Month.NOVEMBER, 20);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor25DecemberSaturdayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2010, Month.DECEMBER, 25);
        LocalDate datePayment = LocalDate.of(2011, Month.JANUARY, 4);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor25DecemberFridayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2009, Month.DECEMBER, 25);
        LocalDate datePayment = LocalDate.of(2010, Month.JANUARY, 4);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionFor25DecemberBefore01012017() {
        LocalDate dateDue = LocalDate.of(2007, Month.DECEMBER, 25);
        LocalDate datePayment = LocalDate.of(2008, Month.JANUARY, 4);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor26DecemberSaturdayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2015, Month.DECEMBER, 26);
        LocalDate datePayment = LocalDate.of(2016, Month.JANUARY, 5);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(8, result);
    }

    @Test
    void modifiedDaySubtractionFor26DecemberBefore01012017() {
        LocalDate dateDue = LocalDate.of(2016, Month.DECEMBER, 26);
        LocalDate datePayment = LocalDate.of(2017, Month.JANUARY, 5);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor24DecemberSundayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2006, Month.DECEMBER, 24);
        LocalDate datePayment = LocalDate.of(2007, Month.JANUARY, 3);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(7, result);
    }

    @Test
    void modifiedDaySubtractionForSundayBefore01012017() {
        LocalDate dateDue = LocalDate.of(2014, Month.MAY, 18);
        LocalDate datePayment = LocalDate.of(2014, Month.MAY, 28);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }

    @Test
    void modifiedDaySubtractionFor06JanuaryBefore01012011() {
        LocalDate dateDue = LocalDate.of(2010, Month.JANUARY, 6);
        LocalDate datePayment = LocalDate.of(2010, Month.JANUARY, 16);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(10, result);
    }

    @Test
    void modifiedDaySubtractionFor06JanuarySaturdayBefore01012011() {
        LocalDate dateDue = LocalDate.of(2007, Month.JANUARY, 6);
        LocalDate datePayment = LocalDate.of(2007, Month.JANUARY, 16);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(10, result);
    }

    @Test
    void modifiedDaySubtractionFor06JanuaryFridayBefore01012011() {
        LocalDate dateDue = LocalDate.of(2006, Month.JANUARY, 6);
        LocalDate datePayment = LocalDate.of(2006, Month.JANUARY, 16);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(10, result);
    }

    @Test
    void modifiedDaySubtractionFor05SundayBefore01012011() {
        LocalDate dateDue = LocalDate.of(2003, Month.JANUARY, 5);
        LocalDate datePayment = LocalDate.of(2003, Month.JANUARY, 15);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        long result = subtractionCalculation.calculateDaysSubtraction();
        assertEquals(9, result);
    }


}