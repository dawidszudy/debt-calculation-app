package pl.pp.project;

import java.util.ArrayList;
import java.util.List;

public class Conditions {
    private List<Condition> conditionsList = new ArrayList<>();

    public Conditions() {

    }

    public List<Condition> getConditionsList() {
        return conditionsList;
    }

    public void add(Condition condition) {
        conditionsList.add(condition);
    }

    public Condition get(int i) {
        return conditionsList.get(i);
    }

    public void add(boolean condition, int subtraction, String infoMessage) {
        conditionsList.add(new Condition(condition, subtraction, infoMessage));
    }
}
