package com.example.laboratory.models;

public class Person {
  private String name;
  private String document;
  private String age;

    public Person(String name, String document, String age) {
        this.name = name;
        this.document = document;
        this.age = age;
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
}
