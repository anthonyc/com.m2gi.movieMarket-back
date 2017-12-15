package com.m2gi.movieMarket.api;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BadRequestException extends WebApplicationException {
    public BadRequestException(String message) {
        super(Response.status(
                Response.Status.BAD_REQUEST)
                .entity(new ApiErrorsMessage(Response.Status.BAD_REQUEST.getStatusCode(), message))
                .type(MediaType.APPLICATION_JSON)
                .build());
    }
}
