package es.ciudadescolar.hotelreserva;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Clase principal para la aplicación de generación de informes del hotel.
 * @version 1.0
 * @since 2023-2024
 * @author Jose Julian Saavedra
 */
public class ReportApplication extends Application {

    /**
     * Método principal para iniciar la aplicación.
     * @param stage El escenario principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ReportApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 800);
        stage.setTitle("Informe Hotel");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método principal de la aplicación.
     * @param args Los argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        launch();
    }
}