import { Injectable } from '@angular/core';
import { Movie } from '../model/movie';
import { Cart } from '../model/cart';


@Injectable()
export class CartService {


  constructor() {}

  public addMovie(movie: Movie) {
    const cart = this.get();
    cart.addMovie(movie);
    localStorage.setItem('cart', JSON.stringify(cart));
  }

  public get(): Cart {
    const cart = localStorage.getItem('cart');
    if (cart == null) {
      return new Cart();
    } else {
      const r =  new Cart();
      r.copy(JSON.parse(cart) as Cart);
      return r;
    }
  }
}
