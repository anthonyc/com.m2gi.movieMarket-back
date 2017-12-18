package com.m2gi.movieMarket.api.security.user;

import java.security.Principal;
import java.util.ArrayList;

public class User implements Principal {
    private int id;
    private String name;
    private String token;
    private ArrayList<Role> roles = new ArrayList<>();

    public User() {}

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name, Role role) {
        this.name = name;
        this.addRole(role);
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public User addRole(Role role) {
        this.roles.add(role);

        return this;
    }

    public boolean hasRole(String role) {
        for (Role apiUserRole : this.roles) {
            if (apiUserRole.hasRole(role)) {
                return true;
            }
        }

        return false;
    }

    public String getToken() {
        return this.token;
    }

    public User setToken(String token) {
        this.token = token;

        return this;
    }
}
