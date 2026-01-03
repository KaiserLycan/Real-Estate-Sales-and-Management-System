package org.joseph.Controller;

import org.joseph.Model.Types.UserType;
import org.joseph.Model.User;
import org.joseph.Service.AuthenticateUser;
import org.joseph.View.AdminFrame;
import org.joseph.View.AuthFrame;
import org.joseph.View.ClientFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AuthController{

    AuthFrame frame;

    public AuthController(AuthFrame frame) {
        this.frame = frame;

        frame.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAuthentication();
            }
        });

        frame.getRootPane().setDefaultButton(frame.getLoginButton());
    }

    private void performAuthentication() {
        User user = new User(0, false);
        JFrame toOpen;

        user.setPassword(((JTextField) frame.getPasswordField()).getText());
        user.setUsername(frame.getUsernameField().getText());

        User authenticatedUser = AuthenticateUser.authenticateUser(user);
        if(authenticatedUser == null) {
            frame.popMessage("Invalid Username and Password", JOptionPane.ERROR_MESSAGE);
        }
        else {
            frame.popMessage("User login successfully.", JOptionPane.PLAIN_MESSAGE);
            if(authenticatedUser.getType() == UserType.ADMIN) {
                toOpen = new AdminFrame();
                toOpen.setVisible(true);
                toOpen.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
            else {
                toOpen = new ClientFrame();
                toOpen.setVisible(true);
                toOpen.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }

            frame.dispose();
        }
    }
}
