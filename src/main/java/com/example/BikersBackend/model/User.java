package com.example.BikersBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "userTable")
public class User {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    @Column(unique = true)
    public String email;
    public String password;
    public boolean is_admin;

    public User() {
    }

    public User(Integer id, String name, String email, String password, boolean is_admin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, boolean is_admin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", is_admin=" + is_admin +
                '}';
    }
}
