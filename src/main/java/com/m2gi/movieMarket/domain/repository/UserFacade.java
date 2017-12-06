package com.m2gi.movieMarket.domain.repository;

import com.m2gi.movieMarket.domain.entity.person.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserFacade implements UserFacadeLocal {
	
	@PersistenceContext()
	private EntityManager em;

	public int create(User user) {
		this.em.persist(user);

		return user.getId();
	}

	public void edit(User user) {
		this.em.merge(user);
	}

	public void remove(User user) {
		this.em.remove(user);
	}

	public User find(Object id) {
		return this.em.find(User.class, id);
	}

	public List<User> findAll(int from, int to) {
		return this.em.createQuery("select u from User as u")
				.setFirstResult(from)
				.setMaxResults(to)
				.getResultList()
		;
	}

}
