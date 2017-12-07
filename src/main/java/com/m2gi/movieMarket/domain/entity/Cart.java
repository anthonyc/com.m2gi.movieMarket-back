package com.m2gi.movieMarket.domain.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="cart")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    
    public int getId() {
        return this.id;
    }
}
