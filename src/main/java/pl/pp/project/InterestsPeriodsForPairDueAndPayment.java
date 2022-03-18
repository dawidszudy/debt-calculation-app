package pl.pp.project;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InterestsPeriodsForPairDueAndPayment {
    private List<InterestPeriod> interestsPeriodsListForPairDueAndPayment = new ArrayList<>();

    public InterestsPeriodsForPairDueAndPayment() {

    }

    public List<InterestPeriod> getInterestPeriodsList() {
        return interestsPeriodsListForPairDueAndPayment;
    }

    public InterestPeriod get(int i) {
        return interestsPeriodsListForPairDueAndPayment.get(i);
    }

    public void add(LocalDate asOfDate, LocalDate byDate, BigDecimal interestPercentage) {
        interestsPeriodsListForPairDueAndPayment.add(new InterestPeriod(asOfDate, byDate, interestPercentage));
    }

    @Override
    public String toString() {
        return "InterestsPeriodsForPairDueAndPayment{" +
                "interestsPeriodsListForPairDueAndPayment=" + interestsPeriodsListForPairDueAndPayment +
                '}';
    }
}
