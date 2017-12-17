package com.m2gi.movieMarket.domain.entity.order;

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
@Table(name="order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="order_id", referencedColumnName="id")
    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
    
    public int getId() {
        return this.id;
    }

    public Order setId(int id) {
        this.id = id;

        return this;
    }
}
