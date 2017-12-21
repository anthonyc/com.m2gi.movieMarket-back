package com.m2gi.movieMarket.domain.entity.cart;

import java.io.Serializable;
import javax.persistence.*;

import com.m2gi.movieMarket.domain.entity.movie.*;

@Entity
@Table(name="cart_detail")
public class CartDetail implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "quantity")
    private int quantity;
    
    public int getId() {
        return this.id;
    }

    public CartDetail setId(int id) {
        this.id = id;

        return this;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public CartDetail addMovie(Movie movie) {
        this.movie = movie;

        return this;
    }

    public int getQuantity() {
        return this.quantity;
    }
    
    public CartDetail setQuantity(int quantity) {
        this.quantity = quantity;
        
        return this;
    }
}
