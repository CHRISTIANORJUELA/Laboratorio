package com.example.laboratory.services;
import com.example.laboratory.models.Student;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public interface StudentService {
    void addStudent(String name, String document, String age, String semester, String career);

    void upDateStudent(Student p,String name,String document,String age,String semester,String career,ObservableList<Student>observableListFalse,ObservableList<Student>observableListFilterFalse);

    void deleteStudent(Student p);

    ArrayList<Student> returnListStudents();

    ArrayList<Student>returnListStudentFilter();
}
