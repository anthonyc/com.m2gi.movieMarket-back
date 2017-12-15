package com.m2gi.movieMarket.api.security;

public enum Role {
    ROLE_APP ("ROLE_APP"),
    ROLE_USER("ROLE_USER");

    private String role;

    Role() {}

    Role (String role) {
        this.role = role;
    }

    public boolean hasRole(String role) {
        return this.role == role;
    }

    public String getRole() {
        return this.role;
    }

    public static Role roleFromString(String stringRole) {
        switch (stringRole) {
            case "ROLE_APP":
                return Role.ROLE_APP;
            case "ROLE_USER":
                return Role.ROLE_USER;
            default:
                throw new InvalidParameterException("Parameters must be a Role enum");
        }
    }
}
