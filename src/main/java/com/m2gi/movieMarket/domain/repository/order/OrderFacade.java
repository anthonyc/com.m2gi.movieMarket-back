package com.m2gi.movieMarket.domain.repository.order;


import com.m2gi.movieMarket.domain.entity.cart.Cart;
import com.m2gi.movieMarket.domain.entity.cart.CartDetail;
import com.m2gi.movieMarket.domain.entity.order.Order;
import com.m2gi.movieMarket.domain.entity.order.OrderDetail;
import com.m2gi.movieMarket.domain.entity.movie.Movie;
import com.m2gi.movieMarket.domain.entity.person.User;
import com.m2gi.movieMarket.domain.entity.person.Address;
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
public class OrderFacade implements OrderFacadeLocal {

    @PersistenceContext()
    private EntityManager em;

    @Override
    public void addCart(Cart cart, int userId, Address address) {
        User user = this.em.find(User.class, userId);

        Hibernate.initialize(user.getUserRoles());
        Hibernate.initialize(user.getAddresses());

        Order order = new Order();

        order.setUser(user);
        order.setAddress(address.toString());

        List<CartDetail> cartDetails = cart.getCartDetails();

        float totalCommande = 0;

        for (CartDetail cartDetail : cartDetails) {
            OrderDetail orderDetail = new OrderDetail();

            orderDetail.addMovie(cartDetail.getMovie());
            orderDetail.setQuantity(cartDetail.getQuantity());

            order.addOrder(orderDetail);
        }
    }

    @Override
    public void remove(Order order) {
        this.em.remove(order);
    }
}