package org.joseph.Model.Types;

public enum UserType {
    CLIENT("Client"),
    ADMIN("Admin");

    private String label;

    UserType(String label) {
        this.label = label.toLowerCase();
    }

    public static UserType fromString(String userType) {
        for (UserType type : UserType.values()) {
            if(type.label.equals(userType.toLowerCase())) {
                return type;
            }
        }

        return null;
    }

    @Override
    public String toString() { return label;}
}
