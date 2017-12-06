package com.m2gi.movieMarket.domain.entity.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
public class User extends Person implements Serializable {
    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public String getUsername() {
        return this.username;
    }

    public User setUsername(String username) {
        this.username = username;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;

        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;

        return this;
    }
}
