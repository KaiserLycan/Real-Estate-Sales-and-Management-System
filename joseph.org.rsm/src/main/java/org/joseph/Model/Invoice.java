package org.joseph.Model;

public class Invoice {
    User agent;
    Lot lot;
    float total_price;

    public Invoice(User agent, User client, Lot lot) {
        this.agent = agent;
        this.lot = lot;
        total_price = lot.getPrice() + (lot.getHouse().getFixedPrice() > 0 ? lot.getPrice() + lot.getHouse().getFixedPrice() : 0);
    }

}
