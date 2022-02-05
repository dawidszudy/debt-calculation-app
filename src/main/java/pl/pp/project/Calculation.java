package pl.pp.project;

import pl.pp.project.model.Due;
import pl.pp.project.model.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;


public class Calculation {
    private List<Payment> calculationListPayment;
    private List<Due> calculationListDues;
    private List<Due> ListDuesBeforeCalculation = new ArrayList<>();
    private final BigDecimal interestPercentage = BigDecimal.valueOf(0.07);
    private final int NUMBER_DAYS_OF_YEAR = 365;
    protected LocalDate finishDate;
    protected BigDecimal sumDues = BigDecimal.valueOf(0);
    protected boolean ActiveInterestHigherThanPayment = false;
    protected BigDecimal InterestHigherThanPayment = BigDecimal.valueOf(0);
    private BigDecimal interestOfDue;
    private final LocalDate changeOfSaturdayLikeAsHoliday = LocalDate.of(2017, Month.JANUARY, 1);

    public Calculation() {
    }

    public Calculation(List<Payment> calculationPaymentList, List<Due> calculationListDues) {
        this.calculationListPayment = calculationPaymentList;
        this.calculationListDues = calculationListDues;
    }

    public void calculation() {

        for (Payment payment : calculationListPayment) {

            if ( !payment.getValueUnderZero() ) {
                //BigDecimal valueOfPayment = round(payment.getValue(), 2);
                System.out.println("Payment"); //point

                for (Due due : calculationListDues) {

                    if ( !due.getDueIsZero() ) {
                        System.out.println("Due"); //point
                        System.out.println("due value=" + due.getValue());

                        System.out.println("due Date: " + due.getDate());
                        System.out.println("payment Date: " + payment.getDate());

                        long subtractionDays = DAYS.between(due.getDate(), payment.getDate());
                        String nameOfDayOfWeekDue = String.valueOf(due.getDate().getDayOfWeek());
                        int numberOfDayOfMonthDue = due.getDate().getDayOfMonth();
                        int monthNumberDue = due.getDate().getMonth().getValue();

                        System.out.println(nameOfDayOfWeekDue); //point

                        long conditionAfterOrBeforeFirstJanuary2017 = DAYS.between(changeOfSaturdayLikeAsHoliday, due.getDate());
                        System.out.println("conditionAfterOrBefore: " + conditionAfterOrBeforeFirstJanuary2017);

                        if ( conditionAfterOrBeforeFirstJanuary2017 >= 0 ) {

                            System.out.println("AFTER: 01 01 2017");

                            if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //1 styczeń w sobotę
                                subtractionDays = subtractionDays - 2;
                                System.out.println("1 styczeń w sobotę");
                            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                                //1 styczeń w piątek
                                subtractionDays = subtractionDays - 3;
                                System.out.println("1 styczeń w piątek");
                            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 ) {
                                //1 styczeń nowy rok
                                subtractionDays = subtractionDays - 1;
                                System.out.println("1 styczeń nowy rok");
                            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //31 grudzień niedziela
                                subtractionDays = subtractionDays - 2;
                                System.out.println("31 grudzień niedziela");
                            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //31 grudzień sobota
                                subtractionDays = subtractionDays - 2;
                                System.out.println("31 grudzień sobota");
                            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //30 grudzień sobota
                                subtractionDays = subtractionDays - 3;
                                System.out.println("30 grudzień sobota");
                            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //6 styczeń trzech króli w sobotę
                                subtractionDays = subtractionDays - 2;
                                System.out.println("6 styczeń trzech króli w sobotę");
                            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                                //6 styczeń trzech króli w piątek
                                subtractionDays = subtractionDays - 3;
                                System.out.println("6 styczeń trzech króli w piątek");
                            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 ) {
                                //6 styczeń trzech króli
                                subtractionDays = subtractionDays - 1;
                                System.out.println("6 styczeń trzech króli");
                            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //5 styczeń niedziela
                                subtractionDays = subtractionDays - 2;
                                System.out.println("31 grudzień niedziela");
                            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //5 styczeń sobota
                                subtractionDays = subtractionDays - 2;
                                System.out.println("31 grudzień sobota");
                            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 4 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //4 styczeń sobota
                                subtractionDays = subtractionDays - 3;
                                System.out.println("30 grudzień sobota");
                            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //15 sierpień WP w sobotę
                                subtractionDays = subtractionDays - 2;
                                System.out.println("15 sierpień WP w sobotę");
                            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                                //15 sierpień WP w piątek
                                subtractionDays = subtractionDays - 3;
                                System.out.println("15 sierpień WP w piątek");
                            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 ) {
                                //15 sierpień WP
                                subtractionDays = subtractionDays - 1;
                                System.out.println("15 sierpień WP");
                            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //14 sierpień niedziela
                                subtractionDays = subtractionDays - 2;
                                System.out.println("14 sierpień niedziela");
                            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //14 sierpień sobota
                                subtractionDays = subtractionDays - 2;
                                System.out.println("14 sierpień sobota");
                            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 13 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //13 sierpień sobota
                                subtractionDays = subtractionDays - 3;
                                System.out.println("13 sierpień sobota");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //1 listopad w sobotę
                                subtractionDays = subtractionDays - 2;
                                System.out.println("1 listopad w sobotę");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                                //1 listopad w piątek
                                subtractionDays = subtractionDays - 3;
                                System.out.println("1 listopad w piątek");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 ) {
                                //1 listopad
                                subtractionDays = subtractionDays - 1;
                                System.out.println("1 listopad");
                            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //31 październik niedziala
                                subtractionDays = subtractionDays - 2;
                                System.out.println("31 październik niedziala");
                            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //31 październik sobota
                                subtractionDays = subtractionDays - 2;
                                System.out.println("31 październik sobota");
                            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //30 październik sobota
                                subtractionDays = subtractionDays - 3;
                                System.out.println("30 październik sobota");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //11 listopad w sobotę
                                subtractionDays = subtractionDays - 2;
                                System.out.println("11 listopad w sobotę");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                                //11 listopad w piątek
                                subtractionDays = subtractionDays - 3;
                                System.out.println("11 listopad w piątek");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 ) {
                                //11 listopad
                                subtractionDays = subtractionDays - 1;
                                System.out.println("11 listopad");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //10 listopada niedziela
                                subtractionDays = subtractionDays - 2;
                                System.out.println("10 listopada niedziela");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //10 listopada sobota
                                subtractionDays = subtractionDays - 2;
                                System.out.println("10 listopada sobota");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 9 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //9 listopada sobota
                                subtractionDays = subtractionDays - 3;
                                System.out.println("9 listopada sobota");
                            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //1 maj sobota
                                subtractionDays = subtractionDays - 3;
                                System.out.println("1 maj sobota");
                            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                                //1 maj piątek
                                subtractionDays = subtractionDays - 3;
                                System.out.println("1 maj piątek");
                            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 ) {
                                //1 maj
                                subtractionDays = subtractionDays - 1;
                                System.out.println("1 maj");
                            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //30 kwiecień niedziela
                                subtractionDays = subtractionDays - 2;
                                System.out.println("30 kwiecień niedziela");
                            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //30 kwiecień sobota
                                subtractionDays = subtractionDays - 2;
                                System.out.println("30 kwiecień sobota");
                            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 29 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //29 kwiecień sobota
                                subtractionDays = subtractionDays - 3;
                                System.out.println("29 kwiecień sobota");
                            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //3 maj w sobotę
                                subtractionDays = subtractionDays - 2;
                                System.out.println("3 maj w sobotę");
                            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("FRIDAY") ) {
                                //3 maj w piątek
                                subtractionDays = subtractionDays - 3;
                                System.out.println("3 maj w piątek");
                            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 ) {
                                //3 maj
                                subtractionDays = subtractionDays - 1;
                                System.out.println("3 maj");
                            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //2 maj niedziela
                                subtractionDays = subtractionDays - 2;
                                System.out.println("2 maj niedziela");
                            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //2 maj sobota
                                subtractionDays = subtractionDays - 2;
                                System.out.println("2 maj sobota");
                            } else if ( nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //ogólny warunek na sobotę
                                subtractionDays = subtractionDays - 2;
                                System.out.println("ogólny warunek na sobotę");
                            } else if ( nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //ogólny warunek na niedzielę
                                subtractionDays = subtractionDays - 1;
                                System.out.println("ogólny warunek na niedzielę");
                            }

                        } else { //if conditionAfterOrBeforeFirstJanuary2017 < 0

                            System.out.println("BEFORE: 01 01 2017");

                            if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //1 styczeń w sobotę
                                subtractionDays = subtractionDays - 2;
                                System.out.println("1 styczeń w sobotę");
                            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 1 ) {
                                //1 styczeń nowy rok
                                subtractionDays = subtractionDays - 1;
                                System.out.println("1 styczeń nowy rok");
                            } else if ( monthNumberDue == 12 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //31 grudzień niedziela
                                subtractionDays = subtractionDays - 2;
                                System.out.println("31 grudzień niedziela");
                            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //6 styczeń trzech króli w sobotę
                                subtractionDays = subtractionDays - 2;
                                System.out.println("6 styczeń trzech króli w sobotę");
                            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 6 ) {
                                //6 styczeń trzech króli
                                subtractionDays = subtractionDays - 1;
                                System.out.println("6 styczeń trzech króli");
                            } else if ( monthNumberDue == 1 && numberOfDayOfMonthDue == 5 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //5 styczeń niedziela
                                subtractionDays = subtractionDays - 2;
                                System.out.println("5 styczeń niedziela");
                            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //15 sierpień WP w sobotę
                                subtractionDays = subtractionDays - 2;
                                System.out.println("15 sierpień WP w sobotę");
                            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 15 ) {
                                //15 sierpień WP
                                subtractionDays = subtractionDays - 1;
                                System.out.println("15 sierpień WP");
                            } else if ( monthNumberDue == 8 && numberOfDayOfMonthDue == 14 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //14 sierpień niedziela
                                subtractionDays = subtractionDays - 2;
                                System.out.println("14 sierpień niedziela");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //1 listopad w sobotę
                                subtractionDays = subtractionDays - 2;
                                System.out.println("1 listopad w sobotę");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 1 ) {
                                //1 listopad
                                subtractionDays = subtractionDays - 1;
                                System.out.println("1 listopad");
                            } else if ( monthNumberDue == 10 && numberOfDayOfMonthDue == 31 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //31 październik niedziela
                                subtractionDays = subtractionDays - 2;
                                System.out.println("31 październik niedziela");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //11 listopad w sobotę
                                subtractionDays = subtractionDays - 2;
                                System.out.println("11 listopad w sobotę");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 11 ) {
                                //11 listopad
                                subtractionDays = subtractionDays - 1;
                                System.out.println("11 listopad");
                            } else if ( monthNumberDue == 11 && numberOfDayOfMonthDue == 10 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //10 listopad niedziela
                                subtractionDays = subtractionDays - 2;
                                System.out.println("10 listopad niedziela");
                            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //1 maj sobota
                                subtractionDays = subtractionDays - 3;
                                System.out.println("1 maj sobota");
                            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 1 ) {
                                //1 maj
                                subtractionDays = subtractionDays - 1;
                                System.out.println("1 maj");
                            } else if ( monthNumberDue == 4 && numberOfDayOfMonthDue == 30 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //30 kwiecień niedziela
                                subtractionDays = subtractionDays - 2;
                                System.out.println("2 maj niedziela");
                            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 && nameOfDayOfWeekDue.equals("SATURDAY") ) {
                                //3 maj w sobotę
                                subtractionDays = subtractionDays - 2;
                                System.out.println("3 maj w sobotę");
                            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 3 ) {
                                //3 maj
                                subtractionDays = subtractionDays - 1;
                                System.out.println("3 maj");
                            } else if ( monthNumberDue == 5 && numberOfDayOfMonthDue == 2 && nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //2 maj niedziela
                                subtractionDays = subtractionDays - 2;
                                System.out.println("2 maj niedziela");
                            } else if ( nameOfDayOfWeekDue.equals("SUNDAY") ) {
                                //ogólny warunek na niedzielę
                                subtractionDays = subtractionDays - 1;
                                System.out.println("ogólny warunek na niedzielę");
                            }
                        }


                        System.out.println("subtractionDays=" + subtractionDays); //point

                        System.out.println("dueGetValue=" + due.getValue()); //point
                        //BigDecimal interestOfDue1 = round((due.getValue() * interestPercentage * subtractionDays) / numberDaysOfYear, 2);

                        //liczenie odsetek następnych po wyjątku
                        if ( !ActiveInterestHigherThanPayment ) {
                            System.out.println("TRUE");
                            interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(subtractionDays)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP);
                            due.setInterestOfDue(interestOfDue);
                        } else if ( ActiveInterestHigherThanPayment ) {
                            System.out.println("FALSE");
                            interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(subtractionDays)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP).add(InterestHigherThanPayment);
                            due.setInterestOfDue(interestOfDue);
                            System.out.println("!!!!!!!!!!!!= " + interestOfDue);
                        }

//                        BigDecimal interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(subtractionDays)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP);
//                        due.setInterestOfDue(interestOfDue);

                        System.out.println("interestOfDue=" + due.getInterestOfDue()); //point

                        BigDecimal sumInterestAndDue = interestOfDue.add(due.getValue());
                        System.out.println("sumInterestAndDue=" + sumInterestAndDue); //point

                        System.out.println("valueOfPayment=" + payment.getValue()); //point
                        BigDecimal action = sumInterestAndDue.subtract(payment.getValue());
                        System.out.println("action=" + action);             //point

                        //warunek dla odsetki większe niż zapłata
                        if ( interestOfDue.compareTo(payment.getValue()) > 0 ) {
                            System.out.println("!!!!!!!!!! Exception");

                            InterestHigherThanPayment = due.getInterestOfDue().subtract(payment.getValue());
                            ActiveInterestHigherThanPayment = true;
                            System.out.println("InterestHigherThanPayment= " + InterestHigherThanPayment);

                            if ( action.compareTo(BigDecimal.ZERO) > 0 ) {

                                payment.setValue(BigDecimal.ZERO);
                                payment.setValueUnderZero(true);
                                //due.setValue(due.getValue());
                                due.setDate(payment.getDate());/////////////
                                //przejść do następnego payment
                                System.out.println("break");
                                System.out.println();
                                break;  //ify, niezalecane break

                            } else if ( action.compareTo(BigDecimal.ZERO) <= 0 ) {
                                System.out.println("!!!! NEVER DO");
                                //przejść do następnego due
                                due.setValue(BigDecimal.ZERO);
                                due.setInterestOfDue(BigDecimal.ZERO);
                                due.setDueIsZero(true);

                                payment.setValue(action.multiply(BigDecimal.valueOf(-1)));

                                System.out.println("payment.getValue()=" + payment.getValue());
                                System.out.println("continue");
                                System.out.println();
                                //continue;

                            }

                            //warunek dla odsetki mniejsze bądz równe niż zapłata
                        } else if ( interestOfDue.compareTo(payment.getValue()) <= 0 ) {
                            System.out.println("!!!!!!!!!! NO Exception");
                            if ( action.compareTo(BigDecimal.ZERO) > 0 ) {

                                payment.setValue(BigDecimal.ZERO);
                                payment.setValueUnderZero(true);
                                due.setValue(action);
                                due.setDate(payment.getDate());/////////////
                                //przejść do następnego payment
                                System.out.println("break");
                                System.out.println();
                                InterestHigherThanPayment = BigDecimal.valueOf(0);
                                ActiveInterestHigherThanPayment = false;
                                break;  //ify, niezalecane break

                            } else if ( action.compareTo(BigDecimal.ZERO) <= 0 ) {

                                //przejść do następnego due
                                due.setValue(BigDecimal.ZERO);
                                due.setInterestOfDue(BigDecimal.ZERO);
                                due.setDueIsZero(true);

                                payment.setValue(action.multiply(BigDecimal.valueOf(-1)));

                                System.out.println("payment.getValue()=" + payment.getValue());
                                System.out.println("continue");
                                System.out.println();
                                InterestHigherThanPayment = BigDecimal.valueOf(0);
                                ActiveInterestHigherThanPayment = false;
                                //continue;

                            }

                        }

//                      System.out.println(numberOfDayOfMonthDue);
//                      System.out.println(monthNumberDue);
                    }

                }
            }

        }

        System.out.println("RESULT CALCULATION...");

        for (Due due : calculationListDues) {
            if ( !due.getDueIsZero() ) {
                long subtractionDays = DAYS.between(due.getDate(), finishDate);
                String nameOfDayOfWeekDue = String.valueOf(due.getDate().getDayOfWeek());
                int numberOfDayOfMonthDue = due.getDate().getDayOfMonth();
                int monthNumberDue = due.getDate().getMonth().getValue();

                System.out.println(nameOfDayOfWeekDue); //point

                //warunki dla poprawek na dni świątecznych
                if ( nameOfDayOfWeekDue.equals("SUNDAY") && monthNumberDue == 8 && numberOfDayOfMonthDue == 15 - 1 ) {
                    subtractionDays = subtractionDays - 2;
                } else if ( nameOfDayOfWeekDue.equals("SUNDAY") ) {
                    subtractionDays = subtractionDays - 1;
                }

                System.out.println("subtractionDays=" + subtractionDays); //point

                System.out.println("dueGetValue=" + due.getValue()); //point
                //BigDecimal interestOfDue1 = round((due.getValue() * interestPercentage * subtractionDays) / numberDaysOfYear, 2);
                BigDecimal interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(subtractionDays)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP).add(InterestHigherThanPayment);
                due.setInterestOfDue(interestOfDue);
                InterestHigherThanPayment = BigDecimal.valueOf(0);

                System.out.println("interestOfDue=" + due.getInterestOfDue()); //point

                BigDecimal sumInterestAndDue = interestOfDue.add(due.getValue());
                System.out.println("sumInterestAndDue=" + sumInterestAndDue); //point
                sumDues = sumDues.add(due.getValue());
            }
        }


    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public List<Payment> getCalculationListPayment() {
        return calculationListPayment;
    }

    public void setCalculationListPayment(List<Payment> calculationListPayment) {
        this.calculationListPayment = calculationListPayment;
    }

    public List<Due> getCalculationListDues() {
        return calculationListDues;
    }

    public void setCalculationListDues(List<Due> calculationListDues) {
        this.calculationListDues = calculationListDues;
    }

    public List<Due> getListDuesBeforeCalculation() {
        return ListDuesBeforeCalculation;
    }

    public void setListDuesBeforeCalculation(List<Due> listDuesBeforeCalculation) {
        ListDuesBeforeCalculation = listDuesBeforeCalculation;
    }

    public BigDecimal sumDues() {
        return sumDues;
    }

    public void setValue(BigDecimal sumDues) {
        this.sumDues = sumDues;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "calculationPaymentList=" + calculationListPayment + "\n" +
                "calculationListDues=" + calculationListDues +
                "sumDues=" + sumDues +
                '}';
    }
}
