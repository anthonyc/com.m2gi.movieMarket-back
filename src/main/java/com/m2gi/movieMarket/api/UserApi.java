package com.m2gi.movieMarket.api;

import io.swagger.annotations.Api;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.m2gi.movieMarket.domain.entity.person.User;
import com.m2gi.movieMarket.domain.repository.person.UserFacadeLocal;
//import org.simplejavamail.email.Email;
//import org.simplejavamail.mailer.Mailer;
//import org.simplejavamail.mailer.config.ProxyConfig;
//import org.simplejavamail.mailer.config.ServerConfig;
//import org.simplejavamail.mailer.config.TransportStrategy;

@Path("/user")
@Api
public class UserApi {

    @EJB
    private UserFacadeLocal userReference;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int id) {

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

   /* @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticate(Credentials credentials) {
        User user = this.userReference.findByEmail(credentials.getLogin());


    }*/

    @Path("/")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user, @Context UriInfo uriInfo) {
        int id = this.userReference.create(user);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(id));


        return Response.created(builder.build()).build();
    }
}
