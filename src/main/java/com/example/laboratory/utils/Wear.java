package com.example.laboratory.utils;

public enum Wear {

    WEAR10(10,"Good conditions"),
    WEAR20(2,"Good conditions"),
    WEAR30(10,"Good conditions"),
    WEAR40(10,"Good conditions"),
    WEAR50(10,"Regular conditions"),
    WEAR60(10,"Regular conditions"),
    WEAR70(10,"Regular conditions"),
    WEAR80(10,"No good conditions"),
    WEAR90(10,"No good conditions"),
    WEAR95(10,"No good conditions");


    private int wearPercentage;
    private String conditions;

     Wear(int wearPercentage, String conditions){
        this.wearPercentage = wearPercentage;
        this.conditions = conditions;
    }



}
