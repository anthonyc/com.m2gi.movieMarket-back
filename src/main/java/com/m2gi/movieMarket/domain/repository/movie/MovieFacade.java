package com.m2gi.movieMarket.domain.repository.movie;

import java.util.List;

import com.m2gi.movieMarket.domain.entity.movie.Movie;

import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class MovieFacade implements MovieFacadeLocal {
	
	@PersistenceContext()
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

	public List<Movie> search(String search) {
		return this.em.createQuery("select m from Movie as m where m.name like '" + search +"%'")
				.getResultList()
		;
	}
	
	public List<Movie> findAll(int from, int to) {
		return this.em.createQuery("select m from Movie as m")
				.setFirstResult(from)
				.setMaxResults(to)
				.getResultList()
		;
	}

	public List<Movie> findAllByCategory(String category, int from, int to) {
		return this.em.createQuery("select m from Movie m join m.categories c where c.name = :category")
				.setParameter("category", category)
				.setFirstResult(from)
				.setMaxResults(to)
				.getResultList()
		;
	}

	public List<Movie> findAllByCategoryFilterByName(String category, int from, int to) {
		return this.em.createQuery("select m from Movie m join m.categories c where c.name = :category order by m.name")
				.setParameter("category", category)
				.setFirstResult(from)
				.setMaxResults(to)
				.getResultList()
		;
	}

	public List<Movie> findAllByCategoryFilterByPriceDesc(String category, int from, int to) {
		return this.em.createQuery("select m from Movie m join m.categories c where c.name = :category order by m.price desc")
				.setParameter("category", category)
				.setFirstResult(from)
				.setMaxResults(to)
				.getResultList()
		;
	}

	public List<Movie> findAllByCategoryFilterByPriceAsc(String category, int from, int to) {
		return this.em.createQuery("select m from Movie m join m.categories c where c.name = :category order by m.price asc")
				.setParameter("category", category)
				.setFirstResult(from)
				.setMaxResults(to)
				.getResultList()
		;
	}

	public List<Movie> findAllByCategoryFilterByDate(String category, int from, int to) {
		return this.em.createQuery("select m from Movie m join m.categories c where c.name = :category order by releaseYear")
				.setParameter("category", category)
				.setFirstResult(from)
				.setMaxResults(to)
				.getResultList()
		;
	}
}
