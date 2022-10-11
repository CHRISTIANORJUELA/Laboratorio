package com.example.laboratory.models;

public class Student extends Person{
    private String semester;
    private String career;

    public Student(String name, String document, String age, String semester, String career) {
        super(name, document, age);
        this.semester = semester;
        this.career = career;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
