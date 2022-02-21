package pl.pp.project;

import pl.pp.project.model.Due;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class SubtractionCalculation {

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
        System.out.println("conditionAfterOrBefore: " + conditionAfterOrBeforeFirstJanuary2017);


        int numberMonthEaster = easterDate.getMonth().getValue();
        int numberDayEaster = easterDate.getDayOfMonth();

        int easterDatePlusOneDayNumberDay = easterDate.plusDays(1).getDayOfMonth();
        int easterDatePlusOneDayNumberMonth = easterDate.plusDays(1).getMonth().getValue();
        int easterDateMinusOneDayNumberDay = easterDate.minusDays(1).getDayOfMonth();
        int easterDateMinusOneDayNumberMonth = easterDate.minusDays(1).getMonth().getValue();

        int corpusChristiNumberDay = corpusChristiDate.getDayOfMonth();
        int corpusChristiNumberMonth = corpusChristiDate.getMonth().getValue();

        System.out.println("dueYear: " + dueDate.getYear());            //point
        System.out.println("easterDate: " + easterDate);                //point
        System.out.println("numberMonthEaster: " + numberMonthEaster + ", numberDayEaster: " + numberDayEaster); //point
        System.out.println("easterDatePlusOneDayNumberMonth: " + easterDatePlusOneDayNumberMonth +
                ", easterDatePlusOneDayNumberDay: " + easterDatePlusOneDayNumberDay);      //point
        System.out.println("easterDateMinusOneDayNumberMonth: " + easterDateMinusOneDayNumberMonth +
                ", easterDateMinusOneDayNumberDay: " + easterDateMinusOneDayNumberDay);    //point
        System.out.println("corpusChristiNumberMonth: " + corpusChristiNumberMonth +
                ", corpusChristiNumberDay: " + corpusChristiNumberDay);                  //point

        if ( conditionAfterOrBeforeFirstJanuary2017 >= 0 ) {

            System.out.println("AFTER: 01 01 2017");

            List<Condition> listConditions = new ArrayList<>();
            Condition condition = new Condition(monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY"),
                    2, "1 styczeń sobota");

            listConditions.add(condition);

            for (int i = 0; i < listConditions.size(); i++) {
                if ( listConditions.get(i).isCondition() ) {
                    daysSubtraction -= listConditions.get(i).getSubtraction();
                    System.out.println(listConditions.get(i).getInfoMessage());
                    break;
                }
            }

            if ( condition.isCondition() ) {
//                //1 styczeń w sobotę
//                //daysSubtraction = twoDaysSubtraction(daysSubtraction);
//                daysSubtraction -= condition.getSubtraction();
//                System.out.println("1 styczeń w sobotę");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("1 styczeń w piątek");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("1 styczeń nowy rok");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("31 grudzień niedziela");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("31 grudzień sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("30 grudzień sobota");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("6 styczeń trzech króli sobota");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("6 styczeń trzech króli piątek");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("6 styczeń trzech króli");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("5 styczeń niedziela");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("5 styczeń sobota");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 4 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("4 styczeń sobota");
            } else if ( monthNumberDue == numberMonthEaster && numberOfDayOfMonthDue == numberDayEaster ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("niedziela wielkanocna");
            } else if ( monthNumberDue == easterDatePlusOneDayNumberMonth && numberOfDayOfMonthDue == easterDatePlusOneDayNumberDay ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("poniedziałek wielkanocny");
            } else if ( monthNumberDue == easterDateMinusOneDayNumberMonth && numberOfDayOfMonthDue == easterDateMinusOneDayNumberDay ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("sobota wielkanocna");
            } else if ( monthNumberDue == corpusChristiNumberMonth && numberOfDayOfMonthDue == corpusChristiNumberDay ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("boże ciało");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("1 maj sobota");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("1 maj piątek");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("1 maj");
            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("30 kwiecień niedziela");
            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("30 kwiecień sobota");
            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 29 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("29 kwiecień sobota");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("3 maj w sobotę");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("3 maj w piątek");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("3 maj");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("2 maj niedziela");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("2 maj sobota");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("15 sierpień WP sobota");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("15 sierpień WP piątek");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("15 sierpień WP");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("14 sierpień niedziela");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("14 sierpień sobota");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 13 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("13 sierpień sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("1 listopad sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("1 listopad piątek");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("1 listopad");
            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("31 październik niedziala");
            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("31 październik sobota");
            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("30 październik sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("11 listopad sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("11 listopad piątek");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("11 listopad");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("10 listopada niedziela");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("10 listopada sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 9 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("9 listopada sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień piątek");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("THURSDAY") ) {
                daysSubtraction = fourDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień czwartek");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("26 grudzień sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("26 grudzień piątek");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("26 grudzień");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("24 grudzień niedziela");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("24 grudzień sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 23 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = fourDaysSubtraction(daysSubtraction);
                System.out.println("23 grudzień sobota");
            } else if ( nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("ogólny warunek sobota");
            } else if ( nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("ogólny warunek niedziela");
            }

        } else { //if conditionAfterOrBeforeFirstJanuary2017 < 0

            System.out.println("BEFORE: 01 01 2017");

            if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("1 styczeń w sobotę");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("1 styczeń nowy rok");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("31 grudzień niedziela");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("6 styczeń trzech króli sobota");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("6 styczeń trzech króli");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("5 styczeń niedziela");
            } else if ( monthNumberDue == numberMonthEaster && numberOfDayOfMonthDue == numberDayEaster ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("niedziela wielkanocna");
            } else if ( monthNumberDue == easterDatePlusOneDayNumberMonth && numberOfDayOfMonthDue == easterDatePlusOneDayNumberDay ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("poniedziałek wielkanocny");
            } else if ( monthNumberDue == corpusChristiNumberMonth && numberOfDayOfMonthDue == corpusChristiNumberDay ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("boże ciało");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("1 maj sobota");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("1 maj");
            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("30 kwiecień niedziela");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("3 maj sobota");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("3 maj");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("2 maj niedziela");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("15 sierpień WP sobota");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("15 sierpień WP");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("14 sierpień niedziela");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("1 listopad sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("1 listopad");
            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("31 październik niedziela");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("11 listopad sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("11 listopad");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("10 listopad niedziela");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień piątek");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("26 grudzień sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("26 grudzień");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("24 grudzień niedziela");
            } else if ( nameOfDayOfWeekDue.equals("SUNDAY") ) {
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("ogólny warunek niedziela");
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
