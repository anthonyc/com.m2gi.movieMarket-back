package com.m2gi.movieMarket.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/ws")
public class ApplicationConfig extends Application {
	public ApplicationConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("http://localhost:8080/ws");
        beanConfig.setResourcePackage("io.swagger.resources");
        beanConfig.setScan(true);
    }
	
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        
        resources.add(com.m2gi.movieMarket.services.MovieWs.class);
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }
}
