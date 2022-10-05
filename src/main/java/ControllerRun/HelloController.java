package ControllerRun;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.scene.Parent;
import javafx.scene.Node;

public class HelloController {
    private Stage stage;


    public void sendMainPersons(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("viewsPersons/Persons.fxml"));
        Scene scene = new Scene(root, 300, 400);
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        this.stage.setScene(scene);
        this.stage.show();
    }
    public void sendMainLoad(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("viewsLoad/loadMain.fxml"));
        Scene scene = new Scene(root, 300, 400);
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        this.stage.setScene(scene);
        this.stage.show();
    }
}