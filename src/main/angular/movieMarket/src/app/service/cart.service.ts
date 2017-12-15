import { Injectable } from '@angular/core';
import { LocalStorageService } from 'angular-2-local-storage';
import { Movie } from '../model/movie';
import { Cart } from '../model/cart';

@Injectable()
export class CartService {

  constructor(private localStorageService: LocalStorageService) { }

  public addMovie(movie: Movie) {
    let cart: Cart = this.get();
    console.log(cart);
    if (!(cart instanceof Cart)) {
      cart = new Cart();
      console.log('if plop');
    }

    cart.addMovie(movie);

    this.localStorageService.add('cart', cart);
  }

  public get(): Cart {
    let cart = new Cart();
    cart.addMovies((this.localStorageService.get('cart') as Cart).movies);
    
    return cart;
  }
}
