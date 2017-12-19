package com.m2gi.movieMarket.api.JWT;

import com.m2gi.movieMarket.api.security.user.Role;

import java.util.ArrayList;

public class JwtSubject {
    private int id;
    private String username;
    private ArrayList<Role> roles = new ArrayList<Role>();

    public JwtSubject() {}
    public JwtSubject(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public JwtSubject addRole(Role role) {
        this.roles.add(role);

        return this;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    /*public String toString() {
        StringBuilder subject = new StringBuilder();

        subject.append("{id:\"");
        subject.append(this.id);
        subject.append("\",");
        subject.append("name:\"");
        subject.append(this.username);
        subject.append("\",");
        subject.append("roles:{");

        for (Role apiUserRole : this.roles) {
            subject.append("role:\"");
            subject.append(apiUserRole.getRole());
            subject.append("\",");
        }

        subject.deleteCharAt(subject.length() - 1);
        subject.append("}");

        return subject.toString();
    }*/
}
