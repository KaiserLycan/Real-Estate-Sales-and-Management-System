package org.joseph.DAO;

import org.joseph.Model.Invoice;
import org.joseph.Model.Lot;
import org.joseph.Model.User;
import org.joseph.Store.InvoiceStore;
import org.joseph.Store.RealEstateStore;
import org.joseph.Store.UserStore;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceDAO extends AbstractDAO{

    private String[] columns = {
            "id",
            "clientId",
            "blockId",
            "lotId",
            "date_issued",
    };

    public InvoiceDAO(String fileName) {
        super(fileName);
    }

    @Override
    protected void readData() {
        List<String[]> data = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();

        try(Scanner reader = new Scanner(database)) {
            if(reader.hasNextLine()) {
                reader.nextLine();
            }

            while(reader.hasNextLine()) {
                data.add(reader.nextLine().split(","));
            }

            if(data.isEmpty()) return;
        }
        catch (IOException exception) {
            System.out.println("Error: Cannot read file.");
            exception.printStackTrace();
            return;
        }

        for(String[] datum : data) {
            int id = Integer.parseInt(datum[0]);
            int clientId = Integer.parseInt(datum[1]);
            int blockId = Integer.parseInt(datum[2]);
            int lotId = Integer.parseInt(datum[3]);
            LocalDate date_issued = LocalDate.parse(datum[4]);

            User client = UserStore.getInstance().getUser(clientId);
            Lot lot = RealEstateStore.getInstance().getLot(blockId, lotId);

            invoices.add(new Invoice(id, client, lot, date_issued));
        }

        InvoiceStore.getInstance().setInvoices(invoices);
    }

    @Override
    protected void writeData() {
        List<String[]> data = new ArrayList<>();
        List<Invoice> invoices = InvoiceStore.getInstance().getInvoice();

        //Transform invoices into an array string.
        for(Invoice invoice : invoices) {
            String[] datum = new String[columns.length];
            datum[0] = String.valueOf(invoice.getId());
            datum[1] = String.valueOf(invoice.getClient().getID());
            datum[2] = String.valueOf(RealEstateStore.getInstance().getBlock(invoice.getLot()).getBlockID());
            datum[3] = String.valueOf(invoice.getLot().getLotID());
            datum[4] = invoice.getDateIssued().toString();

            data.add(datum);
        }

        //Write the data into the database.
        try (FileWriter writer = new FileWriter(database)) {
            writer.append(String.join(",", columns)).append("\n");
            for(String[] datum : data) {
                writer.append(String.join(",", datum)).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error: Cannot Write file");
            e.printStackTrace();
        }
    }
}
