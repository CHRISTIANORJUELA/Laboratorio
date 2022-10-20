package com.example.laboratory.utils;

public enum Care {

    DONTWENT("dont wet"),
    HANDLEWITHCARE("handle with care"),
    WITHOUTCARE( "without care");

    private String nameCare;

    Care( String nameCare){
        this.nameCare = nameCare;
    }

    public String getNameCare() {
        return nameCare;
    }
}
