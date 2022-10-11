package com.example.laboratory.models;

public class Teacher extends Person{
    String course;
    String codeRoom;

    public Teacher(String name, String document, String age, String course, String codeRoom) {
        super(name, document, age);
        this.course = course;
        this.codeRoom = codeRoom;
    }
}
