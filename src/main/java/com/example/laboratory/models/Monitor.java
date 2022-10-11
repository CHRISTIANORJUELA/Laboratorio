package com.example.laboratory.models;

public class Monitor extends Person{
    private int antiquity;
    private String codeRoom;

    public Monitor(String name, String document, String age, int antiquity, String codeRoom) {
        super(name, document, age);
        this.antiquity = antiquity;
        this.codeRoom = codeRoom;
    }

    public int getAntiquity() {
        return antiquity;
    }

    public void setAntiquity(int antiquity) {
        this.antiquity = antiquity;
    }

    public String getCodeRoom() {
        return codeRoom;
    }

    public void setCodeRoom(String codeRoom) {
        this.codeRoom = codeRoom;
    }
}
