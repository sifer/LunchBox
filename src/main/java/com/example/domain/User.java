package com.example.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class User {

    private int UserID;
    @Size(min = 1, max = 25, message = "Vänligen skriv ett användarnamn med 1 till 25 tecken.")
    private String userName;
    @Size(min = 1, max = 20, message = "Vänligen skriv ett lösenord med 1 till 25 tecken.")
    private String password;
    @NotEmpty(message = "Vänligen fyll i e-postadress härvid.")
    @Email
    private String mail;

    public User() {

    }
    public User(String userName, String password, String mail) {
        this.userName = userName;
        this.password = password;
        this.mail = mail;
    }

    public User(int userID, String userName, String password, String mail) {
        UserID = userID;
        this.userName = userName;
        this.password = password;
        this.mail = mail;
    }


    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
