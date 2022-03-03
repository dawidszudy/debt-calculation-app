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
        log.info("conditionAfterOrBefore: " + conditionAfterOrBeforeFirstJanuary2017);


        int numberMonthEaster = easterDate.getMonth().getValue();
        int numberDayEaster = easterDate.getDayOfMonth();

        int easterDatePlusOneDayNumberDay = easterDate.plusDays(1).getDayOfMonth();
        int easterDatePlusOneDayNumberMonth = easterDate.plusDays(1).getMonth().getValue();
        int easterDateMinusOneDayNumberDay = easterDate.minusDays(1).getDayOfMonth();
        int easterDateMinusOneDayNumberMonth = easterDate.minusDays(1).getMonth().getValue();

        int corpusChristiNumberDay = corpusChristiDate.getDayOfMonth();
        int corpusChristiNumberMonth = corpusChristiDate.getMonth().getValue();

        log.info("dueYear: " + dueDate.getYear());            //point
        log.info("easterDate: " + easterDate);                //point
        log.info("numberMonthEaster: " + numberMonthEaster + ", numberDayEaster: " + numberDayEaster); //point
        log.info("easterDatePlusOneDayNumberMonth: " + easterDatePlusOneDayNumberMonth +
                ", easterDatePlusOneDayNumberDay: " + easterDatePlusOneDayNumberDay);      //point
        log.info("easterDateMinusOneDayNumberMonth: " + easterDateMinusOneDayNumberMonth +
                ", easterDateMinusOneDayNumberDay: " + easterDateMinusOneDayNumberDay);    //point
        log.info("corpusChristiNumberMonth: " + corpusChristiNumberMonth +
                ", corpusChristiNumberDay: " + corpusChristiNumberDay);                  //point

        if ( conditionAfterOrBeforeFirstJanuary2017 >= 0 ) {

            log.info("AFTER: 01 01 2017");

            Conditions listConditionsAfter01012017 = new Conditions();

//            Condition condition1 = new Condition();
            Condition condition2 = new Condition(monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "1 styczeń w piątek");
            Condition condition3 = new Condition(monthNumberDue == 1 && numberOfDayOfMonthDue == 1, 1, "1 styczeń nowy rok");
            Condition condition4 = new Condition(monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "31 grudzień niedziela");
            Condition condition5 = new Condition(monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "31 grudzień sobota");
            Condition condition6 = new Condition(monthNumberDue == 12 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "30 grudzień sobota");
            Condition condition7 = new Condition(monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "6 styczeń trzech króli sobota");
            Condition condition8 = new Condition(monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("FRIDAY"), 3, "6 styczeń trzech króli piątek");
            Condition condition9 = new Condition(monthNumberDue == 1 && numberOfDayOfMonthDue == 6, 1, "6 styczeń trzech króli");
            Condition condition10 = new Condition(monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SUNDAY"), 2, "5 styczeń niedziela");
            Condition condition11 = new Condition(monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "5 styczeń sobota");
            Condition condition12 = new Condition(monthNumberDue == 1 && numberOfDayOfMonthDue == 4 && nameOfDayOfWeekDue.equals("SATURDAY"), 3, "4 styczeń sobota");
            Condition condition13 = new Condition(monthNumberDue == numberMonthEaster && numberOfDayOfMonthDue == numberDayEaster, 2, "niedziela wielkanocna");
            Condition condition14 = new Condition(monthNumberDue == easterDatePlusOneDayNumberMonth && numberOfDayOfMonthDue == easterDatePlusOneDayNumberDay, 1, "poniedziałek wielkanocny");
            Condition condition15 = new Condition(monthNumberDue == easterDateMinusOneDayNumberMonth && numberOfDayOfMonthDue == easterDateMinusOneDayNumberDay, 3, "sobota wielkanocna");

            listConditionsAfter01012017.add(monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"), 2, "1 styczeń sobota");
            listConditionsAfter01012017.add(condition2);
            listConditionsAfter01012017.add(condition3);
            listConditionsAfter01012017.add(condition4);
            listConditionsAfter01012017.add(condition5);
            listConditionsAfter01012017.add(condition6);
            listConditionsAfter01012017.add(condition7);
            listConditionsAfter01012017.add(condition8);
            listConditionsAfter01012017.add(condition9);
            listConditionsAfter01012017.add(condition10);
            listConditionsAfter01012017.add(condition11);
            listConditionsAfter01012017.add(condition12);
            listConditionsAfter01012017.add(condition13);
            listConditionsAfter01012017.add(condition14);
            listConditionsAfter01012017.add(condition15);

            for (int i = 0; i < listConditionsAfter01012017.getConditionsList().size(); i++) {
                if ( listConditionsAfter01012017.get(i).isCondition() ) {
                    daysSubtraction -= listConditionsAfter01012017.get(i).getSubtraction();
                    log.info(listConditionsAfter01012017.get(i).getInfoMessage());
                    break;
                }
            }

//            if ( condition1.isCondition() ) {
//                //1 styczeń w sobotę
//                //daysSubtraction = twoDaysSubtraction(daysSubtraction);
//                daysSubtraction -= condition.getSubtraction();
//                log.info();("1 styczeń w sobotę");
//            } else if ( condition2.isCondition() ) {
//                daysSubtraction = threeDaysSubtraction(daysSubtraction);
//                log.info();("1 styczeń w piątek");
//            } else if ( condition3.isCondition()) {
//                daysSubtraction = oneDaysSubtraction(daysSubtraction);
//                log.info();("1 styczeń nowy rok");
//            } else if ( condition4.isCondition() ) {
//                daysSubtraction = twoDaysSubtraction(daysSubtraction);
//                log.info();("31 grudzień niedziela");
//            } else if ( condition5.isCondition() ) {
//                daysSubtraction = twoDaysSubtraction(daysSubtraction);
//                log.info();("31 grudzień sobota");
//            } else if ( condition6.isCondition() ) {
//                daysSubtraction = threeDaysSubtraction(daysSubtraction);
//                log.info();("30 grudzień sobota");
//            } else if ( condition7.isCondition() ) {
//                daysSubtraction = twoDaysSubtraction(daysSubtraction);
//                log.info();("6 styczeń trzech króli sobota");
//            } else if ( condition8.isCondition() ) {
//                daysSubtraction = threeDaysSubtraction(daysSubtraction);
//                log.info();("6 styczeń trzech króli piątek");
//            } else if ( condition9.isCondition() ) {
//                daysSubtraction = oneDaysSubtraction(daysSubtraction);
//                log.info();("6 styczeń trzech króli");
//            } else if ( condition10.isCondition()) {
//                daysSubtraction = twoDaysSubtraction(daysSubtraction);
//                log.info();("5 styczeń niedziela");
//            } else if ( condition11.isCondition() ) {
//                daysSubtraction = twoDaysSubtraction(daysSubtraction);
//                log.info();("5 styczeń sobota");
//            } else if ( condition12.isCondition() ) {
//                daysSubtraction = threeDaysSubtraction(daysSubtraction);
//                log.info();("4 styczeń sobota");
//            } else if ( condition13.isCondition() ) {
//                daysSubtraction = twoDaysSubtraction(daysSubtraction);
//                log.info();("niedziela wielkanocna");
//            } else if ( condition14.isCondition() ) {
//                daysSubtraction = oneDaysSubtraction(daysSubtraction);
//                log.info();("poniedziałek wielkanocny");
//            } else if ( condition15.isCondition()) {
//                daysSubtraction = threeDaysSubtraction(daysSubtraction);
//                log.info();("sobota wielkanocna");
            /*} else*/
            if ( monthNumberDue == corpusChristiNumberMonth && numberOfDayOfMonthDue == corpusChristiNumberDay ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("boże ciało");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("1 maj sobota");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("1 maj piątek");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("1 maj");
            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("30 kwiecień niedziela");
            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("30 kwiecień sobota");
            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 29 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("29 kwiecień sobota");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("3 maj w sobotę");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("3 maj w piątek");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("3 maj");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("2 maj niedziela");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("2 maj sobota");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("15 sierpień WP sobota");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("15 sierpień WP piątek");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("15 sierpień WP");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("14 sierpień niedziela");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("14 sierpień sobota");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 13 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("13 sierpień sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("1 listopad sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("1 listopad piątek");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("1 listopad");
            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("31 październik niedziala");
            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("31 październik sobota");
            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("30 październik sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("11 listopad sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("11 listopad piątek");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("11 listopad");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("10 listopada niedziela");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("10 listopada sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 9 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("9 listopada sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("25 grudzień sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("25 grudzień piątek");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("THURSDAY") ) {
                daysSubtraction = fourDaysSubtraction(daysSubtraction);
                log.info("25 grudzień czwartek");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("25 grudzień");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("26 grudzień sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("26 grudzień piątek");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("26 grudzień");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("24 grudzień niedziela");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("24 grudzień sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 23 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = fourDaysSubtraction(daysSubtraction);
                log.info("23 grudzień sobota");
            } else if ( nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("ogólny warunek sobota");
            } else if ( nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("ogólny warunek niedziela");
            }

        } else { //if conditionAfterOrBeforeFirstJanuary2017 < 0

            log.info("BEFORE: 01 01 2017");

            if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("1 styczeń w sobotę");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("1 styczeń nowy rok");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("31 grudzień niedziela");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("6 styczeń trzech króli sobota");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("6 styczeń trzech króli");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("5 styczeń niedziela");
            } else if ( monthNumberDue == numberMonthEaster && numberOfDayOfMonthDue == numberDayEaster ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("niedziela wielkanocna");
            } else if ( monthNumberDue == easterDatePlusOneDayNumberMonth && numberOfDayOfMonthDue == easterDatePlusOneDayNumberDay ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("poniedziałek wielkanocny");
            } else if ( monthNumberDue == corpusChristiNumberMonth && numberOfDayOfMonthDue == corpusChristiNumberDay ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("boże ciało");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("1 maj sobota");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("1 maj");
            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("30 kwiecień niedziela");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("3 maj sobota");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("3 maj");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("2 maj niedziela");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("15 sierpień WP sobota");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("15 sierpień WP");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("14 sierpień niedziela");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("1 listopad sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("1 listopad");
            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("31 październik niedziela");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("11 listopad sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("11 listopad");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("10 listopad niedziela");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("25 grudzień sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("25 grudzień piątek");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("25 grudzień");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                log.info("26 grudzień sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("26 grudzień");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                log.info("24 grudzień niedziela");
            } else if ( nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                log.info("ogólny warunek niedziela");
            }
        }
        return daysSubtraction;
    }

    public LocalDate getCorpusChristiDate() {
        return easterDate.plusDays(60);
    }

    public LocalDate calculateEasterDate(int year) {
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

    public long oneDaysSubtraction(long daysSubtraction) {
        return SubtractionCalculation.this.daysSubtraction - 1;
    }

    public long twoDaysSubtraction(long daysSubtraction) {
        return SubtractionCalculation.this.daysSubtraction - 2;
    }

    public long threeDaysSubtraction(long daysSubtraction) {
        return SubtractionCalculation.this.daysSubtraction - 3;
    }

    public long fourDaysSubtraction(long daysSubtraction) {
        return SubtractionCalculation.this.daysSubtraction - 4;
    }
}
