package pl.pp.project;

import pl.pp.project.model.Due;
import pl.pp.project.model.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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


    public Calculation() {
    }

    public Calculation(List<Payment> calculationPaymentList, List<Due> calculationListDues) {
        this.calculationListPayment = calculationPaymentList;
        this.calculationListDues = calculationListDues;
    }

    public void calculation() {

        for (Payment payment : calculationListPayment) {

            if ( !payment.getValueUnderZero() ) {
                System.out.println("Payment"); //point

                for (Due due : calculationListDues) {

                    if ( !due.getDueIsZero() ) {
                        System.out.println("Due"); //point
                        System.out.println("due value=" + due.getValue());
                        System.out.println("due Date: " + due.getDate());
                        System.out.println("payment Date: " + payment.getDate());

                        SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, payment.getDate());
                        long daysSubtraction = subtractionCalculation.calculateDaysSubtraction();

                        System.out.println(subtractionCalculation.getNameOfDayOfWeekDue()); //point
                        System.out.println("subtractionDays=" + daysSubtraction); //point
                        System.out.println("dueGetValue=" + due.getValue()); //point

                        //liczenie odsetek następnych po wyjątku
                        if ( !ActiveInterestHigherThanPayment ) {
                            System.out.println("TRUE");
                            interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(daysSubtraction)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP);
                            due.setInterestOfDue(interestOfDue);
                        } else if ( ActiveInterestHigherThanPayment ) {
                            System.out.println("FALSE");
                            interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(daysSubtraction)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP).add(InterestHigherThanPayment);
                            due.setInterestOfDue(interestOfDue);
                            System.out.println("!!!!!!!!!!!!= " + interestOfDue);
                        }

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
                                //enter to next payment
                                System.out.println("break");
                                System.out.println();
                                break;  //ify, niezalecane break

                            } else if ( action.compareTo(BigDecimal.ZERO) <= 0 ) {
                                System.out.println("!!!! NEVER DO");
                                //enter to next due
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
                                //enter to next payment
                                System.out.println("break");
                                System.out.println();
                                InterestHigherThanPayment = BigDecimal.valueOf(0);
                                ActiveInterestHigherThanPayment = false;
                                break;  //ify, niezalecane break

                            } else if ( action.compareTo(BigDecimal.ZERO) <= 0 ) {

                                //enter to next due
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

                SubtractionCalculation subtractionCalculation = new SubtractionCalculation(due, finishDate);

                System.out.println(subtractionCalculation.getNameOfDayOfWeekDue()); //point

                long daysSubtraction = subtractionCalculation.calculateDaysSubtraction();
                System.out.println("subtractionDays=" + daysSubtraction); //point
                System.out.println("dueGetValue=" + due.getValue()); //point

                BigDecimal interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(daysSubtraction)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP).add(InterestHigherThanPayment);
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
