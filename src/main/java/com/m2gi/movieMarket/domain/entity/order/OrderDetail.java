package com.m2gi.movieMarket.domain.entity.order;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.m2gi.movieMarket.domain.entity.movie.*;

@Entity
@Table(name="orderDetail")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order", referencedColumnName = "order_id")
    private Order order;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie", referencedColumnName = "movie_id")
    private Movie movie;

    @Column(name = "quantity")
    private int quantity;
    
    public int getId() {
        return this.id;
    }

    public int getQuantity() {
        return this.quantity;
    }
    
    public OrderDetail setQuantity(int quantity) {
        this.quantity = quantity;
        
        return this;
    }
}
