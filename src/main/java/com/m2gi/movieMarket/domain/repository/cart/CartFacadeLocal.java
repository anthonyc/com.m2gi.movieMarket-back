package com.m2gi.movieMarket.domain.repository.cart;

import com.m2gi.movieMarket.domain.entity.cart.Cart;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CartFacadeLocal {

    void create(Cart cart);

    void addMovie(Cart cart);

    void removeMovie(Cart cart);

    void remove(Cart cart);

    Cart find(Cart cart);

    List<CartDetail> listCartDetail(Cart cart);
}