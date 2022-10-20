package com.example.laboratory.controllers;

import com.example.laboratory.models.FinishLoan;
import com.example.laboratory.utils.Bar4collection1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InformationController implements Initializable, Bar4collection1 {
    @FXML
    private TextArea textTarea;

    @FXML
    private TextField tfSerach;

    @FXML
    private TextField tfNumberElements;

    @FXML
    private ArrayList<FinishLoan> listFinishLoanController = new ArrayList<>();



    ModelFactoryController mfc = ModelFactoryController.getInstance();

    public void initialize(URL url, ResourceBundle rbs){
        try {
            getFinishLoans();
            System.out.println(listFinishLoanController.get(0).getNameManagerString());
        }catch (Exception event){
            System.out.println("Error al cargar los datos");
        }
    }




    public void getFinishLoans(){
        listFinishLoanController = mfc.getFinishLoan();
    }
    @FXML
    void numberElementsLoans(ActionEvent event) {
        String nameElement = tfNumberElements.getText();
        if (!nameElement.isEmpty() && findNot0ListController()){
            mfc.countNumberElementsLoans(nameElement,listFinishLoanController,textTarea);
        }
    }

    @FXML
    void numberLoansMonitor(ActionEvent event) {
        if (findNot0ListController()){
            mfc.countNumberLoansMonitor(listFinishLoanController,textTarea);
        }
    }

    @FXML
    void search(ActionEvent event) {
        String nameElement = tfSerach.getText();
        if (!nameElement.isEmpty() && findNot0ListController()){
            mfc.searchInformation(nameElement,listFinishLoanController,textTarea);
        }
    }

    @FXML
    void studentMoreLoan(ActionEvent event) {
        if (findNot0ListController()){
            mfc.findStudentMoreLoan(listFinishLoanController,textTarea);
        }
    }

    @FXML
    void totalAmount(ActionEvent event) {
        if (findNot0ListController()){
            mfc.getTotalAmount(mfc.getTotalAmountLaboratory(), textTarea);
        }
    }

    private boolean findNot0ListController(){
        if(listFinishLoanController.size() != 0){
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
