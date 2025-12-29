    package org.joseph.DAO;

    import java.io.File;
    import java.io.IOException;

    public abstract class AbstractDAO {
        protected final File database;

        protected AbstractDAO(String fileName) {
            database = new File("Data", fileName);

            try {
                if(!database.exists()) {
                    database.getParentFile().mkdirs();
                    database.createNewFile();
                    System.out.println("Created database: " + database.getPath());
                }
                System.out.println("Successfully connected to " + database.getPath() + " Database");
            }
            catch (IOException ex) {
                throw new RuntimeException("Cannot connect to " + database.getPath() + " Database");
            }

            readData();
        }

        public void closeDB() {
            writeData();
        }
        protected abstract void readData();
        protected abstract void writeData();

    }
