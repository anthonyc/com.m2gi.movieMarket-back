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

//import org.simplejavamail.email.Email;
//import org.simplejavamail.mailer.Mailer;
//import org.simplejavamail.mailer.config.ProxyConfig;
//import org.simplejavamail.mailer.config.ServerConfig;
//import org.simplejavamail.mailer.config.TransportStrategy;

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
            throw new NotAuthorizedException("You are not authorized at find the user : " + id);
        }

    	User user = this.userReference.find(id);
    	
        if (user == null) {
            throw new NotFoundException("Entity not found for id : " + id);
        }

        /*Email email = new Email();

        email.setFromAddress("movieMArket", "no-reply@movie-market.com");
        email.addNamedToRecipients(user.getUsername(), "chavoutier.anthony@gmail.com");
        email.setSubject("Validation inscription");
        email.setText("test");
        
        new Mailer(
			new ServerConfig("localhost", 587, "user@host.com", "password"),
			TransportStrategy.SMTP_TLS
    	).sendMail(email);*/
        

        return Response.ok(user).build();
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid User user, @Context UriInfo uriInfo) {
        try {
            int id = this.userReference.create(user);
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(Integer.toString(id));

            return Response.created(builder.build()).entity(new ApiMessage("User created")).build();
        } catch (Exception exception) {
            throw new InternalServerException("Internal Server Exception ");
        }
    }
}
