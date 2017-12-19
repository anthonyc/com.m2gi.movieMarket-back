package com.m2gi.movieMarket.services;

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

import com.m2gi.movieMarket.domain.entity.cart.Cart;
import com.m2gi.movieMarket.domain.entity.cart.CartDetail;
import com.m2gi.movieMarket.domain.repository.cart.CartFacadeLocal;

import io.swagger.annotations.Api;

@Path("/cart")
@Api(
    value = "Cart Entity"
)
public class CartApi {

    @EJB
    private CartFacadeLocal cartReference;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Cart cart) {
        this.cartReference.create(cart);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void remove(Cart cart) {
        this.cartReference.remove(cart);
    }

    /* On veut ajouter un film dans le panier,
    Il faut créer le panier si celui-ci n'existe pas,
    Il faut créer le CartDetail qui référence un film et une quantité
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMovie(
        @DefaultValue("") @QueryParam("movie") Movie movie,
        @DefaultValue("1") @QueryParam("quantite") int quantite) {
        this.cartReference.addMovie(movie, quantite);
    }

    /* On veut lister tous les CartDetail associer à un Cart
    Le Cart étant lié à un utilisateur, cet identifiant sera unique pour la session.
    */
    @GET
    @Path{"/"}
    @Produces(MediaType.APPLICATION_JSON)
    public List<CartDetail> listCartDetail() {
        return this.cartReference.listCartDetail();
    }

}