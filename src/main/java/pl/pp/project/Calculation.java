package pl.pp.project;

import org.apache.log4j.Logger;
import pl.pp.project.model.Due;
import pl.pp.project.model.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Calculation {

    private final static Logger log = Logger.getLogger(Calculation.class);
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


    public Calculation() {
    }

    public Calculation(List<Payment> calculationPaymentList, List<Due> calculationListDues) {
        this.calculationListPayment = calculationPaymentList;
        this.calculationListDues = calculationListDues;
    }

    public void calculation() {

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

                        //liczenie odsetek następnych po wyjątku
                        if ( !ActiveInterestHigherThanPayment ) {
                            log.info("TRUE");
                            interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(daysSubtraction)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP);
                            due.setInterestOfDue(interestOfDue);
                        } else if ( ActiveInterestHigherThanPayment ) {
                            log.info("FALSE");
                            interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(daysSubtraction)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP).add(InterestHigherThanPayment);
                            due.setInterestOfDue(interestOfDue);
                            log.info("!!!!!!!!!!!!= " + interestOfDue);
                        }

                        log.info("interestOfDue=" + due.getInterestOfDue()); //point
                        BigDecimal sumInterestAndDue = interestOfDue.add(due.getValue());
                        log.info("sumInterestAndDue=" + sumInterestAndDue); //point
                        log.info("valueOfPayment=" + payment.getValue()); //point
                        BigDecimal valueOfDueAfterSubtractThePayment = sumInterestAndDue.subtract(payment.getValue());
                        log.info("valueOfDueAfterSubtractThePayment=" + valueOfDueAfterSubtractThePayment);             //point

                        //warunek dla odsetki większe niż zapłata
                        if ( interestOfDue.compareTo(payment.getValue()) > 0 ) {
                            log.info("!!!!!!!!!! Exception");
                            InterestHigherThanPayment = due.getInterestOfDue().subtract(payment.getValue());
                            ActiveInterestHigherThanPayment = true;
                            log.info("InterestHigherThanPayment= " + InterestHigherThanPayment);

                            if ( valueOfDueAfterSubtractThePayment.compareTo(BigDecimal.ZERO) > 0 ) {
                                payment.setValue(BigDecimal.ZERO);
                                payment.setValueUnderZero(true);
                                //due.setValue(due.getValue());
                                due.setDate(payment.getDate());
                                log.info("break");
                                break;  //ify, niezalecane break //enter to next payment

                            } else if ( valueOfDueAfterSubtractThePayment.compareTo(BigDecimal.ZERO) <= 0 ) {
                                log.info("!!!! NEVER DO");
                                due.setValue(BigDecimal.ZERO);
                                due.setInterestOfDue(BigDecimal.ZERO);
                                due.setDueIsZero(true);

                                payment.setValue(valueOfDueAfterSubtractThePayment.multiply(BigDecimal.valueOf(-1)));

                                log.info("payment.getValue()=" + payment.getValue());
                                log.info("continue");
                                //continue;  //enter to next due
                            }

                            //warunek dla odsetki mniejsze bądz równe niż zapłata
                        } else if ( interestOfDue.compareTo(payment.getValue()) <= 0 ) {
                            log.info("!!!!!!!!!! NO Exception");
                            if ( valueOfDueAfterSubtractThePayment.compareTo(BigDecimal.ZERO) > 0 ) {
                                payment.setValue(BigDecimal.ZERO);
                                payment.setValueUnderZero(true);
                                due.setValue(valueOfDueAfterSubtractThePayment);
                                due.setDate(payment.getDate());/////////////
                                //enter to next payment
                                InterestHigherThanPayment = BigDecimal.valueOf(0);
                                ActiveInterestHigherThanPayment = false;
                                log.info("break");
                                break;  //ify, niezalecane break

                            } else if ( valueOfDueAfterSubtractThePayment.compareTo(BigDecimal.ZERO) <= 0 ) {
                                //enter to next due
                                due.setValue(BigDecimal.ZERO);
                                due.setInterestOfDue(BigDecimal.ZERO);
                                due.setDueIsZero(true);
                                payment.setValue(valueOfDueAfterSubtractThePayment.multiply(BigDecimal.valueOf(-1)));

                                log.info("payment.getValue()=" + payment.getValue());
                                InterestHigherThanPayment = BigDecimal.valueOf(0);
                                ActiveInterestHigherThanPayment = false;
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

    private void calculationResults() {
        log.info("RESULT CALCULATION...");
        for (Due due : calculationListDues) {
            if ( !due.getDueIsZero() ) {

                SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, finishDate);
                log.info(subtractionCalculation.getNameOfDayOfWeekDue()); //point
                long daysSubtraction = subtractionCalculation.calculateDaysSubtraction();
                log.info("subtractionDays=" + daysSubtraction); //point
                log.info("dueGetValue=" + due.getValue()); //point

                BigDecimal interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(daysSubtraction)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP).add(InterestHigherThanPayment);
                due.setInterestOfDue(interestOfDue);
                InterestHigherThanPayment = BigDecimal.valueOf(0);

                log.info("interestOfDue=" + due.getInterestOfDue()); //point
                BigDecimal sumInterestAndDue = interestOfDue.add(due.getValue());
                log.info("sumInterestAndDue=" + sumInterestAndDue); //point
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
