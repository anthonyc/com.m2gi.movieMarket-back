package com.m2gi.movieMarket.domain.repository.cart;


import com.m2gi.movieMarket.domain.entity.cart.Cart;
import com.m2gi.movieMarket.domain.entity.cart.CartDetail;
import com.m2gi.movieMarket.domain.entity.movie.Movie;
import com.m2gi.movieMarket.domain.entity.person.User;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CartFacade implements CartFacadeLocal {

    @PersistenceContext()
    private EntityManager em;

    private Logger logger = LoggerFactory.getLogger(CartFacade.class);

    @Override
    public void addMovies(int userId, List<Integer> movieIds) {
        User user = this.em.find(User.class, userId);

        Hibernate.initialize(user.getUserRoles());
        Hibernate.initialize(user.getAddresses());

        Cart cart = new Cart();

        try {
            cart = (Cart) this.em.createQuery("select c from Cart c where c.user = :user")
                    .setParameter("user", user)
                    .getSingleResult();
        } catch (NoResultException noResultException) {
            this.logger.info("####### No cart find for user : " + userId);
            this.logger.info("####### New Cart return");
        }


        List<Movie> movies = (List<Movie>) this.em.createQuery("select m from Movie m where m.id in :movieIds")
                .setParameter("movieIds", movieIds)
                .getResultList();


        cart.setUser(user);

        for (Movie movie : movies) {
            cart.addCartDetail((new CartDetail().addMovie(movie)));
        }

        this.em.persist(cart);
        this.em.flush();
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