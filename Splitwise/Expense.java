package Splitwise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Expense {
    private final String id;
    private final String description;
    private final User paidBy;
    private final double totalAmount;
    private final SplitType splitType;
    private final List<Split> splits;

    public Expense(
        String id,
        String description,
        User paidBy,
        double totalAmount,
        SplitType splitType,
        List<Split> splits
    ) {
        this.id = id;
        this.description = description;
        this.paidBy = paidBy;
        this.totalAmount = totalAmount;
        this.splitType = splitType;
        this.splits = new ArrayList<>(splits);
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public List<Split> getSplits() {
        return Collections.unmodifiableList(splits);
    }
}
