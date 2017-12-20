package com.m2gi.movieMarket.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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

    @Path("/")
    public void addCart(
        @FormParam("cart") Cart cart,
        @FormParam("userId") int userId,
        @FormParam("userAdresse") Adress adress ) {

        this.orderReference.addCart(cart, userId, adress);
    }


}