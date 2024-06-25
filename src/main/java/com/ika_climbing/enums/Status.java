package com.ika_climbing.enums;

public enum Status {

    ACTIVE("Active"),
    PAY("Pay"),
    Inactive("Inactive");

    private final String displayName;

    Status(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
