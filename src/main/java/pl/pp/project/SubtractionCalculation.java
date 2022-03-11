package pl.pp.project;


import org.apache.log4j.Logger;
import pl.pp.project.model.Due;

import java.time.LocalDate;
import java.time.Month;

import static java.time.temporal.ChronoUnit.DAYS;

public class SubtractionCalculation {

    private final static Logger log = Logger.getLogger(SubtractionCalculation.class);
    private long daysSubtraction;
    private String nameOfDayOfWeekDue;
    private int numberOfDayOfMonthDue;
    private int monthNumberDue;
    private LocalDate dueDate;
    private LocalDate easterDate;
    private LocalDate corpusChristiDate;
    private final LocalDate changeOfSaturdayLikeAsHoliday = LocalDate.of(2017, Month.JANUARY, 1);
    private final LocalDate changeOfSixJanuaryHoliday = LocalDate.of(2011, Month.JANUARY, 1);

    private int numberMonthEaster;
    private int numberDayEaster;
    private int easterDatePlusOneDayNumberDay;
    private int easterDatePlusOneDayNumberMonth;
    private int easterDateMinusOneDayNumberDay;
    private int easterDateMinusOneDayNumberMonth;
    private int corpusChristiNumberDay;
    private int corpusChristiNumberMonth;

    public String getNameOfDayOfWeekDue() {
        return nameOfDayOfWeekDue;
    }

    public SubtractionCalculation(Due due, LocalDate paymentDate) {
        daysSubtraction = DAYS.between(due.getDate(), paymentDate);
        nameOfDayOfWeekDue = String.valueOf(due.getDate().getDayOfWeek());
        numberOfDayOfMonthDue = due.getDate().getDayOfMonth();
        monthNumberDue = due.getDate().getMonth().getValue();
        dueDate = due.getDate();
        easterDate = calculateEasterDate(dueDate.getYear());
        corpusChristiDate = getCorpusChristiDate();
    }


    public long calculateDaysSubtraction() {

        long conditionAfterOrBeforeFirstJanuary2017 = DAYS.between(changeOfSaturdayLikeAsHoliday, dueDate);
        long conditionAfterOrBeforeFirstJanuary2011 = DAYS.between(changeOfSixJanuaryHoliday, dueDate);
        log.info("conditionAfterOrBefore: " + conditionAfterOrBeforeFirstJanuary2017);

        initializeValueOfMovableHolidays();
        movableHolidaysLogInfo();

        if ( conditionAfterOrBeforeFirstJanuary2017 >= 0 ) {
            log.info("AFTER: 01 01 2017");
            Conditions listConditionsAfter01012017 = new Conditions();
            addConditionsForAfter01012017(listConditionsAfter01012017);
            modifiedNumberDays(listConditionsAfter01012017);

        } else if ( conditionAfterOrBeforeFirstJanuary2011 < 0 ) {
            log.info("BEFORE: 01 01 2011");
            Conditions listConditionsBefore01012011 = new Conditions();
            addConditionsForBefore01012011(listConditionsBefore01012011);
            modifiedNumberDays(listConditionsBefore01012011);

        } else { //if conditionAfterOrBeforeFirstJanuary2017 < 0
            log.info("BEFORE: 01 01 2017");
            Conditions listConditionsBefore01012017 = new Conditions();
            addConditionsForBefore01012017(listConditionsBefore01012017);
            modifiedNumberDays(listConditionsBefore01012017);

        }
        return daysSubtraction;
    }

    private void initializeValueOfMovableHolidays() {
        numberMonthEaster = easterDate.getMonth().getValue();
        numberDayEaster = easterDate.getDayOfMonth();
        easterDatePlusOneDayNumberDay = easterDate.plusDays(1).getDayOfMonth();
        easterDatePlusOneDayNumberMonth = easterDate.plusDays(1).getMonth().getValue();
        easterDateMinusOneDayNumberDay = easterDate.minusDays(1).getDayOfMonth();
        easterDateMinusOneDayNumberMonth = easterDate.minusDays(1).getMonth().getValue();
        corpusChristiNumberDay = corpusChristiDate.getDayOfMonth();
        corpusChristiNumberMonth = corpusChristiDate.getMonth().getValue();
    }

