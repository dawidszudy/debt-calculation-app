package pl.pp.project.service;

import pl.pp.project.model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    public List<Payment> listPayments = new ArrayList<>();

    public List<Payment> getListPayments() {
        return listPayments;
    }

    public void addPaymentToCalculation(Payment payment) {
        listPayments.add(payment);
    }

    @Override
    public String toString() {
        return "AllPayments{" +
                "listPayments=" + "\n" + listPayments +
                '}';
    }

}
