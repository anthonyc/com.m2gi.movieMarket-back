package com.m2gi.movieMarket.domain.repository;

import java.util.List;

import com.m2gi.movieMarket.domain.entity.Movie;
import javax.persistence.PersistenceContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
@LocalBean
public class MovieFacade implements MovieFacadeLocal {
	
	@PersistenceContext
	private EntityManager em;

	public void create(Movie movie) {
		this.em.persist(movie);
	}

	public void edit(Movie movie) {
		this.em.merge(movie);
	}

	public void remove(Movie movie) {
		this.em.remove(movie);
	}

	public Movie find(Object id) {
		return this.em.find(Movie.class, id);
	}

	public List<Movie> findAll() {
		return this.em.createQuery("select object(o) from Movie as o").getResultList();
	}

}
