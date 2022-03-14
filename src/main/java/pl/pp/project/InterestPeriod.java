package pl.pp.project;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InterestPeriod {
    private LocalDate asOfDate;
    private LocalDate byDate;
    private BigDecimal interestPercentage;

    public InterestPeriod(LocalDate asOfDate, LocalDate byDate, BigDecimal interestPercentage) {
        this.asOfDate = asOfDate;
        this.byDate = byDate;
        this.interestPercentage = interestPercentage;
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
}
