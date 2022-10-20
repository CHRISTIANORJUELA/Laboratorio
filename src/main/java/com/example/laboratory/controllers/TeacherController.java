package com.example.laboratory.controllers;
import com.example.laboratory.models.Student;
import com.example.laboratory.models.Teacher;
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

public class TeacherController implements Bar4collection1 , Initializable {

    @FXML
    private TextField tfFilter;
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
    private ChoiceBox<String> choiceBoxSelect;

    private String valuesSelect[] = {"Name", "Document", "CodeRoom"};

    @FXML
    private TableView<Teacher> tableTeacher;
    @FXML
    private TableColumn<Teacher, String> nameCL;
    @FXML
    private TableColumn<Teacher, String> documentCL;
    @FXML
    private TableColumn<Teacher, String> ageCL;
    @FXML
    private TableColumn<Teacher, String> courseCL;
    @FXML
    private TableColumn<Teacher, String> coderoomCL;


    ObservableList<Teacher> observableListFalse;
    ObservableList<Teacher> observableListFilterFalse;

    private ModelFactoryController mfc = ModelFactoryController.getInstance();


    public void initialize(URL url, ResourceBundle rbs){
        try {
            refreshTable();
            choiceBoxSelect.getItems().addAll(valuesSelect);
            this.nameCL.setCellValueFactory(new PropertyValueFactory("name"));
            this.documentCL.setCellValueFactory(new PropertyValueFactory("document"));
            this.ageCL.setCellValueFactory(new PropertyValueFactory("age"));
            this.courseCL.setCellValueFactory(new PropertyValueFactory("course"));
            this.coderoomCL.setCellValueFactory(new PropertyValueFactory("codeRoom"));
        }catch (Exception e){
            System.out.println("Error al cargar los datos");
        }

    }

    private void refreshTable() {
        ArrayList<Teacher> list = mfc.returnListTeacher();
        ObservableList<Teacher> list2 = FXCollections.observableArrayList();
        observableListFalse = FXCollections.observableArrayList();
        observableListFalse.setAll(list);
        list2.setAll(list);
        tableTeacher.setItems(list2);
        tableTeacher.refresh();
    }

    private void refreshTableFilter(){
        ArrayList<Teacher> listFilter1 = mfc.returnListTeacherList();
        ObservableList<Teacher> listFilter2 = FXCollections.observableArrayList();
        observableListFilterFalse = FXCollections.observableArrayList();
        observableListFilterFalse.setAll(listFilter1);
        listFilter2.setAll(listFilter1);
        tableTeacher.setItems(listFilter2);
        tableTeacher.refresh();
    }
    public void addTable(ActionEvent e){
        String name = tfName.getText();
        String document = tfDocument.getText();
        String age =  tfAge.getText();
        String course = tfCourse.getText();
        String codeRoom =  tfcoderoom.getText();
        if (UtilisMethods.filterEmpty1(name,document,age,course,codeRoom)){
            mfc.addTeacher(name, document, age, course, codeRoom);
            refreshTable();
        }
    }

    public void deleteTable(ActionEvent e){
        Teacher t = tableTeacher.getSelectionModel().getSelectedItem();
        if (t != null){
          mfc.deleteTeacher(t);
          refreshTable();
        }
    }


    public void updateTable(ActionEvent e){
       Teacher p = tableTeacher.getSelectionModel().getSelectedItem();
       String name = tfName.getText();
       String document = tfDocument.getText();
       String age = tfAge.getText();
       String course = tfCourse.getText();
       String coderoom = tfcoderoom.getText();
       if (p != null && UtilisMethods.filterEmpty1(name,document,age,course,coderoom)){
           mfc.upDateTeacher(p,observableListFalse,name,document,age,course,coderoom);
           refreshTable();
       }
    }
    public void select(MouseEvent e){
        Teacher t = tableTeacher.getSelectionModel().getSelectedItem();
        if (t != null){
            tfName.setText(t.getName());
            tfDocument.setText(t.getDocument());
            tfAge.setText(t.getAge());
            tfCourse.setText(t.getCourse());
            tfcoderoom.setText(t.getCodeRoom());
        }
    }

    public void filter(KeyEvent e){
        String valueFilter = tfFilter.getText();
        if (valueFilter != ""){
            mfc.filterProcessTeacher(choiceBoxSelect,valueFilter);
            refreshTableFilter();
        }else {
            tableTeacher.setItems(observableListFalse);
        }
    }

    public void clearTfFilter(){
        tfFilter.setText("");
    }

    public void clearTf(ActionEvent e){
        tfName.setText("");
        tfDocument.setText("");
        tfAge.setText("");
        tfCourse.setText("");
        tfcoderoom.setText("");
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
