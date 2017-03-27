package com.example.domain;

/**
 * Created by Administrator on 2017-03-09.
 */
public class UserSignUp { //
    public final String firstname;
    public final String lastname;
    public final int phonenumber;
    public final String mail;
    public final String username;
    public final String password;


    public UserSignUp(String firstname, String lastname, Integer phonenumber, String mail, String username, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.mail = mail;
        this.username = username;
        this.password = password;
    }
}
