package org.joseph.Store;

import org.joseph.DAO.UserDAO;
import org.joseph.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserStore {
    private static volatile UserStore Instance;
    private List<User> usersStore = new ArrayList<>();

    private UserStore() {}

    public static UserStore getInstance() {
        if(Instance == null)
            synchronized (UserStore.class) {
                if(Instance == null)
                    Instance = new UserStore();
            }
        return Instance;
    }

    public  void setUser(List<User> users) { usersStore = users; }
    public  List<User>  getUser() { return usersStore;}
    public  User getUser(int userId) {
        return usersStore.stream().filter(u -> u.getID() == userId).findFirst().orElse(null);
    }
    public  void addUser(User newUser) { usersStore.add(newUser); }
    public  void deleteUser(User user) { usersStore.removeIf( u -> u.getID() == user.getID()); }
    public  void updateUser(User updatedUser) {
        Optional<User> user = usersStore.stream().filter(u -> u.getID() == updatedUser.getID()).findFirst();
        user.ifPresent(u -> {
            u.setUsername(updatedUser.getUsername());
            u.setPassword(updatedUser.getPassword());
            u.setType(updatedUser.getType());
        });
    }
}
