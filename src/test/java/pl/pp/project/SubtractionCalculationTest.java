package pl.pp.project;

import org.junit.jupiter.api.Test;
import pl.pp.project.model.Due;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionCalculationTest {

    @Test
    void calculateEasterDate1998() {
        LocalDate easterDate = LocalDate.of(1998,Month.APRIL, 12);

        LocalDate dateDue = LocalDate.of(1998, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate1999() {
        LocalDate easterDate = LocalDate.of(1999,Month.APRIL, 4);

        LocalDate dateDue = LocalDate.of(1999, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2000() {
        LocalDate easterDate = LocalDate.of(2000,Month.APRIL, 23);

        LocalDate dateDue = LocalDate.of(2000, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2001() {
        LocalDate easterDate = LocalDate.of(2001,Month.APRIL, 15);

        LocalDate dateDue = LocalDate.of(2001, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2002() {
        LocalDate easterDate = LocalDate.of(2002,Month.MARCH, 31);

        LocalDate dateDue = LocalDate.of(2002, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2003() {
        LocalDate easterDate = LocalDate.of(2003,Month.APRIL, 20);

        LocalDate dateDue = LocalDate.of(2003, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2004() {
        LocalDate easterDate = LocalDate.of(2004,Month.APRIL, 11);

        LocalDate dateDue = LocalDate.of(2004, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2005() {
        LocalDate easterDate = LocalDate.of(2005,Month.MARCH, 27);

        LocalDate dateDue = LocalDate.of(2005, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2006() {
        LocalDate easterDate = LocalDate.of(2006,Month.APRIL, 16);

        LocalDate dateDue = LocalDate.of(2006, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2007() {
        LocalDate easterDate = LocalDate.of(2007,Month.APRIL, 8);

        LocalDate dateDue = LocalDate.of(2007, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2008() {
        LocalDate easterDate = LocalDate.of(2008,Month.MARCH, 23);

        LocalDate dateDue = LocalDate.of(2008, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2009() {
        LocalDate easterDate = LocalDate.of(2009,Month.APRIL, 12);

        LocalDate dateDue = LocalDate.of(2009, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2010() {
        LocalDate easterDate = LocalDate.of(2010,Month.APRIL, 4);

        LocalDate dateDue = LocalDate.of(2010, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2011() {
        LocalDate easterDate = LocalDate.of(2011,Month.APRIL, 24);

        LocalDate dateDue = LocalDate.of(2011, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2012() {
        LocalDate easterDate = LocalDate.of(2012,Month.APRIL, 8);

        LocalDate dateDue = LocalDate.of(2012, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2013() {
        LocalDate easterDate = LocalDate.of(2013,Month.MARCH, 31);

        LocalDate dateDue = LocalDate.of(2013, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2014() {
        LocalDate easterDate = LocalDate.of(2014,Month.APRIL, 20);

        LocalDate dateDue = LocalDate.of(2014, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2015() {
        LocalDate easterDate = LocalDate.of(2015,Month.APRIL, 5);

        LocalDate dateDue = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2016() {
        LocalDate easterDate = LocalDate.of(2016,Month.MARCH, 27);

        LocalDate dateDue = LocalDate.of(2016, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2017() {
        LocalDate easterDate = LocalDate.of(2017,Month.APRIL, 16);

        LocalDate dateDue = LocalDate.of(2017, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2018() {
        LocalDate easterDate = LocalDate.of(2018,Month.APRIL, 1);

        LocalDate dateDue = LocalDate.of(2018, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2019() {
        LocalDate easterDate = LocalDate.of(2019,Month.APRIL, 21);

        LocalDate dateDue = LocalDate.of(2019, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2020() {
        LocalDate easterDate = LocalDate.of(2020,Month.APRIL, 12);

        LocalDate dateDue = LocalDate.of(2020, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2021() {
        LocalDate easterDate = LocalDate.of(2021,Month.APRIL, 4);

        LocalDate dateDue = LocalDate.of(2021, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2022() {
        LocalDate easterDate = LocalDate.of(2022,Month.APRIL, 17);

        LocalDate dateDue = LocalDate.of(2022, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2023() {
        LocalDate easterDate = LocalDate.of(2023,Month.APRIL, 9);

        LocalDate dateDue = LocalDate.of(2023, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateEasterDate2024() {
        LocalDate easterDate = LocalDate.of(2024,Month.MARCH, 31);

        LocalDate dateDue = LocalDate.of(2024, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.calculateEasterDate(dateDue.getYear());
        assertEquals(easterDate, result);
    }

    @Test
    void calculateCorpusChristiDate2000() {
        LocalDate corpusChristiDate = LocalDate.of(2000,Month.JUNE, 22);

        LocalDate dateDue = LocalDate.of(2000, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.getCorpusChristiDate();

        assertEquals(corpusChristiDate, result);
    }

    @Test
    void calculateCorpusChristiDate2002() {
        LocalDate corpusChristiDate = LocalDate.of(2002,Month.MAY, 30);

        LocalDate dateDue = LocalDate.of(2002, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.getCorpusChristiDate();

        assertEquals(corpusChristiDate, result);
    }

    @Test
    void calculateCorpusChristiDate2005() {
        LocalDate corpusChristiDate = LocalDate.of(2005,Month.MAY, 26);

        LocalDate dateDue = LocalDate.of(2005, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.getCorpusChristiDate();

        assertEquals(corpusChristiDate, result);
    }

    @Test
    void calculateCorpusChristiDate2010() {
        LocalDate corpusChristiDate = LocalDate.of(2010,Month.JUNE, 3);

        LocalDate dateDue = LocalDate.of(2010, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.getCorpusChristiDate();

        assertEquals(corpusChristiDate, result);
    }

    @Test
    void calculateCorpusChristiDate2013() {
        LocalDate corpusChristiDate = LocalDate.of(2013,Month.MAY, 30);

        LocalDate dateDue = LocalDate.of(2013, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.getCorpusChristiDate();

        assertEquals(corpusChristiDate, result);
    }

    @Test
    void calculateCorpusChristiDate2015() {
        LocalDate corpusChristiDate = LocalDate.of(2015,Month.JUNE, 4);

        LocalDate dateDue = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.getCorpusChristiDate();

        assertEquals(corpusChristiDate, result);
    }

    @Test
    void calculateCorpusChristiDate2017() {
        LocalDate corpusChristiDate = LocalDate.of(2017,Month.JUNE, 15);

        LocalDate dateDue = LocalDate.of(2017, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.getCorpusChristiDate();

        assertEquals(corpusChristiDate, result);
    }

    @Test
    void calculateCorpusChristiDate2019() {
        LocalDate corpusChristiDate = LocalDate.of(2019,Month.JUNE, 20);

        LocalDate dateDue = LocalDate.of(2019, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.getCorpusChristiDate();

        assertEquals(corpusChristiDate, result);
    }

    @Test
    void calculateCorpusChristiDate2020() {
        LocalDate corpusChristiDate = LocalDate.of(2020,Month.JUNE, 11);

        LocalDate dateDue = LocalDate.of(2020, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.getCorpusChristiDate();

        assertEquals(corpusChristiDate, result);
    }

    @Test
    void calculateCorpusChristiDate2021() {
        LocalDate corpusChristiDate = LocalDate.of(2021,Month.JUNE, 3);

        LocalDate dateDue = LocalDate.of(2021, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.getCorpusChristiDate();

        assertEquals(corpusChristiDate, result);
    }

    @Test
    void calculateCorpusChristiDate2022() {
        LocalDate corpusChristiDate = LocalDate.of(2022,Month.JUNE, 16);

        LocalDate dateDue = LocalDate.of(2022, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2022, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.getCorpusChristiDate();

        assertEquals(corpusChristiDate, result);
    }

    @Test
    void calculateCorpusChristiDate2024() {
        LocalDate corpusChristiDate = LocalDate.of(2024,Month.MAY, 30);

        LocalDate dateDue = LocalDate.of(2024, Month.JANUARY, 1);
        LocalDate datePayment = LocalDate.of(2024, Month.JANUARY, 11);
        Due due = new Due(dateDue, BigDecimal.valueOf(500.0), false);
        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, datePayment);

        LocalDate result = subtractionCalculation.getCorpusChristiDate();

        assertEquals(corpusChristiDate, result);
    }



}