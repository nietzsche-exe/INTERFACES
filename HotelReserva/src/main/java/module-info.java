module es.ciudadescolar.hotelreserva {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires jasperreports;
    requires java.sql;
    requires jrviewer.fx;
    requires javahelp;


    opens es.ciudadescolar.hotelreserva to javafx.fxml;
    exports es.ciudadescolar.hotelreserva;
}