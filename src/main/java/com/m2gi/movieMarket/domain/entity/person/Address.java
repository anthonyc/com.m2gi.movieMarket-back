package com.m2gi.movieMarket.domain.entity.person;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "streetNumber")
    private int streetNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "additionalInformation")
    private String additionalInformation;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "city")
    private String city;

    public int getId() {
        return this.id;
    }

    public int getStreetNumber() {
        return this.streetNumber;
    }

    public Address setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;

        return this;
    }

    public String getStreet() {
        return this.street;
    }

    public Address setStreet(String street) {
        this.street = street;

        return this;
    }

    public String getAdditionalInformation() {
        return this.additionalInformation;
    }

    public Address setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;

        return this;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public Address setZipCode(String zipCode) {
        this.zipCode = zipCode;

        return this;
    }

    public String getCity() {
        return this.city;
    }

    public Address setCity(String city) {
        this.city = city;

        return this;
    }

    public String toString() {
        String adress =
            getStreetNumber() + " " +
            getStreet() + " " +
            getAdditionalInformation() + " " +
            getCity() + " " +
            getZipCode();

        return adress;
    }
}
