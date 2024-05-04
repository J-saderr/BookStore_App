module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.jfoenix;

    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
    exports com.example.demo1.Book;
    opens com.example.demo1.Book to javafx.fxml;
    exports com.example.demo1.Login;
    opens com.example.demo1.Login to javafx.fxml;
    exports com.example.demo1.Purchase;
    opens com.example.demo1.Purchase to javafx.fxml;
    exports com.example.demo1.Controller;
    opens com.example.demo1.Controller to javafx.fxml;
}