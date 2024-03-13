package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
    private Stage stage;
    private Scene scene;
    public void switchToHome(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/Home.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToLogin(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/Login.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTopBooks(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/Search.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToReading(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/Reading.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPurchase(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/Purchase.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
