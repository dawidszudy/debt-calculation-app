package pl.pp.project;

import pl.pp.project.model.Due;
import pl.pp.project.model.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
//import static org.apache.commons.math3.util.Precision.round;


public class Calculation {
    private List<Payment> calculationListPayment;
    private List<Due> calculationListDues;
    private List<Due> ListDuesBeforeCalculation = new ArrayList<>();
    private final BigDecimal interestPercentage = BigDecimal.valueOf(0.07);
    private final int NUMBER_DAYS_OF_YEAR = 365;

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
//            String nameOfDayOfWeekPayment = String.valueOf(payment.getDate().getDayOfWeek());
//            int numberOfDayOfMonthPayment = payment.getDate().getDayOfMonth();
//            int monthNumberPayment = payment.getDate().getMonth().getValue();
//            int yearPayment = payment.getDate().getYear();

//            System.out.println(nameOfDayOfWeekPayment);
//            System.out.println(numberOfDayOfMonthPayment);
//            System.out.println(monthNumberPayment);
//            System.out.println(yearPayment);

                for (Due due : calculationListDues) {

                    if ( !due.getDueIsZero() ) {
                        System.out.println("Due"); //point
                        System.out.println("due value=" + due.getValue());

                        long subtractionDays = DAYS.between(due.getDate(), payment.getDate());
                        String nameOfDayOfWeekDue = String.valueOf(due.getDate().getDayOfWeek());
                        int numberOfDayOfMonthDue = due.getDate().getDayOfMonth();
                        int monthNumberDue = due.getDate().getMonth().getValue();

                        System.out.println(nameOfDayOfWeekDue); //point


                        if ( nameOfDayOfWeekDue.equals("SUNDAY") && monthNumberDue == 8 && numberOfDayOfMonthDue == 15-1 ) {
                            subtractionDays = subtractionDays - 2;
                        } else if ( nameOfDayOfWeekDue.equals("SUNDAY") ) {
                            subtractionDays = subtractionDays - 1;
                        }

                        System.out.println("subtractionDays=" + subtractionDays); //point

                        System.out.println("dueGetValue=" + due.getValue()); //point
                        //BigDecimal interestOfDue1 = round((due.getValue() * interestPercentage * subtractionDays) / numberDaysOfYear, 2);
                        BigDecimal interestOfDue = (due.getValue().multiply(interestPercentage.multiply(BigDecimal.valueOf(subtractionDays)))).divide(BigDecimal.valueOf(NUMBER_DAYS_OF_YEAR), 2, RoundingMode.HALF_UP);
                        due.setInterestOfDue(interestOfDue);

                        System.out.println("interestOfDue=" + due.getInterestOfDue()); //point

                        BigDecimal sumInterestAndDue = interestOfDue.add(due.getValue());
                        System.out.println("sumInterestAndDue=" + sumInterestAndDue); //point

                        System.out.println("valueOfPayment=" + payment.getValue()); //point
                        BigDecimal action = sumInterestAndDue.subtract(payment.getValue());
                        System.out.println("action=" + action);             //point

                        if ( action.compareTo(BigDecimal.ZERO) > 0 ) {

                            //przejść do następnego payment
                            payment.setValue(BigDecimal.ZERO);
                            payment.setValueUnderZero(true);
                            due.setValue(action);
                            break;  //ify, niezalecane break

                        } else if ( action.compareTo(BigDecimal.ZERO) <= 0 ) {

                            //przejść do następnego due
                            due.setValue(BigDecimal.ZERO);
                            due.setInterestOfDue(BigDecimal.ZERO);
                            due.setDueIsZero(true);

                            payment.setValue(action.multiply(BigDecimal.valueOf(-1)));

                            System.out.println("payment.getValue()=" + payment.getValue());
                            //continue;

                        }

//                      System.out.println(numberOfDayOfMonthDue);
//                      System.out.println(monthNumberDue);
                    }

                }
            }

        }
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

    @Override
    public String toString() {
        return "Calculation{" +
                "calculationPaymentList=" + calculationListPayment +
                ", calculationListDues=" + calculationListDues +
                '}';
    }
}
