package pl.pp.project;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InterestsPeriods {
    private List<InterestPeriod> interestsPeriodsList = new ArrayList<>();

    public InterestsPeriods() {

    }

    public List<InterestPeriod> getInterestPeriodsList() {
        return interestsPeriodsList;
    }

    public InterestPeriod get(int i) {
        return interestsPeriodsList.get(i);
    }

    public void add(LocalDate asOfDate, LocalDate byDate, BigDecimal interestPercentage) {
        interestsPeriodsList.add(new InterestPeriod(asOfDate, byDate, interestPercentage));
    }

}
