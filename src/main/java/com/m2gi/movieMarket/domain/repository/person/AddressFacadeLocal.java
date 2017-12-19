package com.m2gi.movieMarket.domain.repository.person;

import com.m2gi.movieMarket.domain.entity.person.Address;

import javax.ejb.Local;

@Local
public interface AddressFacadeLocal {
    int create(Address address, int userId);
}
