package com.m2gi.movieMarket.api.security;

import com.m2gi.movieMarket.api.property.PropertyHandler;

import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import java.security.Key;

final public class KeyGenerator {

    @Inject
    private PropertyHandler propertyHandler;

    private KeyGenerator() {}

    public static Key createKey() {
        String jwtKey = PropertyHandler.getInstance().getValue("jwt.key");
        Key key = new SecretKeySpec(jwtKey.getBytes(), 0, jwtKey.getBytes().length, "DES");

        return key;
    }
}
