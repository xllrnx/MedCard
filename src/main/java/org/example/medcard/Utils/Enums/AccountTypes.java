package org.example.medcard.Utils.Enums;

public enum AccountTypes {
    DOCTOR("ЛІКАР"),
    NURSE("МЕДПЕРСОНАЛ");

    private final String type;
    AccountTypes(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
