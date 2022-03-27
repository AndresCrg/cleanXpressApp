package com.uptc.cleanXpress.utilities;

public enum ClientType {

    RESIDENTIAL("RE"), COMMERTIAL("COM");

    private String value = "";

    ClientType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
