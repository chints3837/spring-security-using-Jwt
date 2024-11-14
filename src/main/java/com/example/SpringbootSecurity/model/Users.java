package com.example.SpringbootSecurity.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;


    @Column(name = "username")
    private String username;


    @Column(name = "password")
    private String password;

    public Users() {
    }

    public Users(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
