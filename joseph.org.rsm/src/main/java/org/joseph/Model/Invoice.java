package org.joseph.Model;

import org.joseph.Model.Types.PurchaseStatus;
import org.joseph.Model.Types.UserType;

import java.time.LocalDate;

public class Invoice {
    User client;
    Lot lot;
    LocalDate date_issued;
    float total_price;

    public Invoice(User client, Lot lot, LocalDate date_issued) {
        this.client = client;
        this.date_issued = date_issued;
        this.lot = lot;
        total_price = lot.getPrice() + (lot.getHouse().getFixedPrice() > 0 ? lot.getPrice() + lot.getHouse().getFixedPrice() : 0);
    }
}
