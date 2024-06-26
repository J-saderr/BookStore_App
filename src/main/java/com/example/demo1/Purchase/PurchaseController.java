/* Name: Vo Nguyen Thanh Thao_ITDSIU22144
 Purpose:
Initializes the controller, username, setting up initial states and loading necessary data
Help users purchasing book in the app lib with correct id
*/
package com.example.demo1.Purchase;

import com.example.demo1.Controller.MainController;
import com.example.demo1.getData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.*;
import java.util.Optional;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class PurchaseController extends MainController implements Initializable {
    @FXML
    private Button purchase_addBtn;

    @FXML
    private ComboBox<?> purchase_bookID;

    @FXML
    private ComboBox<?> purchase_bookTitle;

    @FXML
    private TableColumn<customerData, String> purchase_col_bookID;

    @FXML
    private TableColumn<customerData, String> purchase_col_bookTitle;

    @FXML
    private TableColumn<customerData, String> purchase_col_author;

    @FXML
    private TableColumn<customerData, String> purchase_col_quantity;

    @FXML
    private TableColumn<customerData, String> purchase_col_price;

    @FXML
    private AnchorPane purchase_form;

    @FXML
    private Label purchase_info_author;

    @FXML
    private Label purchase_info_bookID;

    @FXML
    private Label purchase_info_bookTitle;

    @FXML
    private Button purchase_payBtn;

    @FXML
    private Spinner<Integer> purchase_quantity;

    @FXML
    private TableView<customerData> purchase_tableView;

    @FXML
    private Label purchase_total;
    @FXML
    private Label username;

    private double totalP;
    private Statement statement;
    private int customerId;
    public void displayUsername(){
        String user = getData.username;
        user = user.substring(0, 1).toUpperCase() + user.substring(1);
        username.setText(user);
    }

    public void purchasecustomerId(){

        String sql = "SELECT MAX(customer_id) FROM customer";
        int checkCID = 0 ;
        connect = connectDb();

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if(result.next()){
                customerId = result.getInt("MAX(customer_id)");
            }

            String checkData = "SELECT MAX(customer_id) FROM customer_info";

            prepare = connect.prepareStatement(checkData);
            result = prepare.executeQuery();

            if(result.next()){
                checkCID = result.getInt("MAX(customer_id)");
            }

            if(customerId == 0){
                customerId += 1;
            }else if(checkCID == customerId){
                customerId = checkCID + 1;
            }

        }catch(Exception e){e.printStackTrace();}

    }

    public void purchaseAdd(){
        purchasecustomerId();

        String sql = "INSERT INTO customer (customer_id, book_id, title, author, quantity, price) "
                + "VALUES(?,?,?,?,?,?)";

        connect = connectDb();

        try{
            Alert alert;

            if(purchase_bookTitle.getSelectionModel().getSelectedItem() == null
                    || purchase_bookID.getSelectionModel().getSelectedItem() == null){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error message");
                alert.setHeaderText(null);
                alert.setContentText("Please choose book first");
                alert.showAndWait();
            }else{

                prepare = connect.prepareStatement(sql);
                prepare.setInt(1, customerId);
                prepare.setString(2, purchase_info_bookID.getText());
                prepare.setString(3, purchase_info_bookTitle.getText());
                prepare.setString(4, purchase_info_author.getText());
                prepare.setInt(5, qty);

                String checkData = "SELECT title, price FROM AllBook WHERE title = '"
                        +purchase_bookTitle.getSelectionModel().getSelectedItem()+"'";

                double priceD = 0;

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if(result.next()){
                    priceD = result.getDouble("price");
                }

                totalP = (qty * priceD);

                prepare.setInt(6, (int) totalP);

                prepare.executeUpdate();

                purchaseDisplayTotal();
                purchaseShowCustomerListData();
            }
        }catch(Exception e){e.printStackTrace();}
    }

    public void purchasePay(){

        String sql = "INSERT INTO customer_info (customer_id, total) "
                + "VALUES(?,?)";

        connect = connectDb();

        try{
            Alert alert;
            if(displayTotal == 0){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid :3");
                alert.showAndWait();
            }else{
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option = alert.showAndWait();

                if(option.get().equals(ButtonType.OK)){
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, String.valueOf(customerId));
                    prepare.setString(2, String.valueOf(displayTotal));

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successful!");
                    alert.showAndWait();

                    purchase_info_bookID.setText("");
                    purchase_info_bookTitle.setText("");
                    purchase_info_author.setText("");

                    purchaseShowCustomerListData();
                    purchaseDisplayTotal();
                }
            }
        }catch(Exception e){e.printStackTrace();}

    }

    private double displayTotal;
    public void purchaseDisplayTotal(){
        purchasecustomerId();

        String sql = "SELECT SUM(price) FROM customer WHERE customer_id = '"+customerId+"'";

        connect = connectDb();

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if(result.next()){
                displayTotal = result.getDouble("SUM(price)");
            }

            purchase_total.setText("$" + String.valueOf(displayTotal));

        }catch(Exception e){e.printStackTrace();}

    }

    public void purchaseBookId(){

        String sql = "SELECT book_id FROM AllBook";

        connect = connectDb();

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while(result.next()){
                listData.add(result.getString("book_id"));
            }

            purchase_bookID.setItems(listData);
            purchaseBookTitle();
        }catch(Exception e){e.printStackTrace();}

    }

    public void purchaseBookTitle(){

        String sql = "SELECT book_id, title FROM AllBook WHERE book_id = '"
                +purchase_bookID.getSelectionModel().getSelectedItem()+"'";

        connect = connectDb();

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while(result.next()){
                listData.add(result.getString("title"));
            }

            purchase_bookTitle.setItems(listData);

            purchaseBookInfo();

        }catch(Exception e){e.printStackTrace();}

    }

    public void purchaseBookInfo(){

        String sql = "SELECT * FROM AllBook WHERE title = '"
                +purchase_bookTitle.getSelectionModel().getSelectedItem()+"'";

        connect = connectDb();

        String bookId = "";
        String title = "";
        String author = "";

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if(result.next()){
                bookId = result.getString("book_id");
                title = result.getString("title");
                author = result.getString("author");
            }

            purchase_info_bookID.setText(bookId);
            purchase_info_bookTitle.setText(title);
            purchase_info_author.setText(author);

        }catch(Exception e){e.printStackTrace();}

    }

    public ObservableList<customerData> purchaseListData(){
        purchasecustomerId();
        String sql = "SELECT * FROM customer WHERE customer_id = '"+customerId+"'";

        ObservableList<customerData> listData = FXCollections.observableArrayList();

        connect = connectDb();

        try{
            prepare  = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            customerData customerD;

            while(result.next()){
                customerD = new customerData(result.getInt("customer_id")
                        , result.getInt("book_id")
                        , result.getString("title")
                        , result.getString("author")
                        , result.getInt("quantity")
                        , result.getDouble("price"));

                listData.add(customerD);
            }

        }catch(Exception e){e.printStackTrace();}
        return listData;
    }

    private ObservableList<customerData> purchaseCustomerList;
    public void purchaseShowCustomerListData(){
        purchaseCustomerList = purchaseListData();

        purchase_col_bookID.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        purchase_col_bookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        purchase_col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        purchase_col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        purchase_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));

        purchase_tableView.setItems(purchaseCustomerList);

    }

    private SpinnerValueFactory<Integer> spinner;

    public void purchaseDisplayQTY(){
        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        purchase_quantity.setValueFactory(spinner);
    }
    private int qty;
    public void purhcaseQty(){
        qty = (int) purchase_quantity.getValue();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        purchaseBookId();
        purchaseBookTitle();
        purchaseShowCustomerListData();
        purchaseDisplayQTY();
        purchaseDisplayTotal();
        displayUsername();
    }

    public void purchaseDel(ActionEvent actionEvent) {
        String bookIdToDelete = purchase_info_bookID.getText();

        if (bookIdToDelete.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select a book to delete.");
            alert.showAndWait();
            return;
        }

        String sql = "DELETE FROM customer WHERE book_id = ?";

        connect = connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, bookIdToDelete);
            prepare.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Book ID: " + bookIdToDelete + " successfully deleted!");
            alert.showAndWait();

            purchase_info_bookID.setText("");
            purchase_info_bookTitle.setText("");
            purchase_info_author.setText("");

            purchaseShowCustomerListData();
            purchaseDisplayTotal();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error deleting the book.");
            alert.showAndWait();
        }
    }
}
