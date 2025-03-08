package org.example.medcard.Views;

public enum AccountType {
    DOCTOR("ЛІКАР"),
    NURSE("МЕДПЕРСОНАЛ");

    private final String type;
    AccountType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
