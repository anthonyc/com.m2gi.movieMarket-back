package com.m2gi.movieMarket.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.m2gi.movieMarket.domain.entity.cart.Cart;
import com.m2gi.movieMarket.domain.entity.order.Order;
import com.m2gi.movieMarket.domain.repository.order.OrderFacadeLocal;
import com.m2gi.movieMarket.domain.entity.person.Address;

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
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public void addCart(
        @FormParam("cart_id") int cart_id,
        @FormParam("userId") int userId,
        @FormParam("address_id") int address_id ) {

        this.orderReference.addCart(cart_id, userId, address_id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void remove(Order order) {
        this.orderReference.remove(order);
    }


}