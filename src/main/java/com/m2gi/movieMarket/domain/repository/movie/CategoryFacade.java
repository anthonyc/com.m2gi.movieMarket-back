package com.m2gi.movieMarket.domain.repository.movie;

import com.m2gi.movieMarket.domain.entity.movie.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategoryFacade implements CategoryFacadeLocal {
	
	@PersistenceContext()
	private EntityManager em;

	public void create(Category category) {
		this.em.persist(category);
	}

	public void edit(Category category) {
		this.em.merge(category);
	}

	public void remove(Category category) {
		this.em.remove(category);
	}

	public Category find(Object id) {
		return this.em.find(Category.class, id);
	}
	
	public List<Category> findAll(int from, int to) {
		return this.em.createQuery("select c from Category as c")
				.setFirstResult(from)
				.setMaxResults(to)
				.getResultList()
		;
	}

}
