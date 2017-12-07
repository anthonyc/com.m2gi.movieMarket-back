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
@Table(name="orderDetail")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "quantity")
    private int quantity;
    
    public int getId() {
        return this.id;
    }

    public int getQuantity() {
        return this.quantity;
    }
    
    public Movie setQuantity(int quantity) {
        this.quantity = quantity;
        
        return this;
    }
}
