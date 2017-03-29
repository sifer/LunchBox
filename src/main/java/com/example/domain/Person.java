package com.example.domain;

/**
 * Created by Administrator on 2017-03-09.
 */
public class Person {
    //
    private int personId;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person(int personId, String firstName, String lastName, String phoneNumber) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Person() {

    }
    public int getPersonId() {return personId;}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {return phoneNumber;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
