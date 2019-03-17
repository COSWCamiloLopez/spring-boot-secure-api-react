package com.eci.cosw.springbootsecureapi.model;

import java.util.Random;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
public class User {

    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String username;


    public User() {
    }

    public User(String username, String email, String password, String firstName, String lastName) {
        this.id = (long) 12356;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email='" + email + '\'' + ", password='" + password + '\'' + ", firstName='"
                + firstName + '\'' + '}';
    }
}
