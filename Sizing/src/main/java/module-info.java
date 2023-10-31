module es.ciudadescolar.sizing.sizing {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ciudadescolar.sizing.sizing to javafx.fxml;
    exports es.ciudadescolar.sizing.sizing;
}