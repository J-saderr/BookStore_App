/* Name: Vo Nguyen Thanh Thao_ITDSIU22144
 Purpose:
Display the recentlyReading and available lists by calling getrecentlyReading and getAvailable, respectively, and then displays the username by calling displayUsername
*/
package com.example.demo1.Controller;

import com.example.demo1.Book.Book;
import com.example.demo1.Book.BookController;
import com.example.demo1.Controller.MainController;
import com.example.demo1.getData;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController extends MainController implements Initializable {


    @FXML
    private HBox recentlyReadingContainer;

    @FXML
    private HBox availableContainer;
    @FXML
    private Label username;

    List<Book> recentlyReading;
    List<Book> available;
    public void displayUsername(){
        String user = getData.username;
        user = user.substring(0, 1).toUpperCase() + user.substring(1);
        username.setText(user);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recentlyReading = new ArrayList<>(getrecentlyReading());
        available = new ArrayList<>(getAvailable());
        displayUsername();

        for (Book book : recentlyReading) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo1/Book.fxml"));

            try {
                AnchorPane vBox = fxmlLoader.load();
                BookController bookController = fxmlLoader.getController();
                bookController.setData(book);
                recentlyReadingContainer.getChildren().add(vBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Book book : available) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo1/Book.fxml"));

            try {
                AnchorPane vBox = fxmlLoader.load();
                BookController bookController = fxmlLoader.getController();
                bookController.setData(book);

                availableContainer.getChildren().add(vBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Book> getrecentlyReading() {
        List<Book> RD = FXCollections.observableArrayList();

        String sql = "SELECT * FROM book";

        connect = connectDb();

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            Book bookD;

            while(result.next()){
                bookD = new Book(result.getInt("book_id")
                        , result.getString("title")
                        , result.getString("author")
                        , result.getString("image")
                        , result.getString("path")
                        , result.getString("chapter0")
                        , result.getString("chapter1")
                        , result.getString("chapter2")
                        , result.getString("chapter3")
                        , result.getString("chapter4")
                        , result.getString("chapter5")
                        , result.getString("description"));

                RD.add(bookD);
            }
        }catch(Exception e){e.printStackTrace();}

        return RD;
    }
    public List<Book> getAvailable(){
        List<Book> RD = new ArrayList<>();

        Book Book = new Book();
        Book.setTitle("Pháo Đài Số");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/phao_dai_so.png");
        RD.add(Book);

        Book = new Book();
        Book.setTitle("Thay Đổi Tí Hon Hiệu Quả Bất Ngờ");
        Book.setAuthor("James Clear");
        Book.setImage("/com/example/drawable/Automic-habits.jpg");
        RD.add(Book);

        Book = new Book();
        Book.setTitle("Hoả Ngục");
        Book.setAuthor("Dan Brown");
        Book.setImage("/com/example/drawable/hoa-nguc-dan-brown.jpeg");
        RD.add(Book);

        Book = new Book();
        Book.setTitle("Bầu Trời Trong Trẻo");
        Book.setAuthor("Tái Kiến Đông Lưu");
        Book.setImage("/com/example/drawable/Bau-troi-trong-treo.jpg");
        RD.add(Book);

        return RD;
    }
}

