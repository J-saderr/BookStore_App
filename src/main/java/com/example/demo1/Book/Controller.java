package com.example.demo1.Book;

import com.example.demo1.Book.Book;
import com.example.demo1.Book.BookController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

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

        try {
            for (Book Book : recentlyReading) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Book.fxml"));

                VBox vBox = fxmlLoader.load();
                BookController BookController = fxmlLoader.getController();
                BookController.setData(Book);

                recentlyReadingContainer.getChildren().add(vBox);
            }

//            for (Book Book : favorites) {
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource("Book.fxml"));
//
//                VBox vBox = fxmlLoader.load();
//                BookController BookController = fxmlLoader.getController();
//                BookController.setData(Book);
//
//                favoriteContainer.getChildren().add(vBox);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Book> getrecentlyReading() {
        List<Book> RD = new ArrayList<>();

        Book Book = new Book();
        Book.setName("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);

        return RD;
    }
    public List<Book> getFavorites(){
        List<Book> RD = new ArrayList<>();

        return RD;
    }
}

