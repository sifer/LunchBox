package com.example.domain;

public class User {
    private int UserID;
    private String userName;
    private String password;
    private String mail;

    public User() {

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
