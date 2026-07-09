package Splitwise;

import java.util.ArrayList;
import java.util.List;

public class GroupManager {
    private final List<Group> groups;
    private final List<User> users;

    public GroupManager() {
        this.groups = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Group getGroup(String groupName) {
        for (Group group : groups) {
            if (group.getGroupName().equals(groupName)) {
                return group;
            }
        }
        return null;
    }

    public User getUser(String userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public void addUserToGroup(User user, Group group) {
        if (!users.contains(user)) {
            users.add(user);
        }
        if (!groups.contains(group)) {
            groups.add(group);
        }
        group.addUser(user);
    }
}
