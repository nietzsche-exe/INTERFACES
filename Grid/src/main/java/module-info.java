module com.juanagui.di.grid {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.juanagui.di.grid to javafx.fxml;
    exports com.juanagui.di.grid;
}