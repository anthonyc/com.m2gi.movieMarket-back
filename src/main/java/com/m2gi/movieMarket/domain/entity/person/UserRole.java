package com.m2gi.movieMarket.domain.entity.person;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_role")
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "role")
    private String role;

    public UserRole() {}

    public boolean hasRole(String role) {
        return this.role == role;
    }

    public UserRole(String role) {
        this.role = role;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return this.role;
    }

    public UserRole setRole(String role) {
        this.role = role;

        return this;
    }
}
