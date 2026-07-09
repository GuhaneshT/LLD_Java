package Splitwise;

import java.util.List;

public class PercentageSplitStrategy implements ExpenseSplitStrategy {
    @Override
    public void calculateSplits(double totalAmount, List<Split> splits) {
        double totalPercentage = 0.0;
        double assignedAmount = 0.0;

        for (Split split : splits) {
            totalPercentage += split.getPercentage();
        }

        if (Math.abs(totalPercentage - 100.0) > 0.0001) {
            throw new IllegalArgumentException("Split percentages must add up to 100");
        }

        for (int i = 0; i < splits.size(); i++) {
            Split split = splits.get(i);
            double amount = roundToTwoDecimals(totalAmount * split.getPercentage() / 100.0);
            if (i == splits.size() - 1) {
                amount = roundToTwoDecimals(totalAmount - assignedAmount);
            }
            split.setAmount(amount);
            assignedAmount += amount;
        }
    }

    private double roundToTwoDecimals(double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }
}
