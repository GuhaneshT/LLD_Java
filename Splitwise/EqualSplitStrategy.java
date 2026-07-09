package Splitwise;

import java.util.List;

public class EqualSplitStrategy implements ExpenseSplitStrategy {
    @Override
    public void calculateSplits(double totalAmount, List<Split> splits) {
        double share = roundToTwoDecimals(totalAmount / splits.size());
        double assignedAmount = 0.0;

        for (int i = 0; i < splits.size(); i++) {
            double amount = share;
            if (i == splits.size() - 1) {
                amount = roundToTwoDecimals(totalAmount - assignedAmount);
            }
            splits.get(i).setAmount(amount);
            assignedAmount += amount;
        }
    }

    private double roundToTwoDecimals(double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }
}
