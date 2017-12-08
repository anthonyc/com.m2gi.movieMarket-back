package com.m2gi.movieMarket.domain.repository.movie;

import com.m2gi.movieMarket.domain.entity.movie.Category;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryFacadeLocal {
	
	void create(Category category);
	
	void edit(Category category);
	
	void remove(Category category);
	
	Category find(Object id);
	
	List<Category> findAll(int from, int to);
}
