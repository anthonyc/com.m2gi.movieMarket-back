package com.m2gi.movieMarket.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.m2gi.movieMarket.domain.entity.Movie;
import com.m2gi.movieMarket.domain.repository.MovieFacadeLocal;

import io.swagger.annotations.Api;

@Stateless
@Path("/movies")
@Api(
	value = "Movies Entity"
)
public class MovieWs {
	
	@EJB
	private MovieFacadeLocal movieReference;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Movie movie) {
		this.movieReference.create(movie);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void edit(Movie movie) {
		this.movieReference.edit(movie);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void remove(Movie movie) {
		this.movieReference.remove(movie);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie find(@PathParam("id") int id) {
		return this.movieReference.find((Object) id);
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> findAll(
			@DefaultValue("0") @QueryParam("from") int from,
			@DefaultValue("20") @QueryParam("to") int to) {
		return this.movieReference.findAll(from, to);
	}
}
