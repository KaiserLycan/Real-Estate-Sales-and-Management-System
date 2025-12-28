package org.joseph.Store;

import org.joseph.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserStore {
    private static List<User> usersStore = new ArrayList<>();
    public static void setUser(List<User> users) { usersStore = users; }
    public static List<User>  getUser() { return usersStore;}
    public static User getUser(int userId) {
        return usersStore.stream().filter(u -> u.getID() == userId).findFirst().orElse(null);
    }
    public static void addUser(User newUser) { usersStore.add(newUser); }
    public static void deleteUser(User user) { usersStore.removeIf( u -> u.getID() == user.getID()); }
    public static void updateUser(User updatedUser) {
        Optional<User> user = usersStore.stream().filter(u -> u.getID() == updatedUser.getID()).findFirst();
        user.ifPresent(u -> {
            u.setUsername(updatedUser.getUsername());
            u.setPassword(updatedUser.getPassword());
            u.setType(updatedUser.getType());
        });
    }
}
