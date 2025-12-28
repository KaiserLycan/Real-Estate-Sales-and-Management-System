package org.joseph;

import org.joseph.View.AdminFrame;

import javax.swing.*;
import java.awt.EventQueue;


public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new AdminFrame();
                frame.setVisible(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
    }
}