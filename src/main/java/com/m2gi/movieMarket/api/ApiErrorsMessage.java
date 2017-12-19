package com.m2gi.movieMarket.api;

public class ApiErrorsMessage {
	private int statusCode;
	private String message;
	
	public ApiErrorsMessage(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
	
	public int getStatusCode() {
		return this.statusCode;
	}
	
	public String getMessage() {
		return this.message;
	}
}
