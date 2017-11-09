package com.m2gi.movieMarket.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.m2gi.movieMarket.domain.entity.Movie;
import com.m2gi.movieMarket.domain.repository.MovieFacadeLocal;

@Stateless
//@LocalBean
@Path("/movies")
public class MovieWs {
	
	@EJB
	private MovieFacadeLocal movieReference;
	
	@GET
	@Path("/hello")
	public String hello() {
		return "Hello";
	}
	
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
	
	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Movie find(@PathParam("id") Long id) {
		return this.movieReference.find((Object) id);
	}
	
	@WebMethod(operationName="findAll")
	@Oneway
	@GET
	@Path("/all")
	public List<Movie> findAll() {
		return this.movieReference.findAll();
	}
}
