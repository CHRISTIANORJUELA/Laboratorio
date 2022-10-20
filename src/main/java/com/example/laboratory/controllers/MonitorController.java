package com.example.laboratory.controllers;
import com.example.laboratory.models.Monitor;
import com.example.laboratory.models.Student;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MonitorController implements Bar4collection1, Initializable {

    @FXML
    private TextField tfFilter;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfDocument;
    @FXML
    private TextField tfAge;
    @FXML
    private TextField tfantiquity;
    @FXML
    private TextField tfcoderoom;



    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnUpdate;

    @FXML
    private ChoiceBox<String> boxChoiceValues;



    @FXML
    private TableView<Monitor> tableMonitor;
    @FXML
    private TableColumn<Monitor, String> nameCL;
    @FXML
    private TableColumn<Monitor, String> documentCL;
    @FXML
    private TableColumn<Monitor, String> ageCL;
    @FXML
    private TableColumn<Monitor, String> antiquityCL;
    @FXML
    private TableColumn<Monitor, String> coderoomCL;

    ObservableList<Monitor> observableListFalse;
    ObservableList<Monitor> observableListFilterFalse;

    private String selectValues[] = {"Name", "Document", "Antiquity"};

    private ModelFactoryController mfc = ModelFactoryController.getInstance();


    public void initialize(URL url, ResourceBundle rbs){
        try {
            refreshTable();
            boxChoiceValues.getItems().addAll(selectValues);
            this.nameCL.setCellValueFactory(new PropertyValueFactory("name"));
            this.documentCL.setCellValueFactory(new PropertyValueFactory("document"));
            this.ageCL.setCellValueFactory(new PropertyValueFactory("age"));
            this.antiquityCL.setCellValueFactory(new PropertyValueFactory("antiquity"));
            this.coderoomCL.setCellValueFactory(new PropertyValueFactory("codeRoom"));

        }catch (Exception e){
            System.out.println("Error al cargar los datos");
        }

    }



    public void addTable(ActionEvent e){
        String name = tfName.getText();
        String document = tfDocument.getText();
        String age =  tfAge.getText();
        String antiquity = tfantiquity.getText();
        String codeRoom =  tfcoderoom.getText();
        if (UtilisMethods.filterEmpty1(name,document,age,antiquity,codeRoom)){
            mfc.addMonitor(name,document,age,antiquity,codeRoom);
            refreshTable();
        }
    }

    private void refreshTable() {
        ArrayList<Monitor> list = mfc.returnListMonitor();
        ObservableList<Monitor> list2 = FXCollections.observableArrayList();
        observableListFalse = FXCollections.observableArrayList();
        observableListFalse.setAll(list);
        list2.setAll(list);
        tableMonitor.setItems(list2);
        tableMonitor.refresh();
    }

    private void refreshTableFilter(){
        ArrayList<Monitor> listFilter1 = mfc.returnListMonitorFilter();
        ObservableList<Monitor> listFilter2 = FXCollections.observableArrayList();
        observableListFilterFalse = FXCollections.observableArrayList();
        observableListFilterFalse.setAll(listFilter1);
        listFilter2.setAll(listFilter1);
        tableMonitor.setItems(listFilter2);
        tableMonitor.refresh();
    }

    public void deleteTable(ActionEvent e){
        Monitor m = tableMonitor.getSelectionModel().getSelectedItem();
        if (m != null){
            mfc.deleteMonitor(m);
            refreshTable();
        }
    }

    public void clearTf(ActionEvent e){
        tfName.setText("");
        tfDocument.setText("");
        tfAge.setText("");
        tfantiquity.setText("");
        tfcoderoom.setText("");
    }

    public void clearTfFilter(ActionEvent e){
        tfFilter.setText("");
    }

    public void filter(KeyEvent e){
        String valueFilter = tfFilter.getText();
        if (valueFilter != ""){
            mfc.filterProcessMonitor(boxChoiceValues,valueFilter);
            refreshTableFilter();
        }else {
            tableMonitor.setItems(observableListFalse);
        }

    }

    public void updateTable(ActionEvent e){
       Monitor p = this.tableMonitor.getSelectionModel().getSelectedItem();
       String name = tfName.getText();
       String document = tfDocument.getText();
       String age = tfAge.getText();
       String antiquity = tfantiquity.getText();
       String coderoom = tfcoderoom.getText();
       if (p != null){
           if (UtilisMethods.filterEmpty1(name,document,age,antiquity,coderoom)){
               mfc.upDateMonitor(observableListFalse,observableListFilterFalse,p, name, document, age,antiquity, coderoom);
               refreshTable();
           }
       }else {
           System.out.println("Please select a value");
       }
    }

    public void select(MouseEvent e){
        Monitor p = this.tableMonitor.getSelectionModel().getSelectedItem();
        if (p != null){
            this.tfName.setText(p.getName());
            this.tfDocument.setText(p.getDocument());
            this.tfAge.setText(p.getAge());
            this.tfantiquity.setText(Integer.toString(p.getAntiquity()));
            this.tfcoderoom.setText(p.getCodeRoom());
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
