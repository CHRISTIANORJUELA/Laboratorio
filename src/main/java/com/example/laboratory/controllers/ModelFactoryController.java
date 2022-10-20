package com.example.laboratory.controllers;

import com.example.laboratory.models.*;
import com.example.laboratory.services.ModelFactoryService;
import com.example.laboratory.services.impl.Laboratory;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelFactoryController implements ModelFactoryService {

    Laboratory laboratory;

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        laboratory = new Laboratory();
    }
/*******************************************************************************************************/


   @Override
    public void addStudent(String name, String document, String age, String semester, String career){
        laboratory.getStudentImpl().addStudent(name,document,age,semester,career);
    }

    public void addMonitor(String name, String document, String age, String antiquity, String codeRoom){
       laboratory.getMonitorServiceImpl().addMonitor(name, document, age, antiquity, codeRoom);
    }

    public void addTeacher(String name, String document, String age, String course, String codeRoom){
       laboratory.getTeacherServiceImpl().addTeacher(name, document, age, course, codeRoom);
    }

    public void addElement(String name, String care, String material, String stock, String code){
       laboratory.getElementsServiceImpl().addElement(name,care,material,stock,code);
    }

    public void deleteStudent(Student p){
       laboratory.getStudentImpl().deleteStudent(p);
    }

    public void deleteMonitor(Monitor m){laboratory.getMonitorServiceImpl().deleteMonitor(m);}

    public void deleteTeacher(Teacher t){laboratory.getTeacherServiceImpl().deleteTeacher(t);}

    public void searchCodeElement(TextField tfSearchElement, TextArea textArea){
       laboratory.getElementsServiceImpl().searchCodeElement(tfSearchElement,textArea);
    }

    public void downElement(TextField tfDownElement,TextArea textArea,Elements e){
        laboratory.getElementsServiceImpl().downElement(tfDownElement,textArea,e);
    }

    public void upDateStudent(Student p,String name,String document,String age,String semester,String career,ObservableList<Student>observableListFalse,ObservableList<Student>observableListFilterFalse){
       laboratory.getStudentImpl().upDateStudent(p,name,document,age,semester,career,observableListFalse,observableListFilterFalse);
    }

    public void  upDateMonitor(ObservableList<Monitor>observableListFalse,ObservableList<Monitor>observableListFilterFalse,Monitor p,String name,String document,String age,String antiquity,String coderoom){
       laboratory.getMonitorServiceImpl().upDateMonitor(observableListFalse,observableListFilterFalse,p, name, document, age,antiquity, coderoom);
    }

    public void  upDateTeacher(Teacher p,ObservableList<Teacher>observableListFalse,String name,String document,String age,String course,String coderoom){
       laboratory.getTeacherServiceImpl().upDateTeacher( p,observableListFalse, name, document, age, course,coderoom);
    }

    public void filterProcessMonitor(ChoiceBox<String> boxChoiceValues, String valueFilter){
        laboratory.getMonitorServiceImpl().filterProcessMonitor(boxChoiceValues,valueFilter);
    }

    public void filterProcesStudent(ChoiceBox<String> boxSelectFilter,String filterName){
       laboratory.getStudentImpl().filterProcesStudent(boxSelectFilter,filterName);
    }


    public void filterProcessTeacher(ChoiceBox<String>choiceBoxSelect,String valueFilter){
       laboratory.getTeacherServiceImpl().filterProcessTeacher(choiceBoxSelect,valueFilter);
    }

    public void addLoan(String nameManager, String namePerson, String nameElement, String stockElements, String codeLoad, String startTime,ArrayList<Student> listStudentImpl,ArrayList<Monitor> listMonitorImpl, ArrayList<Teacher> listTeacherImpl, ArrayList<Elements> listElementsImpl){
       laboratory.getStartLoanImpl().addLoan( nameManager, namePerson, nameElement, stockElements,codeLoad, startTime,listStudentImpl,listMonitorImpl,listTeacherImpl,listElementsImpl);
    }

    public void termidedLoan(StartLoan st, LocalDate dateFinish, ArrayList<Student>listStudentsController, ArrayList<Monitor>listMonitorController,ArrayList<Teacher> listTeacherController,ArrayList<Elements> listElementsController){
       laboratory.getStartLoanImpl().termidedLoan(st,dateFinish,listStudentsController,listMonitorController,listTeacherController,listElementsController);
    }


   public  ArrayList<Monitor> returnListMonitor(){
       return laboratory.getMonitorServiceImpl().getListMonitors();
   }

   public ArrayList<Monitor> returnListMonitorFilter(){
       return laboratory.getMonitorServiceImpl().getListMonitorsFilter();
   }

    public ArrayList<Student> returnListStudents(){
        return laboratory.getStudentImpl().returnListStudents();
    }


    public  ArrayList<Student>returnListStudentFilter(){
       return laboratory.getStudentImpl().returnListStudentFilter();
   }

   public void countNumberElementsLoans(String nameElement,ArrayList<FinishLoan>listFinishLoanController,TextArea textTarea){
        laboratory.getInformationServiceImpl().countNumberElementsLoans(nameElement,listFinishLoanController,textTarea);
   }

   public void searchInformation(String nameElement,ArrayList<FinishLoan>listFinishLoanController,TextArea textTarea){
       laboratory.getInformationServiceImpl().searchInformation(nameElement,listFinishLoanController,textTarea);
   }

    public void countNumberLoansMonitor(ArrayList<FinishLoan>listFinishLoanController,TextArea textTarea){
       laboratory.getInformationServiceImpl().countNumberLoansMonitor(listFinishLoanController,textTarea);
    }

    public void findStudentMoreLoan(ArrayList<FinishLoan>listFinishLoanController,TextArea textTarea){
       laboratory.getInformationServiceImpl().findStudentMoreLoan(listFinishLoanController,textTarea);
    }

    public void putTable(ArrayList<FinishLoan>finishLoanController,ArrayList<Monitor> monitorController){
       laboratory.getPayMonitorService().putTable(finishLoanController,monitorController);
    }
    public ArrayList<Teacher> returnListTeacher() {
        return laboratory.getTeacherServiceImpl().getListTeacher();
    }

    public ArrayList<Teacher> returnListTeacherList() {
        return laboratory.getTeacherServiceImpl().getFilterListTeacher();
    }

    public void getTotalAmount (double amount, TextArea textArea){
       laboratory.getInformationServiceImpl().getTotalAmount(amount,textArea);
    }

    public ArrayList<Elements> getListElemets(){
       return  laboratory.getElementsServiceImpl().getListElemets();
    }

    public ArrayList<StartLoan> getListStarLoan(){
       return laboratory.getStartLoanImpl().getListStarLoan();
    }

    public ArrayList<FinishLoan> getFinishLoan(){return  laboratory.getStartLoanImpl().getFinishLoan();}

    public ArrayList<PayMonitors> getListPayMonitor(){return laboratory.getPayMonitorService().getListPayMonitor();}

    public double getTotalAmountLaboratory(){return laboratory.getStartLoanImpl().getTotalamount();}
}
