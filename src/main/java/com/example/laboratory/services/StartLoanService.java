package com.example.laboratory.services;

import com.example.laboratory.controllers.MonitorController;
import com.example.laboratory.controllers.StudentController;
import com.example.laboratory.controllers.TeacherController;
import com.example.laboratory.models.*;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.util.ArrayList;

public interface StartLoanService {


   void  addLoan(String nameManager, String namePerson, String nameElement, String stockElements, String codeLoad, String startTime, ArrayList<Student> listStudentImpl, ArrayList<Monitor> listMonitorImpl, ArrayList<Teacher> listTeacherImpl, ArrayList<Elements> elementsListImpl);

   void termidedLoan(StartLoan st, LocalDate dateFinish, ArrayList<Student>listStudentsController, ArrayList<Monitor>listMonitorController, ArrayList<Teacher> listTeacherController, ArrayList<Elements> listElementsController);
   ArrayList<StartLoan> getListStarLoan();

   ArrayList<FinishLoan> getFinishLoan();
}
