package com.example.laboratory.models;

public class ElementTest {
    private String nameElement;
    private String cant;

    public ElementTest(String nameElement, String cant) {
        this.nameElement = nameElement;
        this.cant = cant;
    }

    public String getNameElement() {
        return nameElement;
    }

    public void setNameElement(String nameElement) {
        this.nameElement = nameElement;
    }

    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }
}
