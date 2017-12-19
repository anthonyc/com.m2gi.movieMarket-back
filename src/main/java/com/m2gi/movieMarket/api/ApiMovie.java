package com.m2gi.movieMarket.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.m2gi.movieMarket.domain.entity.movie.Movie;
import com.m2gi.movieMarket.domain.repository.movie.MovieFacadeLocal;

import io.swagger.annotations.Api;

@Path("/movies")
@Api(
	value = "Movies Entity"
)
public class ApiMovie {
	
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
	public Response find(@PathParam("id") int id) {
		Movie movie = this.movieReference.find((Object) id);
		
		if (movie == null) {
			throw new NotFoundException("Entity not found for id : " + id);
		}

		return Response.ok(movie).build();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> findAll(
			@DefaultValue("") @QueryParam("category") String category,
			@DefaultValue("0") @QueryParam("from") int from,
			@DefaultValue("20") @QueryParam("to") int to,
			@DefaultValue("") @QueryParam("order") String order,
			@DefaultValue("") @QueryParam("sort") String sort)
			 {

		if (category.isEmpty()) {
			return this.movieReference.findAll(from, to);
		}
		if(order.isEmpty()){
			return this.movieReference.findAllByCategory(category, from, to);
		}
		if(order.equals("name")){
			return this.movieReference.findAllByCategoryFilterByName(category, from, to);
		}
		if(sort.equals("desc")){
			return this.movieReference.findAllByCategoryFilterByPriceDesc(category, from, to);
		}
		return this.movieReference.findAllByCategoryFilterByPriceAsc(category, from, to);

	}
}
