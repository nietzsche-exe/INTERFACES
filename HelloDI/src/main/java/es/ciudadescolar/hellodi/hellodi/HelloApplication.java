package es.ciudadescolar.hellodi.hellodi;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
      VBox root = new VBox();
        Platform.setImplicitExit(false);

        Label label = new Label("Welcome to JavaFX Application");
        Button button = new Button("Hello!");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label.setText("Welcome to JavaFX Application");
            }
        });

        Button closeButton = new Button("close");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });

        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}