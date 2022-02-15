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
    }


    public long calculateDaysSubtraction() {

        long conditionAfterOrBeforeFirstJanuary2017 = DAYS.between(changeOfSaturdayLikeAsHoliday, dueDate);
        System.out.println("conditionAfterOrBefore: " + conditionAfterOrBeforeFirstJanuary2017);

        int dueYear = dueDate.getYear();             //point
        System.out.println("dueYear: " + dueYear);    //point
        easterDate = calculateEasterDate(dueYear);
        System.out.println("easterDay: " + easterDate);  //point

        int numberMonthEaster = easterDate.getMonth().getValue();
        int numberDayEaster = easterDate.getDayOfMonth();
        System.out.println("numberMonthEaster: " + numberMonthEaster); //point
        System.out.println("numberDayEaster: " + numberDayEaster);     //point


        if ( conditionAfterOrBeforeFirstJanuary2017 >= 0 ) {

            System.out.println("AFTER: 01 01 2017");

//            condition easter day without 2002, 2013, 2024 - 31 march
//            if ( monthNumberDue == numberMonthEaster && numberOfDayOfMonthDue == numberDayEaster ) {
//                daysSubtraction = twoDaysSubtraction(daysSubtraction);
//                System.out.println("niedziela wielkanocna");
//            } else if ( monthNumberDue == numberMonthEaster && numberOfDayOfMonthDue == numberDayEaster + 1 ) {
//                daysSubtraction = oneDaysSubtraction(daysSubtraction);
//                System.out.println("poniedziałek wielkanocny");
//            } else if ( monthNumberDue == numberMonthEaster && numberOfDayOfMonthDue == numberDayEaster - 1 ) {
//                daysSubtraction = threeDaysSubtraction(daysSubtraction);
//                System.out.println("sobota wielkanocna");
//            }

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
                //1 styczeń w piątek
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("1 styczeń w piątek");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 ) {
                //1 styczeń nowy rok
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("1 styczeń nowy rok");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //31 grudzień niedziela
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("31 grudzień niedziela");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //31 grudzień sobota
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("31 grudzień sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //30 grudzień sobota
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("30 grudzień sobota");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //6 styczeń trzech króli w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("6 styczeń trzech króli w sobotę");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                //6 styczeń trzech króli w piątek
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("6 styczeń trzech króli w piątek");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 ) {
                //6 styczeń trzech króli
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("6 styczeń trzech króli");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //5 styczeń niedziela
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("5 styczeń niedziela");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //5 styczeń sobota
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("5 styczeń sobota");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 4 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //4 styczeń sobota
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("4 styczeń sobota");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //1 maj sobota
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("1 maj sobota");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                //1 maj piątek
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("1 maj piątek");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 ) {
                //1 maj
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("1 maj");
            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //30 kwiecień niedziela
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("30 kwiecień niedziela");
            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //30 kwiecień sobota
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("30 kwiecień sobota");
            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 29 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //29 kwiecień sobota
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("29 kwiecień sobota");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //3 maj w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("3 maj w sobotę");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                //3 maj w piątek
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("3 maj w piątek");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 ) {
                //3 maj
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("3 maj");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //2 maj niedziela
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("2 maj niedziela");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //2 maj sobota
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("2 maj sobota");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //15 sierpień WP w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("15 sierpień WP w sobotę");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                //15 sierpień WP w piątek
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("15 sierpień WP w piątek");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 ) {
                //15 sierpień WP
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("15 sierpień WP");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //14 sierpień niedziela
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("14 sierpień niedziela");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //14 sierpień sobota
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("14 sierpień sobota");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 13 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //13 sierpień sobota
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("13 sierpień sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //1 listopad w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("1 listopad w sobotę");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                //1 listopad w piątek
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("1 listopad w piątek");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 ) {
                //1 listopad
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("1 listopad");
            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //31 październik niedziala
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("31 październik niedziala");
            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //31 październik sobota
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("31 październik sobota");
            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //30 październik sobota
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("30 październik sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //11 listopad w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("11 listopad w sobotę");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                //11 listopad w piątek
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("11 listopad w piątek");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 ) {
                //11 listopad
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("11 listopad");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //10 listopada niedziela
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("10 listopada niedziela");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //10 listopada sobota
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("10 listopada sobota");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 9 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //9 listopada sobota
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("9 listopada sobota");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //25 grudzień w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień w sobotę");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                //25 grudzień w piątek
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień w piątek");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("THURSDAY") ) {
                //25 grudzień w czwartek
                daysSubtraction = fourDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień w czwartek");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 ) {
                //25 grudzień
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //26 grudzień w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("26 grudzień w sobotę");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                //26 grudzień w piątek
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("26 grudzień w piątek");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 ) {
                //26 grudzień
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("26 grudzień");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //24 grudzień w niedzielę
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("24 grudzień w niedzielę");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //24 grudzień w sobotę
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("24 grudzień w sobotę");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 23 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //23 grudzień w sobotę
                daysSubtraction = fourDaysSubtraction(daysSubtraction);
                System.out.println("23 grudzień w sobotę");
            } else if ( nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //ogólny warunek na sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("ogólny warunek na sobotę");
            } else if ( nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //ogólny warunek na niedzielę
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("ogólny warunek na niedzielę");
            }

        } else { //if conditionAfterOrBeforeFirstJanuary2017 < 0

            System.out.println("BEFORE: 01 01 2017");

            if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //1 styczeń w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("1 styczeń w sobotę");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 ) {
                //1 styczeń nowy rok
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("1 styczeń nowy rok");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //31 grudzień niedziela
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("31 grudzień niedziela");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //6 styczeń trzech króli w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("6 styczeń trzech króli w sobotę");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 ) {
                //6 styczeń trzech króli
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("6 styczeń trzech króli");
            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //5 styczeń niedziela
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("5 styczeń niedziela");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //1 maj sobota
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("1 maj sobota");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 ) {
                //1 maj
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("1 maj");
            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //30 kwiecień niedziela
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("2 maj niedziela");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //3 maj w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("3 maj w sobotę");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 ) {
                //3 maj
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("3 maj");
            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //2 maj niedziela
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("2 maj niedziela");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //15 sierpień WP w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("15 sierpień WP w sobotę");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 ) {
                //15 sierpień WP
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("15 sierpień WP");
            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //14 sierpień niedziela
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("14 sierpień niedziela");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //1 listopad w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("1 listopad w sobotę");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 ) {
                //1 listopad
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("1 listopad");
            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //31 październik niedziela
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("31 październik niedziela");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //11 listopad w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("11 listopad w sobotę");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 ) {
                //11 listopad
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("11 listopad");
            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //10 listopad niedziela
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("10 listopad niedziela");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //25 grudzień w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień w sobotę");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                //25 grudzień w piątek
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień w sobotę");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 25 ) {
                //25 grudzień
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("25 grudzień");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                //26 grudzień w sobotę
                daysSubtraction = twoDaysSubtraction(daysSubtraction);
                System.out.println("26 grudzień w sobotę");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 26 ) {
                //26 grudzień
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("26 grudzień");
            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 24 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //24 grudzień w niedzielę
                daysSubtraction = threeDaysSubtraction(daysSubtraction);
                System.out.println("24 grudzień w niedzielę");
            } else if ( nameOfDayOfWeekDue.equals("SUNDAY") ) {
                //ogólny warunek na niedzielę
                daysSubtraction = oneDaysSubtraction(daysSubtraction);
                System.out.println("ogólny warunek na niedzielę");
            }
        }
        return daysSubtraction;
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
