module es.ciudadescolar.hbox_vbox.hbox_vbox {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ciudadescolar.hbox_vbox.hbox_vbox to javafx.fxml;
    exports es.ciudadescolar.hbox_vbox.hbox_vbox;
}