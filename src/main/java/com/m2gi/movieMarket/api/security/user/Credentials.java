package com.m2gi.movieMarket.api.security.user;

import java.io.Serializable;

public class Credentials implements Serializable {
    private String login;
    private String password;

    public String getLogin() {
        return this.login;
    }

    public Credentials setLogin(String login) {
        this.login = login;

        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public Credentials setPassword(String password) {
        this.password = password;

        return this;
    }
}
