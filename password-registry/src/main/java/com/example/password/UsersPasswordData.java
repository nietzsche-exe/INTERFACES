package com.example.password;

import java.io.*;
import java.security.MessageDigest;

public class UsersPasswordData implements Serializable {

    public static final int MAX_USERS_QUANTITY = 10;
    public String[][] usersPasswordsArray;
    private int usersQuantity;
    public String dataFilename;


    public void initPasswordData(String filename, boolean loadFromFile) {


        dataFilename = filename;
        /**
         this.usersPasswordsArray = new String[MAX_USERS_QUANTITY][2];
         this.usersQuantity = 0;
         **/
        if(loadFromFile) {
            UsersPasswordData data = this.deserializeData(dataFilename);
            this.usersPasswordsArray = data.usersPasswordsArray;
            this. usersQuantity = data.usersQuantity;
        }
        else {
            this.usersPasswordsArray = new String[MAX_USERS_QUANTITY][2];
            this.usersQuantity = 0;
        }

    }

    public boolean addUserPasswordsData(String username, String password) {

        if (usersQuantity==MAX_USERS_QUANTITY){
            System.out.printf("Max number of users (%d) reached%n", MAX_USERS_QUANTITY);
            return false;
        }

        String passwordHash;

        try {
            final MessageDigest md = MessageDigest.getInstance("SHA-256");
            final byte[] hash = md.digest(password.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            passwordHash = hexString.toString();
        }
        catch(Exception e) {
            System.out.printf("Error hashing password: %s%n");
            passwordHash = "Error hashing password";
            return false;
        }

        this.usersPasswordsArray[usersQuantity][0] = username;
        this.usersPasswordsArray[usersQuantity][1] = passwordHash;
        usersQuantity++;

        if (this.serializeData(dataFilename)) {
            System.out.printf("User %s CORRECTLY registered.%n", username);
        }
        else {
            System.out.printf("User %s not correctly registered.%n", username);
        }

        return true;
    }

    private boolean serializeData(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        }
        catch(Exception e) {
            return false;
        }

        return true;
    }

    private UsersPasswordData deserializeData(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            UsersPasswordData data = (UsersPasswordData) in.readObject();
            in.close();
            fileIn.close();

            System.out.printf("Fichero %s encontrado y cargado con %d usuarios.%n", filename, data.usersQuantity);

            return data;
        }
        catch(Exception e) {
            UsersPasswordData dataEmpty = new UsersPasswordData();
            dataEmpty.usersPasswordsArray = new String[MAX_USERS_QUANTITY][2];
            dataEmpty.usersQuantity = 0;

            System.out.printf("Fichero %s no encontrado. No se han cargado usuarios.%n", filename);

            return dataEmpty;
        }
    }

    public int getUsersQuantity() {
        return usersQuantity;
    }

    public String getUser(int index) {
        return usersPasswordsArray[index][0];
    }

    public String getPassword(int index) {
        return usersPasswordsArray[index][1];
    }



}
