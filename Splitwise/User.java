package Splitwise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class User {
    private final String id;
    private final String name;
    private final List<Group> groups;
    private final List<Expense> expenses;
    private final Map<User, Double> balances;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.groups = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.balances = new LinkedHashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroups() {
        return Collections.unmodifiableList(groups);
    }

    public List<Expense> getExpenses() {
        return Collections.unmodifiableList(expenses);
    }

    public Map<User, Double> getBalances() {
        return Collections.unmodifiableMap(balances);
    }

    public void addGroup(Group group) {
        if (!groups.contains(group)) {
            groups.add(group);
        }
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void updateBalance(User otherUser, double delta) {
        double updatedBalance = balances.getOrDefault(otherUser, 0.0) + delta;
        if (Math.abs(updatedBalance) < 0.0001) {
            balances.remove(otherUser);
            return;
        }
        balances.put(otherUser, updatedBalance);
    }

    public double getTotalOwed() {
        double total = 0.0;
        for (double amount : balances.values()) {
            if (amount < 0) {
                total += -amount;
            }
        }
        return total;
    }

    public double getTotalToReceive() {
        double total = 0.0;
        for (double amount : balances.values()) {
            if (amount > 0) {
                total += amount;
            }
        }
        return total;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User other)) {
            return false;
        }
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
