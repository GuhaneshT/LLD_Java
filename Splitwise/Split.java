package Splitwise;

public class Split {
    private final User user;
    private double amount;
    private double percentage;

    public Split(User user) {
        this(user, 0.0, 0.0);
    }

    public Split(User user, double amount) {
        this(user, amount, 0.0);
    }

    public Split(User user, double amount, double percentage) {
        this.user = user;
        this.amount = amount;
        this.percentage = percentage;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
