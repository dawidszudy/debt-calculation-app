package pl.pp.project.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Due extends Quantum {

    private Boolean dueIsZero;
    private BigDecimal interestOfDue;

    public Due() {
    }

    public Due(LocalDate date, BigDecimal value, Boolean dueIsZero) {
        this.date = date;
        this.value = value;
        this.dueIsZero = dueIsZero;
    }

    public BigDecimal getInterestOfDue() {
        return interestOfDue;
    }

    public void setInterestOfDue(BigDecimal interestOfDue) {
        this.interestOfDue = interestOfDue;
    }

    public Boolean getDueIsZero() {
        return dueIsZero;
    }

    public void setDueIsZero(Boolean dueIsZero) {
        this.dueIsZero = dueIsZero;
    }

    @Override
    public String toString() {
        return "Due{" +
                "dueIsZero=" + dueIsZero +
                ", value=" + value +
                ", date=" + date +
                '}';
    }


}
