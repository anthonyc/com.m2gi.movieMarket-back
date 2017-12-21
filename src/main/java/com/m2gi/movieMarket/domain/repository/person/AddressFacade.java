package com.m2gi.movieMarket.domain.repository.person;

import com.m2gi.movieMarket.domain.entity.person.Address;
import com.m2gi.movieMarket.domain.entity.person.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AddressFacade implements AddressFacadeLocal {
    @PersistenceContext()
    private EntityManager em;

    private Logger logger = LoggerFactory.getLogger(AddressFacade.class);

    @Override
    public void remove(int id, int userId) {
        User user = this.em.find(User.class, userId);

        for (Address address : user.getAddresses()) {
            if (address.getId() == id) {
                this.logger.info("Address:remove try to remove Address : " + id);
                this.em.remove(address);
                this.em.flush();
            }
        }
    }

    @Override
    public int create(Address address, int userId) {
        User user = this.em.find(User.class, userId);

        user.addAddress(address);

        this.em.persist(address);
        this.em.flush();

        return address.getId();
    }
}
