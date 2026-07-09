package Splitwise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private final String id;
    private final String groupName;
    private final List<User> users;
    private final List<Expense> expenses;

    public Group(String id, String groupName) {
        this.id = id;
        this.groupName = groupName;
        this.users = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public List<Expense> getExpenses() {
        return Collections.unmodifiableList(expenses);
    }

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
            user.addGroup(this);
        }
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public boolean hasUser(User user) {
        return users.contains(user);
    }
}
