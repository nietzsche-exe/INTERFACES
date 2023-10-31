module es.ciudadescolar.form {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ciudadescolar.form to javafx.fxml;
    exports es.ciudadescolar.form;
}