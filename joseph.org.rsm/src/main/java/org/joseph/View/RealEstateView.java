package org.joseph.View;

import org.joseph.Store.RealEstateStore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RealEstateView extends JPanel {

    private final JTable table;
    private final DefaultTableModel model;

    public RealEstateView() {
        String[] headers = new String[] {
                "block",
                "lot",
                "type",
                "house",
                "total_price",
                "status"
        };

        model = new DefaultTableModel(headers, 0);

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

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(scrollPane);
    }

    public JTable getTable() { return  table; }
}
