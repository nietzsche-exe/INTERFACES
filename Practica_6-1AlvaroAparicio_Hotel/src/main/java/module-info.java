module informes.hotel.practica_61alvaroaparicio_hotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires jasperreports;
    requires java.sql;
    requires jrviewer.fx;
    requires javafx.swing;

    opens informes.hotel to javafx.fxml;
    exports informes.hotel;
}