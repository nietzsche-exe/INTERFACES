package com.example.password;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

public class Testscases {

    private static String filename = "TEST_UsersDataStorageFile";
    private static String rightUsername = "Pablo";
    private static String rightPassword = "12345";
    @Test
    @DisplayName("Prueba de ejemplo")
    public void testPrueba() {
        assertTrue(true);
        assertEquals("frase", "frase");
    }

    @Test
    @DisplayName("Prueba de registro de usuario")
    public void testRegistroUsuario() {
        UsersPasswordData usersData = new UsersPasswordData();
        usersData.initPasswordData(filename, false);
        assertTrue(usersData.addUserPasswordsData(rightUsername, rightPassword));


        UsersPasswordData usersData2 = new UsersPasswordData();
        usersData2.initPasswordData(filename, true);
        assertEquals(usersData.getUsersQuantity(), usersData2.getUsersQuantity());

        assertEquals(1, usersData2.getUsersQuantity());
    }


    @Test
    @DisplayName("Prueba de inicio de sesión")
    public void testUsersValidation() {
        UsersPasswordData usersData = new UsersPasswordData();
        usersData.initPasswordData(filename, false);
        usersData.addUserPasswordsData(rightUsername, rightPassword);

        UsersPasswordData usersData2 = new UsersPasswordData();
        usersData2.initPasswordData(filename, true);

        String user = usersData.getUser(0);
        String password = usersData.getContra(0);

        String rightPasswordHash;
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(rightPassword.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            rightPasswordHash = hexString.toString();

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        assertEquals(rightUsername, user);
        assertEquals(rightPasswordHash, password);
    }

}
