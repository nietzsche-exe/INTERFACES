module es.ciudadescolar.hellodi.hellodi {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ciudadescolar.hellodi.hellodi to javafx.fxml;
    exports es.ciudadescolar.hellodi.hellodi;
}