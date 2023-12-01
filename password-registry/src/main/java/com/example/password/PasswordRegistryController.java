package com.example.password;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;
import java.security.MessageDigest;


public class PasswordRegistryController {

    private static final int PASSWORD_MIN_LENGTH = 5;

    private final BooleanProperty _disabled;
    @FXML
    public TextField username;
    @FXML
    public TextField password;
    @FXML
    public TextField retype;

    private final UsersPasswordData usersData;

    private final String usersDataFilename = "UsersDataStorageFile";

    public PasswordRegistryController() {
        _disabled = new SimpleBooleanProperty(true);
        usersData = new UsersPasswordData();
        usersData.initPasswordData(usersDataFilename);
    }

    public void initialize() {
        /* usando la API fluida */
        _disabled.bind(
                password.textProperty().isEmpty()
                        .or(username.textProperty().isEmpty())
                        .or(password.textProperty().length().lessThan(PASSWORD_MIN_LENGTH))
                        .or(retype.textProperty().isNotEqualTo(password.textProperty())));

    }

    public boolean userPasswordRegistry () {
        /** UsersPasswordsData usersData = new UsersPasswordsData(); **/
        if(usersData.addUserPasswordsData(username.textProperty().getValue(), password.textProperty().getValue())) {
            System.out.printf("User %s registered with password %s%n", username.textProperty().getValue(), password.textProperty().getValue());
            return true;
        }
        return false;
    }

    public BooleanProperty disabledProperty() {
        return _disabled;
    }

    public Boolean getDisabled() {
        return _disabled.getValue();
    }

    public void setDisabled(Boolean value) {
        _disabled.setValue(value);
    }

}