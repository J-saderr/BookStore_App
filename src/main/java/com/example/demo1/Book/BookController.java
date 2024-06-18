package com.example.demo1.Book;

import com.example.demo1.Book.Book;
import com.example.demo1.getData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.InputStream;

public class BookController {

    @FXML
    private ImageView img;

    @FXML
    private Label bookName;

    @FXML
    private Label author;

    private Book myBook;

    @FXML
    public Button Path;

    public void setData(Book Books){
        try {
            myBook = Books;
            InputStream inputStream = getClass().getResourceAsStream(Books.getImage());
            System.out .println(myBook.getImage());
            if (inputStream != null) {
                Image image = new Image(inputStream);
                img.setImage(image);
            } else {
                System.err.println("Image not found: " + Books.getImage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading image: " + e.getMessage());
        }

        bookName.setText(Books.getTitle());
        author.setText(Books.getAuthor());

    }
    public void GoToBook(ActionEvent event) {
        try {
            String path = myBook.getPath();
            getData.Bookid = myBook.getBookId();
            getData.Bookname = myBook.getTitle();
            getData.detailChapter0= myBook.getChapter0();
            getData.detailChapter1= myBook.getChapter1();
            getData.detailChapter2= myBook.getChapter2();
            getData.detailChapter3= myBook.getChapter3();
            getData.detailChapter4= myBook.getChapter4();
            getData.detailChapter5= myBook.getChapter5();
            getData.description =myBook.getDescription();

            if (path != null && !path.isEmpty()) {
                Parent root = FXMLLoader.load(getClass().getResource(path));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Book path is null or empty.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error switching to Book scene: " + e.getMessage());
        }
    }
}
