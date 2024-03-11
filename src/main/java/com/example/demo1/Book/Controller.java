package com.example.demo1.Book;

import com.example.demo1.Book.Book;
import com.example.demo1.Book.BookController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private HBox recentlyReadingContainer;

    @FXML
    private HBox favoriteContainer;

    List<Book> recentlyReading;
    List<Book> favorites;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyReading = new ArrayList<>(getrecentlyReading());
        favorites = new ArrayList<>(getFavorites());

//        try {
        for (Book book : recentlyReading) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo1/Book.fxml"));

            try {
                VBox vBox = fxmlLoader.load();
                BookController bookController = fxmlLoader.getController();
                bookController.setData(book);

                recentlyReadingContainer.getChildren().add(vBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Book book : favorites) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo1/Book.fxml"));

            try {
                VBox vBox = fxmlLoader.load();
                BookController bookController = fxmlLoader.getController();
                bookController.setData(book);

                favoriteContainer.getChildren().add(vBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Book> getrecentlyReading() {
        List<Book> RD = new ArrayList<>();

        Book Book = new Book();
        Book.setName("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);

        Book = new Book();
        Book.setName("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);

        Book = new Book();
        Book.setName("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);

        return RD;
    }
    public List<Book> getFavorites(){
        List<Book> RD = new ArrayList<>();

        Book Book = new Book();
        Book.setName("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);

        Book = new Book();
        Book.setName("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);

        Book = new Book();
        Book.setName("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);

        return RD;
    }
    public void swichtoHome(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/Home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToLogin(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

