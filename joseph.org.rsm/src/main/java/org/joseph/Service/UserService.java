package org.joseph.Service;

import org.joseph.Service.Request.Request;
import org.joseph.Service.Request.User.UserRequest;
import org.joseph.Service.Response.Response;
import org.joseph.Service.Response.User.UserResponse;
import org.joseph.Service.Response.User.UsersResponse;
import org.joseph.Store.UserStore;

public class UserService implements IAppService<Request, Response>{

    @Override
    public void add(Request createObject) {
        if(!(createObject instanceof UserRequest)) return;

        try {
            UserStore.getInstance().addUser(((UserRequest) createObject).getUser());
            System.out.println("User added successfully");
        }
        catch (Exception exception) {
            System.out.println("Error in adding User service");
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Request updateObject) {
        if(!(updateObject instanceof UserRequest)) return;

        try {
            UserStore.getInstance().updateUser(((UserRequest) updateObject).getUser());
            System.out.println("User updated successfully.");
        }
        catch (Exception exception) {
            System.out.println("Error in updating User service");
            exception.printStackTrace();
        }

    }

    @Override
    public void delete(Request deleteObject) {
        if(!(deleteObject instanceof UserRequest)) return;

        try {
            UserStore.getInstance().deleteUser(((UserRequest) deleteObject).getUser());
            System.out.println("User deleted successfully.");
        }
        catch (Exception exception) {
            System.out.println("Error in deleting User service");
            exception.printStackTrace();
        }
    }

    @Override
    public Response get(Request getObject) {
        if(!(getObject instanceof UserRequest)) return null;
        UserRequest request = (UserRequest) getObject;

        try {
            if(request.getUser() != null) {
                return new UserResponse(UserStore.getInstance().getUser(request.getUser().getID()));
            }
            else if (request.getUser() == null) {
                return new UsersResponse(UserStore.getInstance().getUser());
            }
            else {
                throw new Exception("Invalid user request.");
            }

        }
        catch (Exception exception) {
            System.out.println("Error in getting User service");
            exception.printStackTrace();
            return null;
        }
    }
}
