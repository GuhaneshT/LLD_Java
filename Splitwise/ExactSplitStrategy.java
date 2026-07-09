package Splitwise;

import java.util.List;

public class ExactSplitStrategy implements ExpenseSplitStrategy {
    @Override
    public void calculateSplits(double totalAmount, List<Split> splits) {
        double currentTotal = 0.0;
        for (Split split : splits) {
            currentTotal += split.getAmount();
        }
        if (Math.abs(currentTotal - totalAmount) > 0.0001) {
            throw new IllegalArgumentException("Exact splits must add up to the total expense");
        }
    }
}
