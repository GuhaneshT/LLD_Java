package Splitwise;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    private final Map<SplitStrategies, ExpenseSplitStrategy> splitStrategies;

    public ExpenseManager() {
        this.splitStrategies = new EnumMap<>(SplitStrategies.class);
        splitStrategies.put(SplitStrategies.EQUAL, new EqualSplitStrategy());
        splitStrategies.put(SplitStrategies.EXACT, new ExactSplitStrategy());
        splitStrategies.put(SplitStrategies.PERCENTAGE, new PercentageSplitStrategy());
    }

    public Expense addExpense(
        Group group,
        String expenseId,
        String description,
        User paidBy,
        double amount,
        SplitStrategies splitStrategy,
        List<Split> splits
    ) {
        validateExpenseInput(group, paidBy, amount, splits);

        ExpenseSplitStrategy strategy = splitStrategies.get(splitStrategy);
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported split strategy");
        }

        strategy.calculateSplits(amount, splits);

        Expense expense = new Expense(
            expenseId,
            description,
            paidBy,
            amount,
            SplitType.from(splitStrategy),
            splits
        );

        group.addExpense(expense);
        paidBy.addExpense(expense);
        for (Split split : splits) {
            split.getUser().addExpense(expense);
        }

        updateBalances(paidBy, splits);
        return expense;
    }

    public double getNetBalance(User user) {
        return user.getTotalToReceive() - user.getTotalOwed();
    }

    private void validateExpenseInput(Group group, User paidBy, double amount, List<Split> splits) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Expense amount must be positive");
        }
        if (!group.hasUser(paidBy)) {
            throw new IllegalArgumentException("Payer must be a member of the group");
        }
        if (splits == null || splits.isEmpty()) {
            throw new IllegalArgumentException("Expense must have at least one split");
        }
        for (Split split : splits) {
            if (!group.hasUser(split.getUser())) {
                throw new IllegalArgumentException("All split users must belong to the group");
            }
        }
    }

    private void updateBalances(User paidBy, List<Split> splits) {
        for (Split split : splits) {
            User participant = split.getUser();
            if (participant.equals(paidBy)) {
                continue;
            }
            double share = split.getAmount();
            paidBy.updateBalance(participant, share);
            participant.updateBalance(paidBy, -share);
        }
    }
}
