package com.example.demo1.Book;

import com.example.demo1.Login.getData;
import com.example.demo1.MainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller extends MainController implements Initializable {


    @FXML
    private HBox recentlyReadingContainer;

    @FXML
    private HBox favoriteContainer;
    @FXML
    private Label username;

    List<Book> recentlyReading;
    List<Book> favorites;
    public void displayUsername(){
        String user = getData.username;
        user = user.substring(0, 1).toUpperCase() + user.substring(1);
        username.setText(user);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyReading = new ArrayList<>(getrecentlyReading());
        favorites = new ArrayList<>(getFavorites());
        displayUsername();

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
        Book.setTitle("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);

        Book = new Book();
        Book.setTitle("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);

        Book = new Book();
        Book.setTitle("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);

        return RD;
    }
    public List<Book> getFavorites(){
        List<Book> RD = new ArrayList<>();

        Book Book = new Book();
        Book.setTitle("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);

        Book = new Book();
        Book.setTitle("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);

        Book = new Book();
        Book.setTitle("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);

        return RD;
    }
}

