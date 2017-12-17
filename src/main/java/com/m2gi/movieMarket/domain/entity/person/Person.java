package com.m2gi.movieMarket.domain.entity.person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NotNull
    private int id;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    @NotNull
    private Gender gender;

    @Column(name = "firstname", nullable = false)
    @NotNull
    private String firstname;

    @Column(name = "lastname", nullable = false)
    @NotNull
    private String lastname;

    @Column(name = "birthday", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date birthday;

    public int getId() {
        return this.id;
    }

    public Person setId(int id) {
        this.id = id;

        return this;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Person setGender(Gender gender) {
        this.gender = gender;

        return this;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public Person setFirstname(String firstname) {
        this.firstname = firstname;

        return this;
    }

    public String getLastname() {
        return this.lastname;
    }

    public Person setLastname(String lastname) {
        this.lastname = lastname;

        return this;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public Person setBirthday(Date birthday) {
        this.birthday = birthday;

        return this;
    }
}
