import { CartService } from './../../service/cart.service';
import { Component, OnInit } from '@angular/core';
import { Cart } from '../../model/cart';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cart: Cart;
  constructor(private cs: CartService) {
    this.cart = this.cs.get();
  }

  ngOnInit() {
  }

}
