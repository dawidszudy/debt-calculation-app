package pl.pp.project;

import org.apache.log4j.Logger;
import pl.pp.project.model.Due;
import pl.pp.project.model.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class Calculation {

    private final static Logger log = Logger.getLogger(Calculation.class);
    private List<Payment> calculationListPayment;
    private List<Due> calculationListDues;
    private List<Due> listDuesBeforeCalculation = new ArrayList<>();
    private final BigDecimal interestPercentage = BigDecimal.valueOf(0.07);
    private final int NUMBER_DAYS_OF_YEAR = 365;
    private LocalDate finishDate;
    private BigDecimal sumDues = BigDecimal.valueOf(0);
    private boolean activeInterestHigherThanPayment = false;
    private BigDecimal interestHigherThanPayment = BigDecimal.valueOf(0);
    private BigDecimal interestOfDue;


    public Calculation() {
    }

    public Calculation(List<Payment> calculationPaymentList, List<Due> calculationListDues) {
        this.calculationListPayment = calculationPaymentList;
        this.calculationListDues = calculationListDues;
    }

    public void calculation() {

        InterestsPeriods interestsPeriodsList = new InterestsPeriods();
        addInterestsPeriod(interestsPeriodsList);

        for (Payment payment : calculationListPayment) {

            if ( !payment.getValueUnderZero() ) {
                log.info("Payment"); //point

                for (Due due : calculationListDues) {

                    if ( !due.getDueIsZero() ) {
                        log.info("Due"); //point
                        log.info("due value=" + due.getValue());
                        log.info("due Date: " + due.getDate());
                        log.info("payment Date: " + payment.getDate());

                        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, payment.getDate());
                        long daysSubtraction = subtractionCalculation.calculateDaysSubtraction();

                        log.info(subtractionCalculation.getNameOfDayOfWeekDue()); //point
                        log.info("subtractionDays=" + daysSubtraction); //point
                        log.info("dueGetValue=" + due.getValue()); //point

                        calculateInterest(due, daysSubtraction);

                        BigDecimal sumInterestAndDue = interestOfDue.add(due.getValue());
                        log.info("sumInterestAndDue=" + sumInterestAndDue); //point

                        log.info("valueOfPayment=" + payment.getValue()); //point
                        BigDecimal valueOfDueAfterSubtractThePayment = sumInterestAndDue.subtract(payment.getValue());
                        log.info("valueOfDueAfterSubtractThePayment=" + valueOfDueAfterSubtractThePayment);             //point

                        //warunek dla odsetki większe niż zapłata
                        if ( interestOfDue.compareTo(payment.getValue()) > 0 ) {
                            log.info("!!!!!!!!!! Exception");
                            interestHigherThanPayment = due.getInterestOfDue().subtract(payment.getValue());
                            activeInterestHigherThanPayment = true;
                            log.info("InterestHigherThanPayment= " + interestHigherThanPayment);

                            if ( valueOfDueAfterSubtractThePayment.compareTo(BigDecimal.ZERO) > 0 ) {
                                payment.setValue(BigDecimal.ZERO);
                                payment.setValueUnderZero(true);
                                //due.setValue(due.getValue());
                                due.setDate(payment.getDate());
                                log.info("break");
                                break;  //ify, niezalecane break //enter to next payment

                            }
//                            else if ( valueOfDueAfterSubtractThePayment.compareTo(BigDecimal.ZERO) <= 0 ) {   //never do this
//                                log.info("!!!! NEVER DO");
//                                due.setValue(BigDecimal.ZERO);
//                                due.setInterestOfDue(BigDecimal.ZERO);
//                                due.setDueIsZero(true);
//
//                                payment.setValue(valueOfDueAfterSubtractThePayment.multiply(BigDecimal.valueOf(-1)));
//
//                                log.info("payment.getValue()=" + payment.getValue());
//                                log.info("continue");
//                                //continue;  //enter to next due
//                            }

                            //warunek dla odsetki mniejsze bądz równe niż zapłata
                        } else if ( interestOfDue.compareTo(payment.getValue()) <= 0 ) {
                            log.info("!!!!!!!!!! NO Exception");
                            if ( valueOfDueAfterSubtractThePayment.compareTo(BigDecimal.ZERO) > 0 ) {
                                payment.setValue(BigDecimal.ZERO);
                                payment.setValueUnderZero(true);
                                due.setValue(valueOfDueAfterSubtractThePayment);
                                due.setDate(payment.getDate());/////////////
                                //enter to next payment
                                interestHigherThanPayment = BigDecimal.valueOf(0);
                                activeInterestHigherThanPayment = false;
                                log.info("break");
                                break;  //ify, niezalecane break

                            } else if ( valueOfDueAfterSubtractThePayment.compareTo(BigDecimal.ZERO) <= 0 ) {
                                //enter to next due
                                due.setValue(BigDecimal.ZERO);
                                due.setInterestOfDue(BigDecimal.ZERO);
                                due.setDueIsZero(true);
                                payment.setValue(valueOfDueAfterSubtractThePayment.multiply(BigDecimal.valueOf(-1)));

                                log.info("payment.getValue()=" + payment.getValue());
                                interestHigherThanPayment = BigDecimal.valueOf(0);
                                activeInterestHigherThanPayment = false;
                                log.info("continue");
                                //continue;
                            }
                        }
//                      log.info(numberOfDayOfMonthDue);
//                      log.info(monthNumberDue);
                    }
                }
            }

        }

        calculationResults();

    }

    void calculateInterest(Due due, long daysSubtraction) {
        if ( !activeInterestHigherThanPayment ) {    //liczenie odsetek następnych po wyjątku
            log.info("FALSE");
            interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(daysSubtraction)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP);
        } else { //liczenie odsetek zwykłe
            log.info("TRUE");
            interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(daysSubtraction)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP).add(interestHigherThanPayment);
        }
        due.setInterestOfDue(interestOfDue);
        log.info("interestOfDue= " + interestOfDue);
        log.info("interestOfDue=" + due.getInterestOfDue()); //point
    }

    private void calculationResults() {
        log.info("RESULT CALCULATION...");
        for (Due due : calculationListDues) {
            if ( !due.getDueIsZero() ) {

                SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, finishDate);
                log.info(subtractionCalculation.getNameOfDayOfWeekDue()); //point
                long daysSubtraction = subtractionCalculation.calculateDaysSubtraction();
                log.info("subtractionDays=" + daysSubtraction); //point
                log.info("dueGetValue=" + due.getValue()); //point

                BigDecimal interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(daysSubtraction)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP).add(interestHigherThanPayment);
                due.setInterestOfDue(interestOfDue);
                interestHigherThanPayment = BigDecimal.valueOf(0);

                log.info("interestOfDue=" + due.getInterestOfDue()); //point
                BigDecimal sumInterestAndDue = interestOfDue.add(due.getValue());
                log.info("sumInterestAndDue=" + sumInterestAndDue); //point
                sumDues = sumDues.add(due.getValue());
            }
        }
    }

    private void addInterestsPeriod(InterestsPeriods interestPeriodsList) {
        interestPeriodsList.add(LocalDate.of(1998, Month.APRIL, 16), LocalDate.of(1999, Month.JANUARY, 31), BigDecimal.valueOf(0.33));
        interestPeriodsList.add(LocalDate.of(1999, Month.FEBRUARY, 1), LocalDate.of(1999, Month.MAY, 14), BigDecimal.valueOf(0.24));
        interestPeriodsList.add(LocalDate.of(1999, Month.MAY, 15), LocalDate.of(2000, Month.OCTOBER, 31), BigDecimal.valueOf(0.21));
        interestPeriodsList.add(LocalDate.of(2000, Month.NOVEMBER, 1), LocalDate.of(2001, Month.DECEMBER, 14), BigDecimal.valueOf(0.30));
        interestPeriodsList.add(LocalDate.of(2001, Month.DECEMBER, 15), LocalDate.of(2002, Month.JULY, 24), BigDecimal.valueOf(0.20));
        interestPeriodsList.add(LocalDate.of(2002, Month.JULY, 25), LocalDate.of(2003, Month.JANUARY, 31), BigDecimal.valueOf(0.16));
        interestPeriodsList.add(LocalDate.of(2003, Month.FEBRUARY, 1), LocalDate.of(2003, Month.SEPTEMBER, 24), BigDecimal.valueOf(0.13));
        interestPeriodsList.add(LocalDate.of(2003, Month.SEPTEMBER, 25), LocalDate.of(2005, Month.JANUARY, 9), BigDecimal.valueOf(0.1225));
        interestPeriodsList.add(LocalDate.of(2005, Month.JANUARY, 10), LocalDate.of(2005, Month.OCTOBER, 14), BigDecimal.valueOf(0.135));
        interestPeriodsList.add(LocalDate.of(2005, Month.OCTOBER, 15), LocalDate.of(2008, Month.DECEMBER, 14), BigDecimal.valueOf(0.1150));
        interestPeriodsList.add(LocalDate.of(2008, Month.DECEMBER, 15), LocalDate.of(2014, Month.DECEMBER, 22), BigDecimal.valueOf(0.13));
        interestPeriodsList.add(LocalDate.of(2014, Month.DECEMBER, 23), LocalDate.of(2015, Month.DECEMBER, 31), BigDecimal.valueOf(0.08));
        interestPeriodsList.add(LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2020, Month.MARCH, 17), BigDecimal.valueOf(0.07));
        interestPeriodsList.add(LocalDate.of(2020, Month.MARCH, 18), LocalDate.of(2020, Month.APRIL, 8), BigDecimal.valueOf(0.065));
        interestPeriodsList.add(LocalDate.of(2020, Month.APRIL, 9), LocalDate.of(2020, Month.MAY, 28), BigDecimal.valueOf(0.06));
        interestPeriodsList.add(LocalDate.of(2020, Month.MAY, 29), LocalDate.of(2021, Month.OCTOBER, 6), BigDecimal.valueOf(0.056));
        interestPeriodsList.add(LocalDate.of(2021, Month.OCTOBER, 7), LocalDate.of(2021, Month.NOVEMBER, 3), BigDecimal.valueOf(0.06));
        interestPeriodsList.add(LocalDate.of(2021, Month.NOVEMBER, 4), LocalDate.of(2021, Month.DECEMBER, 8), BigDecimal.valueOf(0.0675));
        interestPeriodsList.add(LocalDate.of(2021, Month.DECEMBER, 9), LocalDate.of(2022, Month.JANUARY, 4), BigDecimal.valueOf(0.0725));
        interestPeriodsList.add(LocalDate.of(2022, Month.JANUARY, 5), LocalDate.of(2022, Month.FEBRUARY, 8), BigDecimal.valueOf(0.0775));
        interestPeriodsList.add(LocalDate.of(2022, Month.FEBRUARY, 9), LocalDate.of(2022, Month.MARCH, 8), BigDecimal.valueOf(0.0825));
        interestPeriodsList.add(LocalDate.of(2022, Month.MARCH, 9), LocalDate.of(2022, Month.MARCH, 14), BigDecimal.valueOf(0.09));
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
        return listDuesBeforeCalculation;
    }

    public void setListDuesBeforeCalculation(List<Due> listDuesBeforeCalculation) {
        this.listDuesBeforeCalculation = listDuesBeforeCalculation;
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
