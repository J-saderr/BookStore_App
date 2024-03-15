package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo1/Login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1000, 800);
        stage.setTitle("BookStore!");
        stage.setScene(scene);
        stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}