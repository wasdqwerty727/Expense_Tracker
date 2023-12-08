module com.example.demo15 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demo15 to javafx.fxml;
    exports com.example.demo15;
}