    private void movableHolidaysLogInfo() {
        log.info("dueYear: " + dueDate.getYear());            //point
        log.info("easterDate: " + easterDate);                //point
        log.info("numberMonthEaster: " + numberMonthEaster + ", numberDayEaster: " + numberDayEaster); //point
        log.info("easterDatePlusOneDayNumberMonth: " + easterDatePlusOneDayNumberMonth +
                ", easterDatePlusOneDayNumberDay: " + easterDatePlusOneDayNumberDay);      //point
        log.info("easterDateMinusOneDayNumberMonth: " + easterDateMinusOneDayNumberMonth +
                ", easterDateMinusOneDayNumberDay: " + easterDateMinusOneDayNumberDay);    //point
        log.info("corpusChristiNumberMonth: " + corpusChristiNumberMonth +
                ", corpusChristiNumberDay: " + corpusChristiNumberDay);                  //point
    }

    private void addConditionsForBefore01012017(Conditions listConditionsBefore01012017) {
        listConditionsBefore01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "6 styczeń trzech króli sobota");
        listConditionsBefore01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 6, 1, "6 styczeń trzech króli");
        listConditionsBefore01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "5 styczeń niedziela");
        addConditionsForBefore01012017And01012011(listConditionsBefore01012017);
    }

    private void addConditionsForBefore01012011(Conditions listConditionsBefore01012011) {
        addConditionsForBefore01012017And01012011(listConditionsBefore01012011);
    }

    private void addConditionsForBefore01012017And01012011(Conditions listConditionsBefore01012017) {
        listConditionsBefore01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "1 styczeń w sobotę");
        listConditionsBefore01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 1, 1, "1 styczeń nowy rok");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "31 grudzień niedziela");
        listConditionsBefore01012017.add(monthNumberDue == numberMonthEaster && numberOfDayOfMonthDue == numberDayEaster, 2, "niedziela wielkanocna");
        listConditionsBefore01012017.add(monthNumberDue == easterDatePlusOneDayNumberMonth && numberOfDayOfMonthDue == easterDatePlusOneDayNumberDay, 1, "poniedziałek wielkanocny");
        listConditionsBefore01012017.add(monthNumberDue == corpusChristiNumberMonth && numberOfDayOfMonthDue == corpusChristiNumberDay, 1, "boże ciało");
        listConditionsBefore01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "1 maj sobota");
        listConditionsBefore01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 1, 1, "1 maj");
        listConditionsBefore01012017.add(monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "30 kwiecień niedziela");
        listConditionsBefore01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "3 maj sobota");
        listConditionsBefore01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 3, 1, "3 maj");
        listConditionsBefore01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "2 maj niedziela");
        listConditionsBefore01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "15 sierpień WP sobota");
        listConditionsBefore01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 15, 1, "15 sierpień WP");
        listConditionsBefore01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "14 sierpień niedziela");
        listConditionsBefore01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "1 listopad sobota");
        listConditionsBefore01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 1, 1, "1 listopad");
        listConditionsBefore01012017.add(monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "31 październik niedziela");
        listConditionsBefore01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "11 listopad sobota");
        listConditionsBefore01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 11, 1, "11 listopad");
        listConditionsBefore01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "10 listopad niedziela");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "25 grudzień sobota");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "25 grudzień piątek");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25, 2, "25 grudzień");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "26 grudzień sobota");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 26, 1, "26 grudzień");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SUNDAY"), 3, "24 grudzień niedziela");
        listConditionsBefore01012017.add(nameOfDayOfWeekDue.equals("SUNDAY"), 1, "ogólny warunek niedziela");
    }

    private void addConditionsForAfter01012017(Conditions listConditionsAfter01012017) {
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "1 styczeń sobota");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "1 styczeń w piątek");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 1, 1, "1 styczeń nowy rok");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "31 grudzień niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "31 grudzień sobota");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "30 grudzień sobota");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "6 styczeń trzech króli sobota");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "6 styczeń trzech króli piątek");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 6, 1, "6 styczeń trzech króli");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "5 styczeń niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "5 styczeń sobota");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 4 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "4 styczeń sobota");
        listConditionsAfter01012017.add(monthNumberDue == numberMonthEaster && numberOfDayOfMonthDue == numberDayEaster, 2, "niedziela wielkanocna");
        listConditionsAfter01012017.add(monthNumberDue == easterDatePlusOneDayNumberMonth && numberOfDayOfMonthDue == easterDatePlusOneDayNumberDay, 1, "poniedziałek wielkanocny");
        listConditionsAfter01012017.add(monthNumberDue == easterDateMinusOneDayNumberMonth && numberOfDayOfMonthDue == easterDateMinusOneDayNumberDay, 3, "sobota wielkanocna");
        listConditionsAfter01012017.add(monthNumberDue == corpusChristiNumberMonth && numberOfDayOfMonthDue == corpusChristiNumberDay, 1, "boże ciało");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "1 maj sobota");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "1 maj piątek");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 1, 1, "1 maj");
        listConditionsAfter01012017.add(monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "30 kwiecień niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "30 kwiecień sobota");
        listConditionsAfter01012017.add(monthNumberDue == 4 && numberOfDayOfMonthDue == 29 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "29 kwiecień sobota");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "3 maj w sobotę");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "3 maj w piątek");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 3, 1, "3 maj");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "2 maj niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "2 maj sobota");
        listConditionsAfter01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "15 sierpień WP sobota");
        listConditionsAfter01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "15 sierpień WP piątek");
        listConditionsAfter01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 15, 1, "15 sierpień WP");
        listConditionsAfter01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "14 sierpień niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "14 sierpień sobota");
        listConditionsAfter01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 13 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "13 sierpień sobota");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "1 listopad sobota");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "1 listopad piątek");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 1, 1, "1 listopad");
        listConditionsAfter01012017.add(monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "31 październik niedziala");
        listConditionsAfter01012017.add(monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "31 październik sobota");
        listConditionsAfter01012017.add(monthNumberDue == 10 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "30 październik sobota");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "11 listopad sobota");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "11 listopad piątek");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 11, 1, "11 listopad");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "10 listopada niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "10 listopada sobota");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 9 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "9 listopada sobota");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "25 grudzień sobota");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "25 grudzień piątek");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("THURSDAY"), 4, "25 grudzień czwartek");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25, 2, "25 grudzień");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "26 grudzień sobota");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "26 grudzień piątek");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 26, 1, "26 grudzień");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SUNDAY"), 3, "24 grudzień niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "24 grudzień sobota");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 23 && nameOfDayOfWeekDue.equals("SATURDAY"), 4, "23 grudzień sobota");
        listConditionsAfter01012017.add(nameOfDayOfWeekDue.equals("SATURDAY"), 2, "ogólny warunek sobota");
        listConditionsAfter01012017.add(nameOfDayOfWeekDue.equals("SUNDAY"), 1, "ogólny warunek niedziela");
    }

    private void modifiedNumberDays(Conditions listConditionsAfter01012017) {
        for (int i = 0; i < listConditionsAfter01012017.getConditionsList().size(); i++) {
            if ( listConditionsAfter01012017.get(i).isCondition() ) {
                daysSubtraction -= listConditionsAfter01012017.get(i).getSubtraction();
                log.info(listConditionsAfter01012017.get(i).getInfoMessage());
                break;
            }
        }
    }

    public LocalDate getCorpusChristiDate() {
        return easterDate.plusDays(60);
    }

    LocalDate calculateEasterDate(int year) {
        int a = year % 19,
                b = year / 100,
                c = year % 100,
                d = b / 4,
                e = b % 4,
                g = (8 * b + 13) / 25,
                h = (19 * a + b - d - g + 15) % 30,
                j = c / 4,
                k = c % 4,
                m = (a + 11 * h) / 319,
                r = (2 * e + 2 * j - k - h + m + 32) % 7,
                month = (h - m + r + 90) / 25,
                day = (h - m + r + month + 19) % 32;

        return LocalDate.of(year, month, day);
    }

}
