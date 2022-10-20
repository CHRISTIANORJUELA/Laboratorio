package com.example.laboratory.utils;

public enum Material {
    ALUMINIUM("aluminium"),
    IRON("iron"),

    PLASTIC("plastic");


    private String nameMaterial;

    Material(String nameMaterial){
        this.nameMaterial = nameMaterial;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }
}
