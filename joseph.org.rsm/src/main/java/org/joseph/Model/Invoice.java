package org.joseph.Model;

import org.joseph.Model.Types.PurchaseStatus;
import org.joseph.Model.Types.UserType;

import java.time.LocalDate;

public class Invoice {
    public static int TOTAL_INVOICES =  0;
    private int id;
    private User client;
    private Lot lot;
    private LocalDate date_issued;
    private float total_price;

    public Invoice(int id, User client, Lot lot, LocalDate date_issued) {
        TOTAL_INVOICES++;
        this.id = id;
        this.client = client;
        this.date_issued = date_issued;
        this.lot = lot;
        total_price = lot.getPrice() + (lot.getHouse() != null ? lot.getHouse().getFixedPrice() : 0);
    }

    public int getId() { return id; }
    public User getClient() { return client; }
    public Lot getLot() { return lot; }
    public float getTotalPrice() { return total_price; }
    public LocalDate getDateIssued() { return date_issued; }

}
