package org.joseph.Model.Types;

public enum HouseType {
    BUNGALOW ("BUNGALOW"),
    DUPLEX ("DUPLEX"),
    MODERN_MINIMALIST ("MODERN MINIMALIST"),
    TOWN_HOUSE ("TOWN HOUSE"),
    TWO_STORY ("TWO STORY");

    private final String label;

    HouseType(String label) {
        this.label = label.toLowerCase();
    }

    public static HouseType fromString(String houseName) {
        for(HouseType type : HouseType.values()) {
            if(type.label.equals(houseName.toLowerCase())) {
                return type;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return label;
    }
}
