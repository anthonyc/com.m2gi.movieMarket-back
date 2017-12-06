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
    private String firstname;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date Birthday;

    public Gender getGender() {
        return gender;
    }

    public Person setGender(Gender gender) {
        this.gender = gender;

        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Person setFirstname(String firstname) {
        this.firstname = firstname;

        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;

        return this;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public Person setBirthday(Date birthday) {
        Birthday = birthday;

        return this;
    }
}
