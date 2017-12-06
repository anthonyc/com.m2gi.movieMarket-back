package com.m2gi.movieMarket.services;

import com.m2gi.movieMarket.domain.entity.person.User;
import com.m2gi.movieMarket.domain.repository.person.UserFacadeLocal;
import io.swagger.annotations.Api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;

@Path("/user")
@Api
public class UserApi {

    @EJB
    private UserFacadeLocal userReference;

    @Path("/")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user, @Context UriInfo uriInfo) {
        System.out.println("plop");
        int id = this.userReference.create(user);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(id));


        return Response.created(builder.build()).build();
    }
}
