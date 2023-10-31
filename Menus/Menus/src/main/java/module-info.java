module es.ciudadescolar.menus {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ciudadescolar.menus to javafx.fxml;
    exports es.ciudadescolar.menus;
}