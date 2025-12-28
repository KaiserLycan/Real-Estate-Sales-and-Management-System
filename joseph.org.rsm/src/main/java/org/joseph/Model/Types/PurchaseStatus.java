package org.joseph.Model.Types;

public enum PurchaseStatus {
    SOLD ("Sold"),
    RESERVED ("Reserved"),
    AVAILABLE ("Available");

    private final String label;

    PurchaseStatus(String label) {
        this.label = label.toLowerCase();
    }

    public static PurchaseStatus fromString(String purchaseStatus) {
        for (PurchaseStatus status : PurchaseStatus.values()) {
            if (status.label.equals(purchaseStatus.toLowerCase())) {
                return status;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return label;
    }
}