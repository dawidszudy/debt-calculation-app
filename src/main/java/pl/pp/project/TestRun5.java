package pl.pp.project;

import pl.pp.project.model.Due;
import pl.pp.project.model.Payment;
import pl.pp.project.service.DueService;
import pl.pp.project.service.PaymentService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class TestRun5 {
    public static void main(String[] args) {

        LocalDate dateDue1 = LocalDate.of(2012, Month.JANUARY, 6);
        LocalDate datePayment1 = LocalDate.of(2012, Month.JANUARY, 16);

        Due due1 = new Due(dateDue1, BigDecimal.valueOf(500.0), false);
        Payment payment1 = new Payment(datePayment1, BigDecimal.valueOf(50.0), false);

        DueService dueService = new DueService();
        PaymentService paymentsService = new PaymentService();

        dueService.addDueToCalculation(due1);
        paymentsService.addPaymentToCalculation(payment1);

        Calculation calculation = new Calculation(paymentsService.getListPayments(), dueService.getListDues());
        calculation.setFinishDate(LocalDate.of(2018, Month.DECEMBER, 31));
        calculation.calculation();

        System.out.println();
        System.out.println(calculation);
        System.out.println();
        System.out.println(dueService);
        System.out.println();
        System.out.println(paymentsService);
    }

}
