package com.m2gi.movieMarket.domain.repository.cart;


import com.m2gi.movieMarket.domain.entity.cart.Cart;
import com.m2gi.movieMarket.domain.entity.cart.CartDetail;
import com.m2gi.movieMarket.domain.entity.movie.Movie;

import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CartFacade implements CartFacadeLocal {

    @PersistenceContext()
    private EntityManager em;

    @Override
    public void create(Cart cart) {
        this.em.persist(cart);
    }

    @Override
    public void addMovie(Cart cart) {

    }

    @Override
    public void removeMovie(Cart cart) {

    }

    public void remove(Cart cart) {
        this.em.remove(cart);
    }

    @Override
    public Cart find(Cart cart) {
        return null;
    }

    /*@Override
    public void addMovie(Movie movie, int quantite) {
        CartDetail cartDetail = new CartDetail();
        cartDetail.setQuantity(quantite);

        this.em.persist(cartDetail);
    }*/

    @Override
    public List<CartDetail> listCartDetail(Cart cart) {
        return new ArrayList<CartDetail>();
    }
}