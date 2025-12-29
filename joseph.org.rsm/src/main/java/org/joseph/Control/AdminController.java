package org.joseph.Control;

import org.joseph.View.AdminFrame;

public class AdminController {

    public AdminController(AdminFrame frame) {
        frame.getRealEstateBtn().addActionListener(e -> {
            frame.getCardLayout().show(frame.getMainPanel(), "Real Estate");
        });

        frame.getUsersBtn().addActionListener(e -> {
            frame.getCardLayout().show(frame.getMainPanel(), "Users");
        });

        frame.getInvoiceBtn().addActionListener(e -> {
            frame.getCardLayout().show(frame.getMainPanel(), "Invoice");
        });

        frame.getLogout().addActionListener(e -> {
            frame.dispose();
            System.exit(0);
        });
    }

}
