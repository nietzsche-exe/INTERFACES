package com.example.password;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.security.MessageDigest;

public class PasswordLoginController {

    @FXML
    public TextField username;
    @FXML
    public TextField password;

    private UsersPasswordData usersData;

    public PasswordLoginController() {
        this.usersData = new UsersPasswordData();
        this.usersData.initPasswordData("UsersDataStorageFile");
    }

    @FXML
    private void userPasswordLogin() {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        for (int i = 0; i < usersData.usersQuantity; i++) {
            if (enteredUsername.equals(usersData.usersPasswordsArray[i][0])) {
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA-256");
                    byte[] hash = md.digest(enteredPassword.getBytes("UTF-8"));
                    StringBuilder hexString = new StringBuilder();

                    for (int j = 0; j < hash.length; j++) {
                        String hex = Integer.toHexString(0xff & hash[j]);
                        if (hex.length() == 1) {
                            hexString.append('0');
                        }
                        hexString.append(hex);
                    }
                    String enteredPasswordHash = hexString.toString();

                    if (enteredPasswordHash.equals(usersData.usersPasswordsArray[i][1])) {
                        System.out.printf("Inicio de sesión exitoso para el usuario %s%n", enteredUsername);


                    }
                } catch (Exception e) {
                    System.out.println("Error al verificar la contraseña");

                }
            }
        }
        System.out.println("El usuario o la contraseña son incorrectos");
    }

}
