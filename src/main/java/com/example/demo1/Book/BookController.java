package com.example.demo1.Book;

import com.example.demo1.Book.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class BookController {

    @FXML
    private ImageView img;

    @FXML
    private Label bookName;

    @FXML
    private Label author;

    public void setData(Book book){
        try {
            InputStream inputStream = getClass().getResourceAsStream(book.getImage());

            if (inputStream != null) {
                Image image = new Image(inputStream);
                img.setImage(image);
            } else {
                System.err.println("Image not found: " + book.getImage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading image: " + e.getMessage());
        }

        bookName.setText(book.getName());
        author.setText(book.getAuthor());
    }
}
