package com.example.password;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PasswordLoginApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PasswordRegistryApplication.class.getResource("password-login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 400);
        stage.setTitle("SECPLUS Password Login");
        stage.setScene(scene);
        stage.show();
    }
}
