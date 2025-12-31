package org.joseph.View;

import org.joseph.Store.InvoiceStore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InvoiceView extends JPanel {

    private final JTable table;
    private final DefaultTableModel model;

    public InvoiceView() {
        String[] headers = {
                "id",
                "lot_id",
                "amount",
                "purchased_by",
                "date_purchased",
        };

        model = new DefaultTableModel(headers, 0);

        // Populate the table
        InvoiceStore.getInstance().getInvoice().forEach(invoice -> {
            model.addRow(new Object[] {
                    invoice.getId(),
                    invoice.getLot().getLotID(),
                    invoice.getTotalPrice(),
                    invoice.getClient().getFName() + " " + invoice.getClient().getLName(),
                    invoice.getDateIssued().toString()
            });
        });

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(scrollPane);
    }

    public JTable getTable() { return  table; }
    public DefaultTableModel getModel() { return model; }
}
