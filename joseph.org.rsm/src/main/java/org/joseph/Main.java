package org.joseph;

import org.joseph.DAO.RealEstateDAO;
import org.joseph.DAO.UserDAO;
import org.joseph.Store.RealEstateStore;
import org.joseph.Store.UserStore;
import org.joseph.View.AdminFrame;

import javax.swing.*;
import java.awt.EventQueue;


public class Main {


    public static void main(String[] args) {
        RealEstateDAO rDao = new RealEstateDAO("real_estate.csv");
        UserDAO uDao = new UserDAO("user.csv");



        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new AdminFrame();
                frame.setVisible(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("App is exiting... saving data.");
            rDao.closeDB();
            uDao.closeDB();
        }));
    }

}