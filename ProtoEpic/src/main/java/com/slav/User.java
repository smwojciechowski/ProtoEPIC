package com.slav;

public class User {

    private String username;
    private String password; //only for testing purposes, password should not be saved as a String

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
