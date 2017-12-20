package com.m2gi.movieMarket.domain.repository.order;

import com.m2gi.movieMarket.domain.entity.cart.Cart;
import com.m2gi.movieMarket.domain.entity.order.Order;
import com.m2gi.movieMarket.domain.entity.order.OrderDetail;
import com.m2gi.movieMarket.domain.entity.movie.Movie;
import com.m2gi.movieMarket.domain.entity.person.Address;

import java.util.List;
import javax.ejb.Local;

@Local
public interface OrderFacadeLocal {

    void addCart(Cart cart, int userId, Address address);

    void remove(Order order);
}