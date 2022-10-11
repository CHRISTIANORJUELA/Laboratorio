package com.example.laboratory.controllers;

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

public class TeacherController implements Bar4collection1, Initializable {
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
    private TextField tfCourse;
    @FXML
    private TextField tfcoderoom;



    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnFind;

    @FXML
    private Button btnUpdate;


    @FXML
    private TableView<aa> tableTeacher;
    @FXML
    private TableColumn nameCL;
    @FXML
    private TableColumn documentCL;
    @FXML
    private TableColumn ageCL;
    @FXML
    private TableColumn courseCL;
    @FXML
    private TableColumn coderoomCL;

    ObservableList<aa> teachers;

    private int positionTable;

    private ModelFactoryController mfc = ModelFactoryController.getInstance();


    public void initialize(URL url, ResourceBundle rbs){
        try {
            teachers = FXCollections.observableArrayList();
            this.nameCL = new TableColumn<aa, String>("Name");
            this.nameCL.setCellValueFactory(new PropertyValueFactory<aa,String>("name"));
            this.documentCL = new TableColumn<aa, String>("Document");
            this.documentCL.setCellValueFactory(new PropertyValueFactory<aa,String>("document"));
            this.ageCL = new TableColumn<aa, String>("Age");
            this.ageCL.setCellValueFactory(new PropertyValueFactory<aa,String>("age"));
            this.courseCL = new TableColumn<aa, String>("Semester");
            this.courseCL.setCellValueFactory(new PropertyValueFactory<aa,String>("semester"));
            coderoomCL = new TableColumn<aa, String>("Career");
            this.coderoomCL.setCellValueFactory(new PropertyValueFactory<aa,String>("career"));
        }catch (Exception e){
            System.out.println("Error al cargar los datos");
        }

    }
    public void addTable(ActionEvent e){

    }

    public void deleteTable(ActionEvent e){

    }

    public void findTable(ActionEvent e){

    }

    public void updateTable(ActionEvent e){

    }
}
