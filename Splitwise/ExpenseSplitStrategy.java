package Splitwise;

import java.util.List;

public interface ExpenseSplitStrategy {
    void calculateSplits(double totalAmount, List<Split> splits);
}
