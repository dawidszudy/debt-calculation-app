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
        listConditionsBefore01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "6 stycze?? trzech kr??li sobota");
        listConditionsBefore01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 6, 1, "6 stycze?? trzech kr??li");
        listConditionsBefore01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "5 stycze?? niedziela");
        addConditionsForBefore01012017And01012011(listConditionsBefore01012017);
    }

    private void addConditionsForBefore01012011(Conditions listConditionsBefore01012011) {
        addConditionsForBefore01012017And01012011(listConditionsBefore01012011);
    }

    private void addConditionsForBefore01012017And01012011(Conditions listConditionsBefore01012017) {
        listConditionsBefore01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "1 stycze?? w sobot??");
        listConditionsBefore01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 1, 1, "1 stycze?? nowy rok");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "31 grudzie?? niedziela");
        listConditionsBefore01012017.add(monthNumberDue == numberMonthEaster && numberOfDayOfMonthDue == numberDayEaster, 2, "niedziela wielkanocna");
        listConditionsBefore01012017.add(monthNumberDue == easterDatePlusOneDayNumberMonth && numberOfDayOfMonthDue == easterDatePlusOneDayNumberDay, 1, "poniedzia??ek wielkanocny");
        listConditionsBefore01012017.add(monthNumberDue == corpusChristiNumberMonth && numberOfDayOfMonthDue == corpusChristiNumberDay, 1, "bo??e cia??o");
        listConditionsBefore01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "1 maj sobota");
        listConditionsBefore01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 1, 1, "1 maj");
        listConditionsBefore01012017.add(monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "30 kwiecie?? niedziela");
        listConditionsBefore01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "3 maj sobota");
        listConditionsBefore01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 3, 1, "3 maj");
        listConditionsBefore01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "2 maj niedziela");
        listConditionsBefore01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "15 sierpie?? WP sobota");
        listConditionsBefore01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 15, 1, "15 sierpie?? WP");
        listConditionsBefore01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "14 sierpie?? niedziela");
        listConditionsBefore01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "1 listopad sobota");
        listConditionsBefore01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 1, 1, "1 listopad");
        listConditionsBefore01012017.add(monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "31 pa??dziernik niedziela");
        listConditionsBefore01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "11 listopad sobota");
        listConditionsBefore01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 11, 1, "11 listopad");
        listConditionsBefore01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "10 listopad niedziela");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "25 grudzie?? sobota");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "25 grudzie?? pi??tek");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25, 2, "25 grudzie??");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "26 grudzie?? sobota");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 26, 1, "26 grudzie??");
        listConditionsBefore01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SUNDAY"), 3, "24 grudzie?? niedziela");
        listConditionsBefore01012017.add(nameOfDayOfWeekDue.equals("SUNDAY"), 1, "og??lny warunek niedziela");
    }

    private void addConditionsForAfter01012017(Conditions listConditionsAfter01012017) {
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "1 stycze?? sobota");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "1 stycze?? w pi??tek");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 1, 1, "1 stycze?? nowy rok");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "31 grudzie?? niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "31 grudzie?? sobota");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "30 grudzie?? sobota");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "6 stycze?? trzech kr??li sobota");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "6 stycze?? trzech kr??li pi??tek");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 6, 1, "6 stycze?? trzech kr??li");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "5 stycze?? niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "5 stycze?? sobota");
        listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 4 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "4 stycze?? sobota");
        listConditionsAfter01012017.add(monthNumberDue == numberMonthEaster && numberOfDayOfMonthDue == numberDayEaster, 2, "niedziela wielkanocna");
        listConditionsAfter01012017.add(monthNumberDue == easterDatePlusOneDayNumberMonth && numberOfDayOfMonthDue == easterDatePlusOneDayNumberDay, 1, "poniedzia??ek wielkanocny");
        listConditionsAfter01012017.add(monthNumberDue == easterDateMinusOneDayNumberMonth && numberOfDayOfMonthDue == easterDateMinusOneDayNumberDay, 3, "sobota wielkanocna");
        listConditionsAfter01012017.add(monthNumberDue == corpusChristiNumberMonth && numberOfDayOfMonthDue == corpusChristiNumberDay, 1, "bo??e cia??o");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "1 maj sobota");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "1 maj pi??tek");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 1, 1, "1 maj");
        listConditionsAfter01012017.add(monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "30 kwiecie?? niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "30 kwiecie?? sobota");
        listConditionsAfter01012017.add(monthNumberDue == 4 && numberOfDayOfMonthDue == 29 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "29 kwiecie?? sobota");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "3 maj w sobot??");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "3 maj w pi??tek");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 3, 1, "3 maj");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "2 maj niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "2 maj sobota");
        listConditionsAfter01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "15 sierpie?? WP sobota");
        listConditionsAfter01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "15 sierpie?? WP pi??tek");
        listConditionsAfter01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 15, 1, "15 sierpie?? WP");
        listConditionsAfter01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "14 sierpie?? niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "14 sierpie?? sobota");
        listConditionsAfter01012017.add(monthNumberDue == 8 && numberOfDayOfMonthDue == 13 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "13 sierpie?? sobota");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "1 listopad sobota");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "1 listopad pi??tek");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 1, 1, "1 listopad");
        listConditionsAfter01012017.add(monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "31 pa??dziernik niedziala");
        listConditionsAfter01012017.add(monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "31 pa??dziernik sobota");
        listConditionsAfter01012017.add(monthNumberDue == 10 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "30 pa??dziernik sobota");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "11 listopad sobota");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "11 listopad pi??tek");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 11, 1, "11 listopad");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "10 listopada niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "10 listopada sobota");
        listConditionsAfter01012017.add(monthNumberDue == 11 && numberOfDayOfMonthDue == 9 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "9 listopada sobota");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "25 grudzie?? sobota");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "25 grudzie?? pi??tek");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("THURSDAY"), 4, "25 grudzie?? czwartek");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 25, 2, "25 grudzie??");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "26 grudzie?? sobota");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "26 grudzie?? pi??tek");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 26, 1, "26 grudzie??");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SUNDAY"), 3, "24 grudzie?? niedziela");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "24 grudzie?? sobota");
        listConditionsAfter01012017.add(monthNumberDue == 12 && numberOfDayOfMonthDue == 23 && nameOfDayOfWeekDue.equals("SATURDAY"), 4, "23 grudzie?? sobota");
        listConditionsAfter01012017.add(nameOfDayOfWeekDue.equals("SATURDAY"), 2, "og??lny warunek sobota");
        listConditionsAfter01012017.add(nameOfDayOfWeekDue.equals("SUNDAY"), 1, "og??lny warunek niedziela");
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
