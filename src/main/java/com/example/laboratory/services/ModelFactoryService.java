package com.example.laboratory.services;

import com.example.laboratory.models.*;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ModelFactoryService {
     void addStudent(String name, String document, String age, String semester, String career);
     void addMonitor(String name, String document, String age, String antiquity, String codeRoom);

     void addTeacher(String name, String document, String age, String course, String codeRoom);

     void addElement(String name,String care,String material,String stock,String code);

     void deleteStudent(Student p);

     void deleteMonitor(Monitor m);

     void deleteTeacher(Teacher t);

     void searchCodeElement( TextField tfSearchElement, TextArea textArea);

     void downElement(TextField tfDownElement,TextArea textArea,Elements e);

     void upDateStudent(Student p,String name,String document,String age,String semester,String career,ObservableList<Student>observableListFalse,ObservableList<Student>observableListFilterFalse);
     void upDateMonitor(ObservableList<Monitor>observableListFalse,ObservableList<Monitor>observableListFilterFalse,Monitor p,String Name,String document,String age,String antiquity,String coderoom);

     void  upDateTeacher(Teacher p,ObservableList<Teacher>observableListFalse,String name,String document,String age,String course,String coderoom);

     void filterProcesStudent(ChoiceBox<String>boxSelectFilter,String filterName);

     void filterProcessMonitor(ChoiceBox<String> boxChoiceValues, String valueFilter);

     void filterProcessTeacher(ChoiceBox<String>choiceBoxSelect,String valueFilter);

     void addLoan(String nameManager, String namePerson, String nameElement, String stockElements, String codeLoad, String startTime,ArrayList<Student> listStudentImpl,ArrayList<Monitor> listMonitorImpl, ArrayList<Teacher> listTeacherImpl, ArrayList<Elements> elementsListImpl);

     void termidedLoan(StartLoan st, LocalDate dateFinish, ArrayList<Student>listStudentsController, ArrayList<Monitor>listMonitorController, ArrayList<Teacher> listTeacherController, ArrayList<Elements> listElementsController);

     void countNumberElementsLoans(String nameElement,ArrayList<FinishLoan>listFinishLoanController,TextArea textTarea);

     void searchInformation(String nameElement,ArrayList<FinishLoan>listFinishLoanController,TextArea textTarea);

     void countNumberLoansMonitor(ArrayList<FinishLoan>listFinishLoanController,TextArea textTarea);

     void findStudentMoreLoan(ArrayList<FinishLoan>listFinishLoanController,TextArea textTarea);

     void getTotalAmount (double amount, TextArea textArea);

     void putTable(ArrayList<FinishLoan>finishLoanController,ArrayList<Monitor> monitorController);


     ArrayList<Student> returnListStudents();

     ArrayList<Student>returnListStudentFilter();

     ArrayList<Monitor> returnListMonitor();

     ArrayList<Monitor> returnListMonitorFilter();

     ArrayList<Teacher> returnListTeacher();

     ArrayList<Teacher> returnListTeacherList();

     ArrayList<Elements> getListElemets();

     ArrayList<StartLoan> getListStarLoan();

     ArrayList<FinishLoan> getFinishLoan();

     double getTotalAmountLaboratory();


     ArrayList<PayMonitors> getListPayMonitor();


     }



