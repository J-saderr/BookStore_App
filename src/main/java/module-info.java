module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
    exports com.example.demo1.Book;
    opens com.example.demo1.Book to javafx.fxml;
    exports com.example.demo1.Login;
    opens com.example.demo1.Login to javafx.fxml;
}