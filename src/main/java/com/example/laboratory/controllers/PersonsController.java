package com.example.laboratory.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PersonsController {
    private Stage stage;
    private Scene scene;

    private Parent root;

    public void sendStudent(ActionEvent e) throws IOException {
        URL url= new File("src/main/resources/com/example/laboratory/Persons/student.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = root.getScene();
        this.stage.setScene(this.scene);
        this.stage.show();
    }



    public void sendMonitor(ActionEvent e) throws IOException{
        URL url= new File("src/main/resources/com/example/laboratory/Persons/monitor.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = root.getScene();
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void sendTeacher(ActionEvent e) throws IOException{
        URL url= new File("src/main/resources/com/example/laboratory/Persons/teacher.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = root.getScene();
        this.stage.setScene(this.scene);
        this.stage.show();
    }





}
