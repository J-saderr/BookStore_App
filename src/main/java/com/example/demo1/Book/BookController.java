package com.example.demo1.Book;

import com.example.demo1.Book.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BookController {

    @FXML
    private ImageView img;

    @FXML
    private Label bookName;

    @FXML
    private Label author;

    public void setData(Book book){
        Image image = new Image(getClass().getResourceAsStream(book.getImage()));
        img.setImage(image);
        bookName.setText(book.getName());
        author.setText(book.getAuthor());
    }
}
