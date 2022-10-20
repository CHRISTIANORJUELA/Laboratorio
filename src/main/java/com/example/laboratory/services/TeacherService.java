package com.example.laboratory.services;

import com.example.laboratory.models.Teacher;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public interface TeacherService {
    void addTeacher(String name, String document, String age, String course, String codeRoom);

    void  upDateTeacher(Teacher p,ObservableList<Teacher>observableListFalse,String name,String document,String age,String course,String coderoom);

    void filterProcessTeacher(ChoiceBox<String>choiceBoxSelect,String valueFilter);

    void deleteTeacher(Teacher t);


    ArrayList<Teacher> getListTeacher();

    ArrayList<Teacher> getFilterListTeacher();
}
