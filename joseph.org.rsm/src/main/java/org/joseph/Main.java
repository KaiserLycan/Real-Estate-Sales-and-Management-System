package org.joseph;

import org.joseph.Component.CreateRealEstateModal;
import org.joseph.DAO.AbstractDAO;
import org.joseph.DAO.InvoiceDAO;
import org.joseph.DAO.RealEstateDAO;
import org.joseph.DAO.UserDAO;
import org.joseph.View.AdminFrame;
import org.joseph.View.AuthFrame;

import javax.swing.*;
import java.awt.EventQueue;


public class Main {


    public static void main(String[] args) {
        AbstractDAO uDao = new UserDAO("user.csv");
        AbstractDAO rDao = new RealEstateDAO("real_estate.csv");
        AbstractDAO vDao = new InvoiceDAO("invoice.csv");


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new AuthFrame();
                frame.setVisible(true);
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("App is exiting... saving data.");
            uDao.closeDB();
            rDao.closeDB();
            vDao.closeDB();
        }));
    }

}