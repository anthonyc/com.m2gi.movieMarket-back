package com.m2gi.movieMarket.api;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InternalServerException extends WebApplicationException {
    public InternalServerException(String message) {
        super(Response.status(
                Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ApiErrorsMessage(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), message))
                .type(MediaType.APPLICATION_JSON)
                .build());
    }
}
