import { Injectable } from '@angular/core';
import { Movie } from '../model/movie';
import { Cart } from '../model/cart';
import {LocalStorage, SessionStorage} from 'angular-localstorage';

@Injectable()
export class CartService {

  @LocalStorage() private cart: Cart = new Cart();
  constructor() { }

  public addMovie(movie: Movie) {
    this.cart.addMovie(movie);
  }

  public get(): Cart {
    return this.cart;
  }
}
