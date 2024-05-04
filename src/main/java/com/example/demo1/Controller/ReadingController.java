package com.example.demo1.Controller;

import com.example.demo1.Book.Book;
import com.example.demo1.Book.BookController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

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
                AnchorPane vBox = fxmlLoader.load();
                BookController bookController = fxmlLoader.getController();
                bookController.setData(book);

                MyReadingContainer.getChildren().add(vBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private List<Book> getMyReading() {
        List<Book> RD = FXCollections.observableArrayList();

        String sql = "SELECT * FROM book";

        connect = connectDb();

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            Book bookD;

            while(result.next()){
                bookD = new Book(result.getString("title")
                        , result.getString("author"), result.getString("image") );

                RD.add(bookD);
            }
        }catch(Exception e){e.printStackTrace();}

        return RD;
    }
}
