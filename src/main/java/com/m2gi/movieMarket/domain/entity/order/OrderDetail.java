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
@Table(name="order_detail")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "quantity")
    private int quantity;
    
    public int getId() {
        return this.id;
    }

    public OrderDetail setId(int id) {
        this.id = id;

        return this;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public OrderDetail addMovie(Movie movie) {
        this.movie = movie;

        return this;
    }

    public int getQuantity() {
        return this.quantity;
    }
    
    public OrderDetail setQuantity(int quantity) {
        this.quantity = quantity;
        
        return this;
    }
}
