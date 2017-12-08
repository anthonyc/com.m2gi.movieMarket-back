package com.m2gi.movieMarket.domain.entity.person;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.Column;
import javax.persistence.Entity;
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
        return this.email;
    }

    public User setEmail(String email) {
        this.email = email;

        return this;
    }

    public boolean checkPassword(String password) {
        //String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        System.out.println(this.password);
        return BCrypt.checkpw(password, this.password);
    }

    public User setPassword(String password) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

        this.password = hashed;

        return this;
    }
}
