package com.m2gi.movieMarket.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.m2gi.movieMarket.domain.entity.cart.Cart;
import com.m2gi.movieMarket.domain.repository.cart.CartFacadeLocal;

import io.swagger.annotations.Api;
import io.swagger.jaxrs.PATCH;

@Path("/cart")
@Api(
    value = "Cart Entity"
)
public class ApiCart {

    @EJB
    private CartFacadeLocal cartReference;

    @PATCH
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public void addMovies(@FormParam("userId") int userId, @FormParam("movieIds") List<Integer> movieIds) {
        try {
            this.cartReference.addMovies(userId, movieIds);
        } catch (Exception exception) {
            // Todo Add other return status
            throw new InternalServerException("Internal Server Exception ");
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void remove(Cart cart) {
        try {
            this.cartReference.remove(cart);
        } catch (Exception exception) {
            // Todo Add other return status
            throw new InternalServerException("Internal Server Exception ");
        }
    }
}