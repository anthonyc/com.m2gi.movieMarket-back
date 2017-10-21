package com.m2gi.movieMarket.domain.repository;

import com.m2gi.movieMarket.domain.entity.Movie;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface MovieFacadeRemote {
	
	void create(Movie movie);
	
	void edit(Movie movie);
	
	void remove(Movie movie);
	
	Movie find(Object id);
	
	List<Movie> findAll();
}
