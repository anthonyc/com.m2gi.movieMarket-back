package com.m2gi.movieMarket.domain.entity.person;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends Person implements Serializable, Principal {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<UserRole> userRoles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private List<Address> addresses = new ArrayList<>();

    @Column(name = "username", nullable = false)
    @NotNull
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    @NotNull
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull
    private String password;

    public User() {}

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public User setId(int id) {
        this.id = id;

        return this;
    }

    public List<UserRole> getUserRoles() {
        return this.userRoles;
    }

    public boolean hasRole(String role) {
        for (UserRole userRole : this.getUserRoles()) {
            if (userRole.hasRole(role)) {
                return true;
            }
        }

        return false;
    }

    public User addUserRole(UserRole userRole) {

        this.userRoles.add(userRole);

        return this;
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    public User addAddress(Address address) {

        this.addresses.add(address);

        return this;
    }

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
        return BCrypt.checkpw(password, this.password);
    }

    public User setPassword(String password) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

        this.password = hashed;

        return this;
    }

    @Override
    public String getName() {
        return this.getFirstname() + " " + this.getLastname();
    }
}
