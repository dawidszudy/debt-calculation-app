package pl.pp.project.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment extends Quantum {

    private Boolean valueUnderZero;

    public Payment() {
    }

    public Payment(LocalDate date, BigDecimal value, Boolean valueUnderZero) {
        this.date = date;
        this.value = value;
        this.valueUnderZero = valueUnderZero;
    }

    public Boolean getValueUnderZero() {
        return valueUnderZero;
    }

    public void setValueUnderZero(Boolean valueUnderZero) {
        this.valueUnderZero = valueUnderZero;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "valueUnderZero=" + valueUnderZero +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
