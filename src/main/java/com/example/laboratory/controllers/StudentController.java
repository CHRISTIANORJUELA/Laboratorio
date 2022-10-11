package com.example.laboratory.controllers;

import com.example.laboratory.models.Student;
import com.example.laboratory.models.aa;
import com.example.laboratory.utils.Bar4collection1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class StudentController  implements Bar4collection1 , Initializable {

   /* @FXML
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
    private TableView<Student> tableStudent;
    @FXML
    private TableColumn nameCL = new TableColumn<Student, String>();
    @FXML
    private TableColumn documentCL = new TableColumn<Student, String>();
    @FXML
    private TableColumn ageCL = new TableColumn<Student, String>();
    @FXML
    private TableColumn semesterCL = new TableColumn<Student, String>();
    @FXML
    private TableColumn careerCL = new TableColumn<Student, String>();

    ObservableList<Student> students = FXCollections.observableArrayList();

    private int positionTable;


    public void initialize(URL url, ResourceBundle rbs){
        try {
            nameCL.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
            documentCL.setCellValueFactory(new PropertyValueFactory<Student,String>("document"));
            ageCL.setCellValueFactory(new PropertyValueFactory<Student,String>("age"));
            semesterCL.setCellValueFactory(new PropertyValueFactory<Student,String>("semester"));
            careerCL.setCellValueFactory(new PropertyValueFactory<Student,String>("career"));
        }catch (Exception e){
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

        Student p = new Student(name,document,age,semester,career);

        if (!this.students.contains(p)){
            this.students.add(p);
            System.out.println(students.get(0).getName());
            this.tableStudent.setItems(students);
            System.out.println(tableStudent.getItems().get(0).getName());
        }


    }

    */

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

    public void sendLoad(ActionEvent e) throws IOException{
        URL url= new File("src/main/resources/com/example/laboratory/Load/startLoad.fxml").toURI().toURL();
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
    private TableView<aa> tableStudent;
    @FXML
    private TableColumn nameCL;
    @FXML
    private TableColumn documentCL;
    @FXML
    private TableColumn ageCL;
    @FXML
    private TableColumn semesterCL;
    @FXML
    private TableColumn careerCL;

    ObservableList<aa> students;

    private int positionTable;

     private ModelFactoryController mfc = ModelFactoryController.getInstance();


    public void initialize(URL url, ResourceBundle rbs){
        try {
            students = FXCollections.observableArrayList();
            this.nameCL = new TableColumn<aa, String>("Name");
            this.nameCL.setCellValueFactory(new PropertyValueFactory<aa,String>("name"));
            this.documentCL = new TableColumn<aa, String>("Document");
            this.documentCL.setCellValueFactory(new PropertyValueFactory<aa,String>("document"));
            this.ageCL = new TableColumn<aa, String>("Age");
            this.ageCL.setCellValueFactory(new PropertyValueFactory<aa,String>("age"));
            this.semesterCL = new TableColumn<aa, String>("Semester");
            this.semesterCL.setCellValueFactory(new PropertyValueFactory<aa,String>("semester"));
            careerCL = new TableColumn<aa, String>("Career");
            this.careerCL.setCellValueFactory(new PropertyValueFactory<aa,String>("career"));
        }catch (Exception e){
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
        if ((!name.isEmpty() && !document.isEmpty()) && (!age.isEmpty() && !semester.isEmpty()) && !career.isEmpty()){
            mfc.addStudent(name,document,age,semester,career,students,tableStudent);
        }


        /*aa p = new aa(name,document,age,semester,career);

        if (!this.students.contains(p)){
            this.students.add(p);
            System.out.println(students.get(0).getName());
            this.tableStudent.setItems(students);
            System.out.println(tableStudent.getItems().get(0).getName());
            mfc.addStudent();
        }

         */


    }


    @FXML
    public void deleteTable(ActionEvent e){

    }



    @FXML
    public void findTable(ActionEvent e){

    }


    @FXML
    public void updateTable(ActionEvent e){

    }

}
