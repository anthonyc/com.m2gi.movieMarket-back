package com.m2gi.movieMarket.domain.entity.order;

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
@Table(name="order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @OneToMany(mappedBy = "order")
    private Collection<OrderDetail> orderDetailCollection;
    
    public int getId() {
        return this.id;
    }
}
