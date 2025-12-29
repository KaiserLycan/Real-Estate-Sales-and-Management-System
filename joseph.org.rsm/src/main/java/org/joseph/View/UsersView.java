package org.joseph.View;

import org.joseph.Store.UserStore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UsersView extends JPanel {


    private final JTable table;
    private final DefaultTableModel model;

    public UsersView() {
        String[] headers = new String[] {
                "ID",
                "Username",
                "Full Name",
                "Password",
                "Permissions"
        };

        model = new DefaultTableModel(headers, 0);

        UserStore.getInstance().getUser().forEach(user -> {
            model.addRow(new Object[] {
                    user.getID(),
                    user.getUsername(),
                    user.getFName() + " " + user.getLName(),
                    user.getPassword(),
                    user.getType()
            });
        });

        table = new JTable(model);
        JScrollPane scrollPane  = new JScrollPane(table);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(scrollPane);
    }

    public JTable getTable() { return table; }
    public DefaultTableModel getModel() { return model; }
}
