package org.joseph.Model;

import org.joseph.Model.Types.LotType;

public class Lot {
    public static int TOTAL_LOTS = 0;
    private final int lotID;
    private User owner;
    private final  float size;
    private float price;
    private String imageURL;
    private final LotType type;
    private House house;

    public Lot(int lotID, float size, LotType type) {
        TOTAL_LOTS++;
        this.lotID = lotID;
        this.size = size;
        this.type = type;
    }

    public void setPrice(float price) {this.price = price; }
    public void setHouse(House house) { this.house = house; }
    public void setImageURL(String imageURL) { this.imageURL = imageURL; }
    public void setOwner (User user) { this.owner = user; }

    public int getLotID() { return lotID; }
    public float getSize() { return size; }
    public float getPrice() { return price; }
    public String getImageURL() { return imageURL; }
    public LotType getLotType() { return type; }
    public House getHouse() { return house; }
    public User getOwner() { return owner; }

}
