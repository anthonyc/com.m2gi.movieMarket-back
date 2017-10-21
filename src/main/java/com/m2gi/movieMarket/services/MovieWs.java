package com.m2gi.movieMarket.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.m2gi.movieMarket.domain.entity.Movie;
import com.m2gi.movieMarket.domain.repository.MovieFacadeLocal;

@WebService
@Stateless
public class MovieWs {
	
	@EJB
	private MovieFacadeLocal movieReference;
	
	@WebMethod(operationName="create")
	@Oneway
	public void create(Movie movie) {
		this.movieReference.create(movie);
	}
	
	@WebMethod(operationName="edit")
	@Oneway
	public void edit(Movie movie) {
		this.movieReference.edit(movie);
	}
	
	@WebMethod(operationName="remove")
	@Oneway
	public void remove(Movie movie) {
		this.movieReference.remove(movie);
	}
	
	@WebMethod(operationName="find")
	@Oneway
	public Movie find(Object id) {
		return this.movieReference.find(id);
	}
	@WebMethod(operationName="findAll")
	@Oneway
	public List<Movie> findAll() {
		return this.movieReference.findAll();
	}
}
