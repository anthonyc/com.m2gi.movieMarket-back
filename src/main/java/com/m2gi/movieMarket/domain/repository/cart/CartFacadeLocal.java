package com.m2gi.movieMarket.domain.repository.cart;

import com.m2gi.movieMarket.domain.entity.cart.Cart;
import com.m2gi.movieMarket.domain.entity.cart.CartDetail;
import com.m2gi.movieMarket.domain.entity.movie.Movie;

import java.util.List;
import javax.ejb.Local;

@Local
public interface CartFacadeLocal {

    void addMovies(int userId, List<Integer> movieId);

    void remove(Cart cart);
}