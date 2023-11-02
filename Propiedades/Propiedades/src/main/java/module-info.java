module es.ciudadescolar.propiedades {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ciudadescolar.propiedades to javafx.fxml;
    exports es.ciudadescolar.propiedades;
}