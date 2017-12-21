package com.m2gi.movieMarket.domain.repository.movie;

import com.m2gi.movieMarket.domain.entity.movie.Movie;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MovieFacadeLocal {
	
	void create(Movie movie);
	
	void edit(Movie movie);
	
	void remove(Movie movie);
	
	Movie find(Object id);

	List<Movie> search(String search);

	List<Movie> findAll(int from, int to);

	List<Movie> findAllByCategory(String Category, int from, int to);
}
