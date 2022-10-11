package com.example.laboratory.controllers;


import com.example.laboratory.models.aa;
import com.example.laboratory.services.ModelFactoryService;
import com.example.laboratory.services.impl.Laboratory;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;


public class ModelFactoryController implements ModelFactoryService {

    Laboratory laboratory;


    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        laboratory = new Laboratory();
    }
/*******************************************************************************************************/

   @Override
    public void addStudent(String name, String document, String age, String semester, String career, ObservableList<aa> students, TableView<aa> tableStudent){
        laboratory.getStudentImpl().addStudent(name,document,age,semester,career,students,tableStudent);
    }


}
