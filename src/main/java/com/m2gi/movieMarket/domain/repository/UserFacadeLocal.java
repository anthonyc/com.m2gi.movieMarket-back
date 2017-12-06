package com.m2gi.movieMarket.domain.repository;

import com.m2gi.movieMarket.domain.entity.person.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserFacadeLocal {
	
	int create(User user);
	
	void edit(User user);
	
	void remove(User user);

	User find(Object id);
	
	List<User> findAll(int from, int to);
}
