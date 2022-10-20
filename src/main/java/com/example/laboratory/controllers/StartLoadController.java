package com.example.laboratory.controllers;

import com.example.laboratory.models.*;
import com.example.laboratory.utils.Bar4collection1;
import com.example.laboratory.utils.UtilisMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StartLoadController implements Bar4collection1 , Initializable{

    @FXML
    private ChoiceBox<String> cboxSelect;

    @FXML
    private TableColumn<StartLoan, String> dayLoanCL;

    @FXML
    private TableColumn<StartLoan, String> nameManagerCL;

    @FXML
    private TableColumn<StartLoan, String> nameTypeManager;

    @FXML
    private TableColumn<StartLoan, String> nameTypePerson;

    @FXML
    private TableColumn<StartLoan, String>nameCodeLoanCL;

    @FXML
    private TableColumn<StartLoan, String> nameElementCL;

    @FXML
    private TableColumn<StartLoan,String> namePersonCL;

    @FXML
    private TableColumn<StartLoan, String> stockCL;

    @FXML
    private Button resetTfSearch;

    @FXML
    private TableView<StartLoan> tableLoan;

    @FXML
    private TextField tfCodeElement;

    @FXML
    private TextField tfDayLoan;

    @FXML
    private TextField tfNameManager;

    @FXML
    private TextField tfNameElement;

    @FXML
    private TextField tfNamePerson;

    @FXML
    private TextField tfSearch;

    @FXML
    private TextField tfFinishLoan;

    @FXML
    private TextField tfStockElement;

    ObservableList<StartLoan> observableListFalse;
    ObservableList<StartLoan> observableListFilterFalse;
    ArrayList<Student> listStudentsController = new ArrayList<>();
    ArrayList<Monitor> listMonitorController = new ArrayList<>();
    ArrayList<Teacher> listTeacherController = new ArrayList<>();
    ArrayList<Elements> listElementsController = new ArrayList<>();

    private ModelFactoryController mfc = ModelFactoryController.getInstance();


    public void initialize(URL url, ResourceBundle rbs){
        try {
            getArrayLists();
            refreshTable();
            nameManagerCL.setCellValueFactory(new PropertyValueFactory("nameManagerString"));
            nameTypeManager.setCellValueFactory(new PropertyValueFactory("nameTypeManager"));
            namePersonCL.setCellValueFactory(new PropertyValueFactory("namePersonString"));
            nameTypePerson.setCellValueFactory(new PropertyValueFactory("nameTypePerson"));
            nameElementCL.setCellValueFactory(new PropertyValueFactory("nameElement"));
            stockCL.setCellValueFactory(new PropertyValueFactory("stockElements"));
            nameCodeLoanCL.setCellValueFactory(new PropertyValueFactory("codeLoad"));
            dayLoanCL.setCellValueFactory(new PropertyValueFactory("startTime"));
        }catch (Exception e){

        }
    }

    public void getArrayLists(){
        listStudentsController = mfc.returnListStudents();
        listMonitorController = mfc.returnListMonitor();
        listTeacherController = mfc.returnListTeacher();
        listElementsController = mfc.getListElemets();
    }

    private void refreshTable() {
        ArrayList<StartLoan> list = mfc.getListStarLoan();
        ObservableList<StartLoan> list2 = FXCollections.observableArrayList();
        observableListFalse = FXCollections.observableArrayList();
        observableListFalse.setAll(list);
        list2.setAll(list);
        tableLoan.setItems(list2);
        tableLoan.refresh();
    }

    private void refreshTableFilter(){
        ArrayList<StartLoan> listFilter1 = mfc.getListStarLoan();
        ObservableList<StartLoan> listFilter2 = FXCollections.observableArrayList();
        observableListFilterFalse = FXCollections.observableArrayList();
        observableListFilterFalse.setAll(listFilter1);
        listFilter2.setAll(listFilter1);
        tableLoan.setItems(listFilter2);
        tableLoan.refresh();
    }

    @FXML
    public void addLoan(ActionEvent event) {
        String nameManager = tfNameManager.getText();
        String namePerson =tfNamePerson.getText();
        String nameElement = tfNameElement.getText();
        String stockElemets = tfStockElement.getText();
        String codeLoad = tfCodeElement.getText();
        String startTime = tfDayLoan.getText();
        if (findNotNullListController() && UtilisMethods.filterEmpty2(nameManager,namePerson,nameElement,stockElemets,codeLoad,startTime)){
            mfc.addLoan(nameManager,namePerson,nameElement,stockElemets,codeLoad,startTime,listStudentsController,listMonitorController,listTeacherController,listElementsController);
            refreshTable();
        }else {
            System.out.println("Please enter all values");
        }
    }

    @FXML
    void updateLoan(ActionEvent event) {

    }
    @FXML
    void clearTf(ActionEvent event) {
         tfNameManager.setText("");
         tfNamePerson.setText("");
         tfNameElement.setText("");
         tfStockElement.setText("");
         tfCodeElement.setText("");
         tfDayLoan.setText("");
    }

    @FXML
    void deleteLoan(ActionEvent event) {

    }

    @FXML
    void filterValues(KeyEvent event) {

    }

    @FXML
    void finishLoan(ActionEvent event) {
        StartLoan st = tableLoan.getSelectionModel().getSelectedItem();
        LocalDate dateFinish = castDate(tfFinishLoan.getText());
        if (findNotNullListController() && st != null && dateFinish != null){
            mfc.termidedLoan(st,dateFinish,listStudentsController,listMonitorController,listTeacherController,listElementsController);
            refreshTable();
        }else {
            System.out.println("Please enter all values");
        }
    }

    public LocalDate castDate(String tfFinishLoan){
        try {
            return LocalDate.parse(tfFinishLoan);
        }catch (Exception e){
            System.out.println("Incorrect date entered");
        }
        return null;
    }

    @FXML
    void select(MouseEvent event) {
        StartLoan m = tableLoan.getSelectionModel().getSelectedItem();
        if (m != null){

        }
    }



    private boolean findNotNullListController(){
        if(listStudentsController.size() != 0  && listMonitorController.size() != 0 && listTeacherController.size() != 0 && listElementsController.size() != 0){
            return true;
        }else {
            return false;
        }
    }

    private Stage stage;
    private Scene scene;


    public void sendPersons(ActionEvent e) throws IOException {
        URL url= new File("src/main/resources/com/example/laboratory/Persons/persons.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = root.getScene();
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void sendLoan(ActionEvent e) throws IOException{
        URL url= new File("src/main/resources/com/example/laboratory/Loan/startLoan.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = root.getScene();
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void sendPayMonitor(ActionEvent e)throws IOException{
        URL url= new File("src/main/resources/com/example/laboratory/PayMonitor/cashMonitor.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = root.getScene();
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void sendInformation(ActionEvent e) throws IOException{
        URL url= new File("src/main/resources/com/example/laboratory/Information/information.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = root.getScene();
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void sendElements(ActionEvent e)throws  IOException{
        URL url= new File("src/main/resources/com/example/laboratory/Elements/elements.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = root.getScene();
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
