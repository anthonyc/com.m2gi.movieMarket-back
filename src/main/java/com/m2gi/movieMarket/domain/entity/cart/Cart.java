package com.m2gi.movieMarket.domain.entity.cart;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="cart")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="cart_id", referencedColumnName="id")
    private List<CartDetail> cartDetailList = new ArrayList<CartDetail>();
    
    
    public int getId() {
        return this.id;
    }

    public Cart setId(int id) {
        this.id = id;

        return this;
    }
}
