package com.m2gi.movieMarket.domain.entity.person;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
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

    public String getFirstName() {
        return this.firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;

        return this;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;

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
