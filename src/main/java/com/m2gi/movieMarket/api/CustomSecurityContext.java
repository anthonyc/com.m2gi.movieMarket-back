package com.m2gi.movieMarket.api;

import com.m2gi.movieMarket.api.security.ApiUser;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class CustomSecurityContext implements SecurityContext {
    private ApiUser user;
    private String scheme;

    public CustomSecurityContext(ApiUser user, String scheme) {
        this.user = user;
        this.scheme = scheme;
    }

    @Override
    public Principal getUserPrincipal() {
        return this.user;
    }

    @Override
    public boolean isUserInRole(String role) {
        return user.hasRole(role);
    }

    @Override
    public boolean isSecure() {
        return "https".equals(this.scheme);
    }

    @Override
    public String getAuthenticationScheme() {
        return this.scheme;
    }
}
