package org.joseph.View;

import org.joseph.Store.RealEstateStore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RealEstateView extends JPanel {

    private final JTable table;
    private final DefaultTableModel model;
    private final JButton add;
    private final  String[] tableHeaders = new String[] {
            "block",
            "lot",
            "type",
            "house",
            "total_price",
            "status"
    };

    public RealEstateView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel headers = new JPanel();
        headers.setLayout(new BoxLayout(headers, BoxLayout.Y_AXIS));
        headers.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        headers.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel header = new JLabel("Manage Real Estate");
        header.setFont(header.getFont().deriveFont(Font.BOLD, 50));
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        headers.add(header);
        this.add(headers);

        JPanel actionBar = new JPanel();
        actionBar.setLayout(new BoxLayout(actionBar, BoxLayout.X_AXIS));
        actionBar.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add = new JButton("Add Real Estate");
        actionBar.add(add);
        actionBar.add(Box.createHorizontalGlue());
        this.add(actionBar);


        model = new DefaultTableModel(tableHeaders, 0);

        RealEstateStore.getInstance().getBlock().forEach(block -> {
            block.getLots().forEach(lot -> {
                model.addRow(new Object[]{
                        block.getBlockID(),
                        lot.getLotID(),
                        lot.getLotType(),
                        lot.getHouse() != null ? lot.getHouse().getHouseType() : "-",
                        lot.getPrice() + (lot.getHouse() != null ? lot.getHouse().getFixedPrice() : 0),
                        lot.getStatus()
                });
            });
        });

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(scrollPane);
    }

    public JTable getTable() { return  table; }
    public DefaultTableModel getModel() { return model; }
    public JButton getAdd() { return add; }
}
