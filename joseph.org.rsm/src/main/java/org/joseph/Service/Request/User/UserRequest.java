package org.joseph.Service.Request.User;

import org.joseph.Model.User;
import org.joseph.Service.Request.Request;

public class UserRequest implements Request {
    private final User user;

    public UserRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
