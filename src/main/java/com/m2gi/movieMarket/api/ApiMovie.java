package com.m2gi.movieMarket.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
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
		try {
			this.movieReference.create(movie);
		} catch (Exception exception) {
			// Todo Add other return status
			throw new InternalServerException("Internal Server Exception ");
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void edit(Movie movie) {
		try {
			this.movieReference.edit(movie);
		} catch (Exception exception) {
			// Todo Add other return status
			throw new InternalServerException("Internal Server Exception ");
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void remove(Movie movie) {
		try {
			this.movieReference.remove(movie);
		} catch (Exception exception) {
			// Todo Add other return status
			throw new InternalServerException("Internal Server Exception ");
		}
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
			@DefaultValue("") @QueryParam("search") String search,
			@DefaultValue("0") @QueryParam("from") int from,
			@DefaultValue("20") @QueryParam("to") int to,
			@DefaultValue("") @QueryParam("order") String order,
			@DefaultValue("") @QueryParam("sort") String sort)
    {

		if (category.isEmpty() && search.isEmpty()) {
			return this.movieReference.findAll(from, to);
		}

		if (!search.isEmpty()) {
			return this.movieReference.search(search);
		}

        if (order.isEmpty()) {
            return this.movieReference.findAllByCategory(category, from, to);
        }

        if (order.equals("date")) {
            return this.movieReference.findAllByCategoryFilterByDate(category, from, to);
        }

        if (order.equals("name")) {
            return this.movieReference.findAllByCategoryFilterByName(category, from, to);
        }

        if (sort.equals("desc")) {
            return this.movieReference.findAllByCategoryFilterByPriceDesc(category, from, to);
        }

        if (sort.equals("asc")) {
            return this.movieReference.findAllByCategoryFilterByPriceAsc(category, from, to);
        }

		return this.movieReference.findAllByCategory(category, from, to);
	}
}
