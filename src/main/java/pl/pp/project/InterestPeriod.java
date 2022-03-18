package pl.pp.project;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class InterestPeriod {
    private LocalDate asOfDate;
    private LocalDate byDate;
    private BigDecimal interestPercentage;
    private long numberDays;

    public InterestPeriod(LocalDate asOfDate, LocalDate byDate, BigDecimal interestPercentage) {
        this.asOfDate = asOfDate;
        this.byDate = byDate;
        this.interestPercentage = interestPercentage;
        initializeNumberDays();
    }

    public LocalDate getAsOfDate() {
        return asOfDate;
    }

    public LocalDate getByDate() {
        return byDate;
    }

    public BigDecimal getInterestPercentage() {
        return interestPercentage;
    }

    public void initializeNumberDays() {
        numberDays = DAYS.between(asOfDate, byDate) + 1;
    }

    public long getNumberDays() {
        return numberDays;
    }

    public void setNumberDaysForIncompletePeriodWithDue(LocalDate dateOfDue) {
        this.numberDays = DAYS.between(dateOfDue, byDate);
    }

    public void setNumberDaysForIncompletePeriodWithPayment(LocalDate dateOfPayment) {
        this.numberDays = DAYS.between(asOfDate, dateOfPayment);
    }

    public void setNumberDays(long numberDays) {
        this.numberDays = numberDays;
    }

    @Override
    public String toString() {
        return "InterestPeriod{" +
                "asOfDate=" + asOfDate +
                ", byDate=" + byDate +
                ", interestPercentage=" + interestPercentage +
                ", numberDays=" + numberDays +
                '}';
    }
}
