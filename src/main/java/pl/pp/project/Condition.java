package pl.pp.project;

public class Condition {
    private boolean condition;
    private int subtraction;
    private String infoMessage;

    public Condition(boolean condition, int subtraction, String infoMessage) {
        this.condition = condition;
        this.subtraction = subtraction;
        this.infoMessage = infoMessage;
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

    public String getInfoMessage() {
        return infoMessage;
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }
}
