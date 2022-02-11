package pl.pp.project;

public class Condition {
    boolean condition;
    int subtraction;

    public Condition(boolean condition, int subtraction) {
        this.condition = condition;
        this.subtraction = subtraction;
    }


    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public int getSubtraction() {
        return subtraction;
    }

    public void setSubtraction(int subtraction) {
        this.subtraction = subtraction;
    }
}
