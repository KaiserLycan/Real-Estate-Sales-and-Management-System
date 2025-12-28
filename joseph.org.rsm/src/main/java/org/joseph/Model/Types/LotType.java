package org.joseph.Model.Types;

public enum LotType {
    CORNER_LOT ("CORNER LOT"),
    INTERIOR_LOT("INTERIOR LOT"),
    OUTER_LOT("OUTER LOT");

    private final String label;

    LotType(String label) {
        this.label = label.toLowerCase();
    }

    public static LotType fromString(String lotName) {
        for(LotType type : LotType.values()) {
            if(type.label.equals(lotName.toLowerCase())) {
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
