package com.example.demo1.Book;

import com.example.demo1.MainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReadingController extends MainController implements Initializable {
    @FXML
    private HBox MyReadingContainer;

    List<Book> MyReading;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MyReading = new ArrayList<>(getMyReading());

        for (Book book : MyReading) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo1/Book.fxml"));

            try {
                VBox vBox = fxmlLoader.load();
                BookController bookController = fxmlLoader.getController();
                bookController.setData(book);

                MyReadingContainer.getChildren().add(vBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private List<Book> getMyReading() {
        List<Book> RD = new ArrayList<>();

        Book Book = new Book();
        Book.setTitle("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao-dai-so-dan-brown.jpg");
        RD.add(Book);
        return RD;
    }
}
