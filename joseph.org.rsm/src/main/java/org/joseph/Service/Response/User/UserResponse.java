package org.joseph.Service.Response.User;

import org.joseph.Model.User;
import org.joseph.Service.Response.Response;

public class UserResponse implements Response {
    private final User user;

    public UserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
