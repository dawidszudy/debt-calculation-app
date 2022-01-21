package pl.pp.project;

import pl.pp.project.model.Due;
import pl.pp.project.model.Payment;
import pl.pp.project.service.DueService;
import pl.pp.project.service.PaymentService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class Run {
    public static void main(String[] args) {

        LocalDate dateDue1 = LocalDate.of(2016, Month.AUGUST, 10);
        LocalDate dateDue2 = LocalDate.of(2016, Month.SEPTEMBER, 10);
        LocalDate dateDue3 = LocalDate.of(2016, Month.OCTOBER, 10);
        LocalDate datePayment1 = LocalDate.of(2017, Month.OCTOBER, 19);
        LocalDate datePayment2 = LocalDate.of(2017, Month.OCTOBER, 25);
        LocalDate datePayment3 = LocalDate.of(2017, Month.OCTOBER, 27);

        Due due1 = new Due(dateDue1, BigDecimal.valueOf(500.0), false);
        Due due2 = new Due(dateDue2, BigDecimal.valueOf(500.0), false);
        Due due3 = new Due(dateDue3, BigDecimal.valueOf(500.0), false);
        Payment payment1 = new Payment(datePayment1, BigDecimal.valueOf(560.0), false);
        Payment payment2 = new Payment(datePayment2, BigDecimal.valueOf(350.0), false);
        Payment payment3 = new Payment(datePayment3, BigDecimal.valueOf(200.0), false);

        DueService dueService = new DueService();
        PaymentService paymentsService = new PaymentService();

        dueService.addDueToCalculation(due1);
        dueService.addDueToCalculation(due2);
        dueService.addDueToCalculation(due3);
        paymentsService.addPaymentToCalculation(payment1);
        paymentsService.addPaymentToCalculation(payment2);
        paymentsService.addPaymentToCalculation(payment3);

        Calculation calculation = new Calculation(paymentsService.getListPayments(), dueService.getListDues());
        calculation.calculation();

        System.out.println();
        System.out.println(calculation);
        System.out.println();
        System.out.println(dueService);
        System.out.println();
        System.out.println(paymentsService);
    }

}
