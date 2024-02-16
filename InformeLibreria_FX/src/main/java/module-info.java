module informes.libreria.informelibreria_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires jasperreports;
    requires informelibros;
    requires java.sql;
    requires jrviewer.fx;

    exports informes.libreria.informelibreria_fx;
    opens informes.libreria.informelibreria_fx to javafx.fxml;
}