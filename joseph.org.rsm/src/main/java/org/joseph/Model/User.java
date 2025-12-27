package org.joseph.Model;

import org.joseph.Model.Types.UserType;

public class User {
    public static int TOTAL_USERS = 0;
    private int id = 0;
    private String username;
    private String password;
    private String fName;
    private String lName;
    private UserType type;

    public User(int id) {
        TOTAL_USERS++;
        this.id = id;
    }

    public void setUsername (String username) { this.username = username;}
    public void setPassword (String password) { this.password = password;}
    public void setFName (String fName) { this.fName = fName;}
    public void setLName (String lName) { this.lName = lName;}
    public void setType (UserType type) { this.type = type; }

    public int getID() { return  id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFName () { return fName; }
    public String getLName () { return lName; }
    public UserType getType() { return type; }
}
