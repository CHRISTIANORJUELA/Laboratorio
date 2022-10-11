package com.example.laboratory.models;

public class aa {
    private String name;
    private String document;
    private String age;
    private String semester;
    private String career;

    public aa(String name,String document, String age, String semester, String career) {
        this.name = name;
        this.document = document;
        this.age = age;
        this.semester = semester;
        this.career = career;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
