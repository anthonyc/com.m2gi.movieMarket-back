package com.m2gi.movieMarket.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.m2gi.movieMarket.services.MovieWs;

@ApplicationPath("/ws")
public class ApplicationConfig extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(MovieWs.class);
		
		return classes;
	}
}
