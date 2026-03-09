package com.xrm.entity;

public enum CustomerStatusEnum {
    
    Active("Active"),
    Inactive("Inactive")
    ;

    private final String status;

    CustomerStatusEnum(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public boolean isActive() {
        return this == Active;
    }

}
