package org.joseph.Service;

import org.joseph.Model.User;
import org.joseph.Store.UserStore;

public class AuthenticateUser {
    public static User authenticateUser (User user) {
        return UserStore.getInstance().getUser().stream().filter(u -> u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())).findFirst().orElse(null);
    }
}
