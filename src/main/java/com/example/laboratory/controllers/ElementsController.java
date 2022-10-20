package com.example.laboratory.controllers;

import com.example.laboratory.models.Elements;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ElementsController implements Initializable , Bar4collection1 {

    @FXML
    private TableColumn<Elements,String> nameCl;
    @FXML
    private TableColumn<Elements,String> materialCl;

    @FXML
    private TableColumn<Elements,String> careCl;

    @FXML
    private TableColumn<Elements,String> stockCl;

    @FXML
    private TableColumn<Elements,String> codeCl;

    @FXML
    private TableColumn<Elements,String> statusCl;

    @FXML
    private ChoiceBox<String> chCare;

    @FXML
    private ChoiceBox<String> chMaterial;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField tfCode;

    @FXML
    private TextField tfDownElement;

    @FXML
    private TextField tfFindLoan;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfSearchElement;

    @FXML
    private TextField tfStock;


    @FXML
    private TableView<Elements> tableViewElements;

    private ObservableList<Elements> observableListFalse;

    private String careValues[] = {"Dont wet", "Handle with care", "Without care"};
    private String materialValues[] = {"Aluminium", "Iron", "Plastic",};


    ModelFactoryController mfc = ModelFactoryController.getInstance();


    public void initialize(URL url, ResourceBundle rbs){
        refreshTable();
       chCare.getItems().addAll(careValues);
       chMaterial.getItems().addAll(materialValues);
       nameCl.setCellValueFactory(new PropertyValueFactory("name"));
       materialCl.setCellValueFactory(new PropertyValueFactory("material"));
       careCl.setCellValueFactory(new PropertyValueFactory("care"));
       stockCl.setCellValueFactory(new PropertyValueFactory("stock"));
       codeCl.setCellValueFactory(new PropertyValueFactory("code"));
       statusCl.setCellValueFactory(new PropertyValueFactory("status"));
    }

    @FXML
    public void addElement(ActionEvent event) {
       String name =tfName.getText();
       String care = UtilisMethods.getValueBox(chCare);
       String material = UtilisMethods.getValueBox(chMaterial);
       String stock = tfStock.getText();
       String code = tfCode.getText();
       if (UtilisMethods.filterEmpty1(name,care,material,stock,code)){
           mfc.addElement(name,care,material,stock,code);
           refreshTable();
       }
    }


    @FXML
    public void btnDownElement(ActionEvent event) {
        Elements e = tableViewElements.getSelectionModel().getSelectedItem();
        if (tfDownElement.getText() != "" && e != null){
            mfc.downElement(tfDownElement,textArea,e);
            refreshTable();
        }else {
            System.out.println("Please select a value or dont erase input of Down element");
        }
    }

    private void refreshTable() {
        ArrayList<Elements> list = mfc.getListElemets();
        ObservableList<Elements> list2 = FXCollections.observableArrayList();
        observableListFalse = FXCollections.observableArrayList();
        observableListFalse.setAll(list);
        list2.setAll(list);
        tableViewElements.setItems(list2);
        tableViewElements.refresh();
    }
    @FXML
    public void btnFindLoan(ActionEvent event) {

    }

    public void select(MouseEvent e){
        Elements el = tableViewElements.getSelectionModel().getSelectedItem();
        if (el != null){
            tfDownElement.setText(el.getName());
        }
    }

    @FXML
    public void btnSearchElement(ActionEvent event) {
       mfc.searchCodeElement(tfSearchElement,textArea);
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
