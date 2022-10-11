package com.example.laboratory.services;

import com.example.laboratory.models.aa;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public interface StudentService {
    void addStudent(String name, String document, String age, String semester, String career, ObservableList<aa> students, TableView<aa> tableStudent);
}
