package com.m2gi.movieMarket.api;

import com.m2gi.movieMarket.api.JWT.JWTTokenNeeded;
import com.m2gi.movieMarket.api.security.user.Role;
import com.m2gi.movieMarket.domain.entity.person.Address;
import com.m2gi.movieMarket.domain.repository.person.AddressFacadeLocal;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/address")
@Api(
    value = "Address Entity"
)
public class ApiAddress {
    @EJB
    private AddressFacadeLocal addressReference;

    private Logger logger = LoggerFactory.getLogger(ApiAddress.class);

    @POST
    @Path("/user/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Address address, @PathParam("userId") int userId) {

        try {
            int id = this.addressReference.create(address, userId);

            return Response.status(Response.Status.CREATED).entity(id).build();
        } catch (Exception exception) {
            throw new InternalServerException("Internal Server Exception ");
        }
    }

    @DELETE
    @Path("/{{id}}/user/{userId}")
    @JWTTokenNeeded
    @Consumes(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") int id,
               @PathParam("userId") int userId,
               @Context SecurityContext securityContext) {
        if (!securityContext.isUserInRole(String.valueOf(Role.ROLE_USER))) {
            throw new NotAuthorizedException("You are not authorized to execute this operation");
        }

        this.addressReference.remove(id, userId);
    }
}
