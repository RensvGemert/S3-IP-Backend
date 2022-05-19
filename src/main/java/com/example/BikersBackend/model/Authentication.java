package com.example.BikersBackend.model;

public class Authentication {
    public String email;
    public String password;

    public Authentication(String email, String password) {
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "Authentication{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
