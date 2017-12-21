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

    private Logger logger = LoggerFactory.getLogger(OrderFacade.class);

    @Override
    public int add(Cart cart, int userId, int addressId) {
        try {
            User user = this.em.find(User.class, userId);

            Hibernate.initialize(user.getUserRoles());
            Hibernate.initialize(user.getAddresses());

            Order order = new Order();

            order.setUser(user);

            Address address = (Address) this.em.find(Address.class, addressId);

            order.setAddress(address.toString());

            List<CartDetail> cartDetails = cart.getCartDetails();

            float totalCommande = 0;

            for (CartDetail cartDetail : cartDetails) {
                OrderDetail orderDetail = new OrderDetail();

                orderDetail.addMovie(cartDetail.getMovie());
                orderDetail.setQuantity(cartDetail.getQuantity());

                order.addOrder(orderDetail);
            }

            this.em.persist(order);
            this.em.flush();

            return order.getId();

        } catch (NoResultException noResultException) {
            this.logger.info("####### No address find with id : " + addressId);
            this.logger.info("####### Address empty");

            throw new NoResultException();
        }
    }

    @Override
    public void remove(Order order) {
        this.em.remove(order);
    }
}