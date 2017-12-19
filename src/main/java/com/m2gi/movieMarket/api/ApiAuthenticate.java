package com.m2gi.movieMarket.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2gi.movieMarket.api.security.KeyGenerator;
import com.m2gi.movieMarket.api.security.user.InvalidParameterException;
import com.m2gi.movieMarket.api.security.user.Role;
import com.m2gi.movieMarket.domain.entity.person.User;
import com.m2gi.movieMarket.domain.entity.person.UserRole;
import com.m2gi.movieMarket.domain.repository.person.UserFacadeLocal;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.security.Key;

@Path("/authenticate")
@Api(
    value = "Authenticate Entity"
)
public class ApiAuthenticate {

    @EJB
    private UserFacadeLocal userReference;

    private Logger logger = LoggerFactory.getLogger(ApiUser.class);

    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(@FormParam("login") String login, @FormParam("password") String password) {

        try {
            this.logger.info("#### ApiUser:login login parameter : " + login);
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

            apiUser.setToken(compactJws);

            return Response.created(URI.create("/auth")).entity(apiUser).build();
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
}
