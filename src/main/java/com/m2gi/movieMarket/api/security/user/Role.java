package com.m2gi.movieMarket.api.security.user;

public enum Role {
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
            case "ROLE_USER":
                return Role.ROLE_USER;
            default:
                throw new InvalidParameterException("Parameters must be a Role enum");
        }
    }
}
