import { CartComponent } from './../cart/cart.component';
import { CartService } from './../../service/cart.service';
import { CartDetail } from './../../model/cart-detail';
import {Component, Input, OnChanges, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-cart-detail',
  templateUrl: './cart-detail.component.html',
  styleUrls: ['./cart-detail.component.css']
})
export class CartDetailComponent implements OnChanges {

  @Input()
  cartDetail: CartDetail;

  constructor(private cartService: CartService) {}

  ngOnChanges() { }

  addMovie() {
    this.cartDetail = this.cartService.addMovie(this.cartDetail.movie);
  }

  removeMovie() {
    return this.cartDetail = this.cartService.removeMovie(this.cartDetail.movie);
  }

  removeAllMovies() {
    let r = this.removeMovie();
    while (r != null) {
      r = this.removeMovie();
    }
  }
}
