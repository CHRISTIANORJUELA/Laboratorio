package com.example.laboratory.controllers;

import com.example.laboratory.models.FinishLoan;
import com.example.laboratory.models.Monitor;
import com.example.laboratory.models.PayMonitors;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PayMonitorController implements Initializable, Bar4collection1 {
    @FXML
    private TextArea textTarea;



    @FXML
    private TableView<PayMonitors> tablePayMonitor;
    @FXML
    private TableColumn<PayMonitors,String> nameMonitorCl;
    @FXML
    private TableColumn<PayMonitors,String> payCl;

    private ArrayList<FinishLoan> finishLoanController = new ArrayList<>();

    private ArrayList<Monitor> monitorController = new ArrayList<>();


    ModelFactoryController mfc = ModelFactoryController.getInstance();

    public void initialize(URL url, ResourceBundle rbs){
        try {
            getArrays();
            putTable();
            nameMonitorCl.setCellValueFactory(new PropertyValueFactory("nameMonitor"));
            payCl.setCellValueFactory(new PropertyValueFactory("pay"));
        }catch (Exception event){
            System.out.println("Error al cargar los datos");
        }
    }


    private void getArrays(){
        finishLoanController = mfc.getFinishLoan();
        monitorController = mfc.returnListMonitor();

    }

    private void refreshTable(){
        ArrayList<PayMonitors> list = mfc.getListPayMonitor();
        ObservableList<PayMonitors> observableList = FXCollections.observableArrayList();
        observableList.setAll(list);
        tablePayMonitor.setItems(observableList);
        tablePayMonitor.refresh();
    }


    private void putTable(){
        if (findNotNullListController()){
            mfc.putTable(finishLoanController,monitorController);
            refreshTable();
        }
    }

    private boolean findNotNullListController(){
        if(finishLoanController.size() != 0  && monitorController.size() != 0){
            return true;
        }else {
            return false;
        }
    }


    @FXML
    void payMonitosOn(ActionEvent event) {

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
