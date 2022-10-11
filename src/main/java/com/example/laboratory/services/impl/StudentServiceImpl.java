package com.example.laboratory.services.impl;


import com.example.laboratory.models.aa;
import com.example.laboratory.services.StudentService;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class StudentServiceImpl implements StudentService {

    public void addStudent(String name, String document, String age, String semester, String career, ObservableList<aa> students, TableView<aa> tableStudent){
        System.out.println("Entro");
        aa p = new aa(name,document,age,semester,career);
        if (!students.contains(p)){
            students.add(p);
            System.out.println(students.get(0).getName());
            tableStudent.setItems(students);
            System.out.println(tableStudent.getItems().get(0).getName());
        }
    }
}
