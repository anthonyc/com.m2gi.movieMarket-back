package com.m2gi.movieMarket.api.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.m2gi.movieMarket.api.*;
import com.m2gi.movieMarket.api.filter.AuthenticationFilter;
import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {

	public ApplicationConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.3");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("com.m2gi.movieMarket.api");
        beanConfig.setScan(true);
    }

	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();

        resources.add(MovieApi.class);
        resources.add(CategoryApi.class);
        resources.add(UserApi.class);
        resources.add(AuthenticationFilter.class);
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }
}
