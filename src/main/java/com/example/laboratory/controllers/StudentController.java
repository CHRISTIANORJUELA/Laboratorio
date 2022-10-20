package com.example.laboratory.controllers;

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


public class StudentController  implements Bar4collection1 , Initializable {

    @FXML
    private TextField tfFilter;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfDocument;
    @FXML
    private TextField tfAge;
    @FXML
    private TextField tfSemester;
    @FXML
    private TextField tfCareer;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnFind;

    @FXML
    private Button btnUpdate;

    @FXML
    private ChoiceBox<String> boxSelectFilter;

    private String filters[] = {"Name", "Document", "Age"};



    @FXML
    private TableView<Student> tableStudent;
    @FXML
    private TableColumn<Student, String> nameCL;
    @FXML
    private TableColumn<Student, String> documentCL;
    @FXML
    private TableColumn<Student, String> ageCL;
    @FXML
    private TableColumn<Student, String> semesterCL;
    @FXML
    private TableColumn<Student, String> careerCL;

    private ObservableList<Student> observableListFalse;

    private ObservableList<Student> observableListFilterFalse;

     private ModelFactoryController mfc = ModelFactoryController.getInstance();


    public void initialize(URL url, ResourceBundle rbs){
        try {
            refreshTable();
            boxSelectFilter.getItems().addAll(filters);
            this.nameCL.setCellValueFactory(new PropertyValueFactory("name"));
            this.documentCL.setCellValueFactory(new PropertyValueFactory("document"));
            this.ageCL.setCellValueFactory(new PropertyValueFactory("age"));
            this.semesterCL.setCellValueFactory(new PropertyValueFactory("semester"));
            this.careerCL.setCellValueFactory(new PropertyValueFactory("career"));
        }catch (Exception event){
            System.out.println("Error al cargar los datos");
        }
    }



    @FXML
    public void addTable(ActionEvent e){
        String name = tfName.getText();
        String document = tfDocument.getText();
        String age =  tfAge.getText();
        String semester = tfSemester.getText();
        String career =  tfCareer.getText();
        if (UtilisMethods.filterEmpty1(name,document,age,semester,career)){
            mfc.addStudent(name,document,age,semester,career);
            refreshTable();
        }
    }


    @FXML
    public void deleteTable(ActionEvent e){
      Student p = this.tableStudent.getSelectionModel().getSelectedItem();
      if (p != null){
          mfc.deleteStudent(p);
          refreshTable();
      }
    }



    public void Filter(KeyEvent e){
        String filterName = this.tfFilter.getText();
        if (filterName != null){
            mfc.filterProcesStudent(boxSelectFilter,filterName);
            refreshTableFilter();
        }else {
           tableStudent.setItems(observableListFalse);
        }
    }


    @FXML
    public void updateTable(ActionEvent e){
        Student p = this.tableStudent.getSelectionModel().getSelectedItem();
        String name = tfName.getText();
        String document = tfDocument.getText();
        String age = tfAge.getText();
        String semester = tfSemester.getText();
        String career = tfCareer.getText();
        if (p != null && UtilisMethods.filterEmpty1(name,document,age,semester,career)){
            mfc.upDateStudent(p,name,document,age,semester,career,observableListFalse,observableListFilterFalse);
            refreshTable();
        } else if (p == null) {
            System.out.println("Pleasee Select a value");
        }
    }



    public void select(MouseEvent e){
        Student p = this.tableStudent.getSelectionModel().getSelectedItem();
        if(p != null){
            this.tfName.setText(p.getName());
            this.tfDocument.setText(p.getDocument());
            this.tfAge.setText(p.getAge());
            this.tfCareer.setText(p.getCareer());
            this.tfSemester.setText(p.getSemester());
        }
    }


    public void clearSelectFilter(ActionEvent e){
        tfFilter.clear();
    }

    public void clearTfs(ActionEvent e){
         tfName.clear();
         tfDocument.clear();
         tfAge.clear();
         tfSemester.clear();
         tfCareer.clear();
    }



        private void refreshTable() {
            ArrayList<Student> list = mfc.returnListStudents();
            ObservableList<Student> list2 = FXCollections.observableArrayList();
            observableListFalse = FXCollections.observableArrayList();
            observableListFalse.setAll(list);
            list2.setAll(list);
            tableStudent.setItems(list2);
            tableStudent.refresh();
        }

        private void refreshTableFilter(){
           ArrayList<Student> listFilter1 = mfc.returnListStudentFilter();
           ObservableList<Student> listFilter2 = FXCollections.observableArrayList();
           observableListFilterFalse = FXCollections.observableArrayList();
           observableListFilterFalse.setAll(listFilter1);
           listFilter2.setAll(listFilter1);
           tableStudent.setItems(listFilter2);
           tableStudent.refresh();
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
