package com.m2gi.movieMarket.services;

import com.m2gi.movieMarket.domain.entity.movie.Category;
import com.m2gi.movieMarket.domain.repository.movie.CategoryFacadeLocal;
import io.swagger.annotations.Api;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/categories")
@Api(
	value = "Category Entity"
)
public class CategoryApi {
	
	@EJB
	private CategoryFacadeLocal categoryReference;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Category category) {
		this.categoryReference.create(category);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void edit(Category category) {
		this.categoryReference.edit(category);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void remove(Category category) {
		this.categoryReference.remove(category);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("id") int id) {
		Category category = this.categoryReference.find((Object) id);
		
		if (category == null) {
			throw new NotFoundException("Entity not found for id : " + id);
		}

		return Response.ok(category).build();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> findAll(
			@DefaultValue("0") @QueryParam("from") int from,
			@DefaultValue("20") @QueryParam("to") int to) {

		return this.categoryReference.findAll(from, to);
	}
}
