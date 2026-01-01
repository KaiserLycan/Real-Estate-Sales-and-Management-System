package org.joseph.Service.Response.User;

import org.joseph.Model.User;
import org.joseph.Service.Response.ResponseFactory;

import java.util.List;

public class UserResponseFactory implements ResponseFactory {
    public static UserResponse makeUserResponse(User user) { return new UserResponse(user); }
    public static UsersResponse makeUserResponse(List<User> users) { return new UsersResponse(users); }

}
