package org.joseph.DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.joseph.Model.Types.UserType;
import org.joseph.Model.User;
import org.joseph.Store.UserStore;

public class UserDAO extends AbstractDAO {
    private final String[] columns = new String[] {
            "userId",
            "username",
            "password",
            "first_name",
            "last_name",
            "type"
    };

    public UserDAO(String fileName) {
        super(fileName);

    }

    @Override
    protected void readData() {
        List<String[]> data = new ArrayList<>();
        List<User> users = new ArrayList<>();

        try (Scanner reader = new Scanner(database)) {

            if(reader.hasNextLine()) {
                reader.nextLine();
            }

            while(reader.hasNextLine()) {
                data.add(reader.nextLine().split(","));
            }
        }
        catch (IOException ex) {
            System.out.println("Error: Cannot read file.");
        }

        if(data.isEmpty()) return;

        // Create the User data object;
        for(String[] datum : data) {
            int userId = Integer.parseInt(datum[0]);
            String username = datum[1];
            String password = datum[2];
            String fName = datum[3];
            String lName = datum[4];
            UserType type = UserType.fromString(datum[5]);

            User user = new User(userId);
            user.setUsername(username);
            user.setPassword(password);
            user.setFName(fName);
            user.setLName(lName);
            user.setType(type);

            users.add(user);
        }

        UserStore.getInstance().setUser(users);
    }

    @Override
    protected void writeData() {
        List<User> users = UserStore.getInstance().getUser();
        List<String[]> data = new ArrayList<>();

        for(User user: users) {
            String[] datum = new String[columns.length];
            datum[0] = String.valueOf(user.getID());
            datum[1] = user.getUsername();
            datum[2] = user.getPassword();
            datum[3] = user.getFName();
            datum[4] = user.getLName();
            datum[5] = user.getType().toString();
            data.add(datum);
        }

        try(FileWriter writer = new FileWriter(database)) {
            writer.append(String.join(",", columns)).append("\n");
            for(String[] datum : data) {
                writer.append(String.join(",", datum)).append("\n");
            }
        }
        catch (IOException ex) {
            System.out.println("Error cannot write data to " + database.getPath());
        }
    }


}
