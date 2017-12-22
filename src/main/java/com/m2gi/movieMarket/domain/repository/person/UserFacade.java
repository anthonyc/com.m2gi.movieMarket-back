package com.m2gi.movieMarket.domain.repository.person;

import com.m2gi.movieMarket.domain.entity.person.User;
import com.m2gi.movieMarket.domain.entity.person.UserRole;
import org.hibernate.Hibernate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserFacade implements UserFacadeLocal {
	
	@PersistenceContext()
	private EntityManager em;

	public int create(User user) {
		UserRole userRole = new UserRole("ROLE_USER");

		user.addUserRole(userRole);

		this.em.persist(user);
		this.em.flush();

		return user.getId();
	}

	public void edit(User user) {
		this.em.merge(user);
	}

	public void remove(User user) {
		this.em.remove(user);
	}

	public User find(Object id) {

		User user = this.em.find(User.class, id);

		Hibernate.initialize(user.getUserRoles());
		Hibernate.initialize(user.getAddresses());

		return user;
	}

	public User findByEmail(String email) {
		try {
			User user = (User) this.em.createQuery("select u from User as u where u.email = :email")
					.setParameter("email", email)
					.getSingleResult();

			Hibernate.initialize(user.getUserRoles());
			Hibernate.initialize(user.getAddresses());

			return user;
		} catch (NoResultException noResultException) {
			return null;
		}

	}
	
	public List<User> findAll(int from, int to) {
		return this.em.createQuery("select u from User as u")
				.setFirstResult(from)
				.setMaxResults(to)
				.getResultList()
		;
	}

}
