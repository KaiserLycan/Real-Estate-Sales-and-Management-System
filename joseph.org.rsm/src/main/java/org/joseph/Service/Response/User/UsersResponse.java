package org.joseph.Service.Response.User;

import org.joseph.Model.User;
import org.joseph.Service.Response.Response;

import java.util.List;

public class UsersResponse implements Response {
    private final List<User> users;

    public UsersResponse(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
