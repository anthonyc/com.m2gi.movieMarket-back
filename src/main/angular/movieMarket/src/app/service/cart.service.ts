import { Injectable } from '@angular/core';
import { LocalStorageService } from 'angular-2-local-storage';
import { Movie } from '../model/movie';
import { Cart } from '../model/cart';

@Injectable()
export class CartService {

  constructor(private localStorageService: LocalStorageService) { }

  public addMovie(movie: Movie) {
    let cart: Cart = this.get();
    if (!(cart instanceof Cart)) {
      cart = new Cart();
    }

    cart.addMovie(movie);

    this.localStorageService.add('cart', cart);
  }

  public get(): Cart {
    const cart = new Cart();
    if (this.localStorageService.get('cart') != null) {
      cart.setCartDetail((this.localStorageService.get('cart') as Cart).cartDetails);
    }

    return cart;
  }
}
