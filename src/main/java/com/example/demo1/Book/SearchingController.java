package com.example.demo1.Book;

import com.example.demo1.MainController;
import com.example.demo1.getData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SearchingController extends MainController implements Initializable {
    @FXML
    private TableColumn<Book, String> availableBooks_col_bookID;

    @FXML
    private TableColumn<Book, String> availableBooks_col_bookTItle;

    @FXML
    private TableColumn<Book, String> availableBooks_col_author;

    @FXML
    private TableColumn<Book, String> availableBooks_col_price;

    @FXML
    private TextField availableBooks_search;

    @FXML
    private TableView<Book> availableBooks_tableView;
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private static Connection connectDb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "pass"); // address, database username, database password
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }

    public ObservableList<Book> availableBooksListData(){

        ObservableList<Book> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM book";

        connect = connectDb();

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            Book bookD;

            while(result.next()){
                bookD = new Book(result.getInt("book_id"), result.getString("title")
                        , result.getString("author"), result.getDouble("price"));

                listData.add(bookD);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }

    private ObservableList<Book> availableBooksList;
    public void availableBooksShowListData(){
        availableBooksList = availableBooksListData();

        availableBooks_col_bookID.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        availableBooks_col_bookTItle.setCellValueFactory(new PropertyValueFactory<>("title"));
        availableBooks_col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        availableBooks_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));

        availableBooks_tableView.setItems(availableBooksList);
    }

    public void availableBooksSeach(){

        FilteredList<Book> filter = new FilteredList<>(availableBooksList, e -> true);

        availableBooks_search.textProperty().addListener((Observable, oldValue, newValue) ->{

            filter.setPredicate(predicateBook -> {

                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if(predicateBook.getBookId().toString().contains(searchKey)){
                    return true;
                }else if(predicateBook.getTitle().toLowerCase().contains(searchKey)){
                    return true;
                }else if(predicateBook.getAuthor().toLowerCase().contains(searchKey)){
                    return true;
                }else if(String.valueOf(predicateBook.getPrice()).contains(searchKey)){
                    return true;
                }else return false;
            });
        });

        SortedList<Book> sortList = new SortedList(filter);
        sortList.comparatorProperty().bind(availableBooks_tableView.comparatorProperty());
        availableBooks_tableView.setItems(sortList);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        availableBooksShowListData();
        availableBooksSeach();
    }
}
