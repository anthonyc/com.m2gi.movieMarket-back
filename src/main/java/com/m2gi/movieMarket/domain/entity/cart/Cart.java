package com.m2gi.movieMarket.domain.entity.cart;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="cart")
public class Cart implements Serializable {
    @Id
    @Column(name="cart_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "cart")
    private Collection<CartDetail> cartDetailCollection;
    
    
    public int getId() {
        return this.id;
    }
}
