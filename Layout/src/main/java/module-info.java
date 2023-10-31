module es.ciudadescolar.layout.layout {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ciudadescolar.layout.layout to javafx.fxml;
    exports es.ciudadescolar.layout.layout;
}