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

        this.cartReference.addMovies(userId, movieIds);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void remove(Cart cart) {
        this.cartReference.remove(cart);
    }

    /* On veut ajouter un film dans le panier,
    Il faut creer le panier si celui-ci n'existe pas,
    Il faut creer le CartDetail qui reference un film et une quantite
    */
    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMovie(
        @QueryParam("movie") Movie movie,
        @DefaultValue("1") @QueryParam("quantite") int quantite) {
        this.cartReference.addMovie(movie, quantite);
    }

    *//* On veut lister tous les CartDetail associer a un Cart
    Le Cart etant lie a un utilisateur, cet identifiant sera unique pour la session.
    *//*
    @GET
    @Path{"/"}
    @Produces(MediaType.APPLICATION_JSON)
    public List<CartDetail> listCartDetail() {
        return this.cartReference.listCartDetail();
    }*/

}