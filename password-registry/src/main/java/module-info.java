module com.example.password {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.password to javafx.fxml;
    exports com.example.password;
}