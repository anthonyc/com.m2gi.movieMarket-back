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

import com.m2gi.movieMarket.domain.entity.person.User;


@Entity
@Table(name="order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id")
    private User user;

    private String address;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @Column(name = "price")
    private float price;
    
    public int getId() {
        return this.id;
    }

    public Order setId(int id) {
        this.id = id;

        return this;
    }

    public User getUser() {
        return this.user;
    }

    public Order setUser(User user) {
        this.user = user;

        return this;
    }

    public String getAddress() {
        return this.address;
    }

    public Order setAddress(String address) {
        this.address = address;

        return this;
    }

    public List<OrderDetail> getOrderDetails() {
        return this.orderDetails;
    }

    public Order addOrder(OrderDetail orderDetail) {
        this.orderDetails.add(orderDetail);

        float price = orderDetail.getMovie().getPrice() *
                      orderDetail.getQuantity();

        this.setPrice(this.getPrice() + price);

        return this;
    }

    public float getPrice() {
        return this.price;
    }

    public Order setPrice(float price) {
        this.price = price;

        return this;
    }
}
