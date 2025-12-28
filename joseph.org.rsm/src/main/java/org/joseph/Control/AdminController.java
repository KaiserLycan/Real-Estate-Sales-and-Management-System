package org.joseph.Control;

import org.joseph.View.AdminFrame;
import org.joseph.View.InvoiceView;
import org.joseph.View.RealEstateView;
import org.joseph.View.UsersView;

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
