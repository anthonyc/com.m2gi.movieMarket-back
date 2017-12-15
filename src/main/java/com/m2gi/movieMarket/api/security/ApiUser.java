package com.m2gi.movieMarket.api.security;

import java.security.Principal;
import java.util.ArrayList;

public class ApiUser implements Principal {
    private int id;
    private String name;
    private ArrayList<Role> roles = new ArrayList<>();

    public ApiUser() {}

    public ApiUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ApiUser(String name, Role role) {
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

    public ApiUser addRole(Role role) {
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
}
