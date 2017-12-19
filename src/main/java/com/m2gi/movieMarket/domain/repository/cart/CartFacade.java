package com.m2gi.movieMarket.domain.repository.movie;

import java.util.List;

import com.m2gi.movieMarket.domain.entity.cart.Cart;

import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class CartFacade implements CartFacadeLocal {

    @PersistenceContext()
    private EntityManager em;
    
    public void create(Cart cart) {
        this.em.persist(cart);
    }

    public void remove(Cart cart) {
        this.em.remove(cart);
    }


    public void addMovie(Movie movie, int quantite) {
        CartDetail cartDetail = new CartDetail();
        cartDetail.setQuantite(quantite);

        this.em.persist(cartDetail);
    }

    public List<CartDetail> listCartDetail(Cart cart) {
        return this.em.createQuery("select")
    }
}