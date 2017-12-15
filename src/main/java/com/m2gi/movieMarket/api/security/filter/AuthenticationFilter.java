package com.m2gi.movieMarket.api.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2gi.movieMarket.api.security.CustomSecurityContext;
import com.m2gi.movieMarket.api.security.user.ApiUser;
import com.m2gi.movieMarket.api.security.KeyGenerator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
    private static final String AUTHENTICATION_SCHEME = "Bearer";

    private Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        this.logger.info("#### authorizationHeader : " + authorizationHeader);


        if (!isTokenBasedAuthentication(authorizationHeader)) {
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();

        try {
            Claims claimJws =  this.validateToken(token);

            ObjectMapper mapper = new ObjectMapper();
            ApiUser apiUser = mapper.readValue(claimJws.getSubject(), ApiUser.class);

            String scheme = requestContext.getUriInfo().getRequestUri().getScheme();
            requestContext.setSecurityContext(new CustomSecurityContext(apiUser, scheme));
        } catch (SignatureException signatureException) {
            throw new NotAuthorizedException("Invalid token");
        }

    }

    private boolean isTokenBasedAuthentication(String authorizationHeader) {
        return authorizationHeader != null && authorizationHeader.toLowerCase()
                .startsWith(this.AUTHENTICATION_SCHEME.toLowerCase() + " ");
    }

    private Claims validateToken(String token) throws SignatureException {
        return Jwts.parser().setSigningKey(KeyGenerator.createKey()).parseClaimsJws(token).getBody();
    }
}