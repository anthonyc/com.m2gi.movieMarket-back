package com.m2gi.movieMarket.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2gi.movieMarket.api.JWT.JWTTokenNeeded;
import com.m2gi.movieMarket.api.security.user.InvalidParameterException;
import com.m2gi.movieMarket.api.security.KeyGenerator;
import com.m2gi.movieMarket.api.security.user.Role;
import com.m2gi.movieMarket.domain.entity.person.UserRole;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;

import javax.ejb.EJB;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.m2gi.movieMarket.domain.entity.person.User;
import com.m2gi.movieMarket.domain.repository.person.UserFacadeLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.security.Key;
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

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("login") String login, @FormParam("password") String password) {

        try {
            User user = this.userReference.findByEmail(login);

            com.m2gi.movieMarket.api.security.user.User apiUser = new com.m2gi.movieMarket.api.security.user.User(user.getId(), user.getUsername());

            for (UserRole userRole : user.getUserRoles()) {
                apiUser.addRole(Role.roleFromString(userRole.getRole()));
            }

            ObjectMapper objectMapper = new ObjectMapper();

            Key key = KeyGenerator.createKey();

            String compactJws = Jwts.builder()
                    .setSubject(objectMapper.writeValueAsString(apiUser))
                    .signWith(SignatureAlgorithm.HS512, key)
                    .compact();

            if (!Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getBody().getSubject().equals(objectMapper.writeValueAsString(apiUser))) {
                this.logger.error("Error during JWT token verification");
                throw new InternalServerException("Internal server error");
            }

            return Response.created(URI.create("/auth")).entity(new ApiMessage(compactJws)).build();
        } catch (NoResultException noResultException) {
            this.logger.error(noResultException.getStackTrace().toString());
            throw new NotFoundException("Entity User not found with login : " + login);
        } catch (NonUniqueResultException nonUniqueResultException) {
            this.logger.error(nonUniqueResultException.getStackTrace().toString());
            return Response.serverError().build();
        } catch (InvalidParameterException invalidParameterException) {
            this.logger.error(invalidParameterException.getStackTrace().toString());
            throw new InternalServerException("Internal server error");
        } catch (JsonProcessingException jsonProcessingException) {
            this.logger.error(jsonProcessingException.getStackTrace().toString());
            throw new InternalServerException("Internal server error");
        }
    }

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
