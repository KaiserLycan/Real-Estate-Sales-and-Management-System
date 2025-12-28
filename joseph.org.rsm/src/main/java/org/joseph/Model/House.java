package org.joseph.Model;

import org.joseph.Model.Types.HouseType;

public class House {
    public static int TOTAL_HOUSES = 0;
    protected float fixedPrice;
    protected String imageURL;
    protected HouseType type;

    public House(HouseType type) {
        TOTAL_HOUSES++;
        this.type = type;
    }

    public void setFixedPrice(float fixedPrice) { this.fixedPrice = fixedPrice; }
    public void setImage(String imageURL) { this.imageURL = imageURL; }

    public float getFixedPrice() { return fixedPrice; }
    public String getImageURL() { return imageURL; }
    public HouseType getHouseType() { return type; }
}
