package com.m2gi.movieMarket.api;

import com.m2gi.movieMarket.api.JWT.JWTTokenNeeded;
import com.m2gi.movieMarket.api.security.user.Role;
import io.swagger.annotations.Api;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.m2gi.movieMarket.domain.entity.person.User;
import com.m2gi.movieMarket.domain.repository.person.UserFacadeLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/user")
@Api(
    value = "User Entity"
)
public class ApiUser {

    @EJB
    private UserFacadeLocal userReference;

    private Logger logger = LoggerFactory.getLogger(ApiUser.class);

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response find(@Context SecurityContext securityContext, @PathParam("id") int id) {

        if (!securityContext.isUserInRole(String.valueOf(Role.ROLE_USER))) {
            throw new NotAuthorizedException("You are not authorized to execute this operation");
        }

    	User user = this.userReference.find(id);
    	
        if (user == null) {
            throw new NotFoundException("Entity not found for id : " + id);
        }


        return Response.ok(user).build();
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid User user, @Context UriInfo uriInfo) {
        try {
            int id = this.userReference.create(user);

            return Response.status(Response.Status.CREATED).entity(new ApiMessage("User created with id : " + id)).build();
        } catch (Exception exception) {
            throw new InternalServerException("Internal Server Exception ");
        }
    }
}
