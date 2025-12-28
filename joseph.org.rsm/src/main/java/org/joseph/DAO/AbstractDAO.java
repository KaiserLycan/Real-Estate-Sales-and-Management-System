package org.joseph.DAO;

import java.io.File;
import java.io.IOException;

public abstract class AbstractDAO {
    protected final File database;

    protected AbstractDAO(String fileName) {
        database = new File(fileName);
        try {
            if(database.createNewFile()) {
                System.out.println("Cannot find file: " + database.getPath());
                System.out.println("Created file: " + database.getPath());
            }

            System.out.println("Successfully Connected to RealEstateDB");
        }
        catch (IOException ex) {
            System.out.println("Cannot connect to RealEstateDB");
        }

        readData();
    }

    public void closeDB() {
        writeData();
    };
    protected abstract void readData();
    protected abstract void writeData();

}
