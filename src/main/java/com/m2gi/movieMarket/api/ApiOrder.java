package com.m2gi.movieMarket.api;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.m2gi.movieMarket.domain.entity.cart.Cart;
import com.m2gi.movieMarket.domain.entity.order.Order;
import com.m2gi.movieMarket.domain.repository.order.OrderFacadeLocal;

import io.swagger.annotations.Api;
import io.swagger.jaxrs.PATCH;

@Path("/order")
@Api(
    value = "Order Entity"
)
public class ApiOrder {

    @EJB
    private OrderFacadeLocal orderReference;

    @PATCH
    @Path("/user/{userId}/address/{addressId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add (
        Cart cart,
        @PathParam("userId") int userId,
        @PathParam("addressId") int addressId ) {

        try {
            int id = this.orderReference.add(cart, userId, addressId);

            return Response.status(Response.Status.CREATED).entity(new ApiMessage("Address created with id : " + id)).build();
        } catch (Exception exception) {
            throw new InternalServerException("Internal Server Exception ");
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void remove(Order order) {
        try {
            this.orderReference.remove(order);
        } catch (Exception exception) {
            // Todo Add other return status
            throw new InternalServerException("Internal Server Exception ");
        }
    }

    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@PathParam("userId") int userId) {
        try {
            this.orderReference.findAll((Object) userId);
        } catch (Exception exception) {
            // Todo Add other return status
            throw new InternalServerException("Internal Server Exception ");
        }
    }
}