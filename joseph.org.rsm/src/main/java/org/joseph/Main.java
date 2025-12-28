package org.joseph;

import org.joseph.View.AuthWindow;

import java.awt.EventQueue;


public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AuthWindow().setVisible(true);
            }
        });
    }
}