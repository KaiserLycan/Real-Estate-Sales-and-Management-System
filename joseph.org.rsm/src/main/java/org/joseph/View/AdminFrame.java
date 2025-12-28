package org.joseph.View;

import org.joseph.Control.AdminController;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame {

    private final JButton realEstateBtn = new JButton("Manage Real Estate");
    private final JButton usersBtn = new JButton("Manage Users");
    private final JButton invoiceBtn = new JButton("Manage Invoice");
    private final JButton logout = new JButton("Logout");

    private final RealEstateView realEstateView = new RealEstateView();
    private final UsersView usersView = new UsersView();
    private final InvoiceView invoiceView = new InvoiceView();

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel mainPanel = new JPanel(cardLayout);

    // Manage Lots, Users, and Invoice.
    public AdminFrame() {

        AdminController controller = new AdminController(this);

        //Sizing
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        //Initializing
        setTitle("Admin Dashboard");
        setSize(screenSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Side Panel
        JPanel sidePanel = new JPanel();
        sidePanel.setMaximumSize(new Dimension(300, this.getHeight()));
        sidePanel.setPreferredSize(new Dimension(300, this.getHeight()));
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));

        JButton[] sidePanelButtons = new JButton[] {
                realEstateBtn,
                usersBtn,
                invoiceBtn,
                logout
        };

        for(JButton btn : sidePanelButtons) {
            btn.setMaximumSize(new Dimension(280, 50));
            btn.setPreferredSize(new Dimension(280, 50));
            btn.setMargin(new Insets(10, 20, 10,20));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            if(btn.getText().equals("Logout")) {
                sidePanel.add(Box.createVerticalGlue());
            }
            sidePanel.add(Box.createVerticalStrut(10));
            sidePanel.add(btn);
            sidePanel.add(Box.createVerticalStrut(10));
        }

        //Panels
        mainPanel.add(realEstateView, "Real Estate");
        mainPanel.add(usersView, "Users");
        mainPanel.add(invoiceView, "Invoice");

        add(mainPanel);
        add(sidePanel, BorderLayout.WEST);
        revalidate();
        repaint();
    }

    public JButton getRealEstateBtn() { return realEstateBtn; }
    public JButton getUsersBtn() { return usersBtn; }
    public JButton getInvoiceBtn() { return invoiceBtn; }
    public JButton getLogout() { return logout; }
    public RealEstateView getRealEstateView() { return realEstateView; }
    public UsersView getUsersView() { return usersView; }
    public InvoiceView getInvoiceView() { return invoiceView; }
    public CardLayout getCardLayout() { return cardLayout; }
    public JPanel getMainPanel() { return mainPanel; }
}
