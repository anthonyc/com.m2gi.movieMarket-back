import { Injectable } from '@angular/core';
import { Movie } from '../model/movie';
import { Cart } from '../model/cart';
import {CartDetail} from '../model/cart-detail';


@Injectable()
export class CartService {

  constructor() {}

  public get(): Cart {
    const cartStorage = localStorage.getItem('cart');

    if (cartStorage == null) {
      return new Cart();
    }

    const cart =  new Cart();
    cart.copy(JSON.parse(cartStorage) as Cart);

    if (!cart.hasMovie()) {
      return null;
    }

    return cart;
  }

  public addMovie(movie: Movie): CartDetail {
    const cart = this.get();
    cart.addMovie(movie);
    localStorage.setItem('cart', JSON.stringify(cart));

    return this.findCartDetailByMovie(movie);
  }

  public removeMovie(movie: Movie): CartDetail {
    const cart = this.get();

    cart.removeMovie(movie);

    if (cart.hasMovie()) {
      localStorage.setItem('cart', JSON.stringify(cart));

      return this.findCartDetailByMovie(movie);
    }

    localStorage.removeItem('cart');
    return null;
  }

  private findCartDetailByMovie(movie: Movie): CartDetail {
    const cart = this.get();

    for (const cartDetail of cart.cartDetails) {
      if (cartDetail.movie.id === movie.id) {
        return cartDetail;
      }
    }

    return null;
  }

  public clearCart() {
    localStorage.removeItem('cart');
  }


}
