import { CartService } from './../../service/cart.service';
import { Component, OnInit, OnChanges, Input } from '@angular/core';
import { Cart } from '../../model/cart';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit, OnChanges {

  cart: Cart;
  affichagePanier = 'Votre panier est vide !';

  constructor(public cartService: CartService) {
    this.cart = this.cartService.get();
  }

  ngOnInit() {}

  ngOnChanges() {
  }

  cartPrice(): number {
    let res = 0;
    const cart = this.cartService.get().cartDetails.forEach(
      cd => res += cd.quantity * cd.movie.price
    );
    return res;
  }

  validate() {
    console.log('Validation du form');
  }

  setBought(event: boolean) {
    this.cartService.clearCart();
    this.affichagePanier = 'Votre panier a été validé';
  }

}
