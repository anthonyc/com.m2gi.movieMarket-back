import { CartService } from './../../service/cart.service';
import { CartDetail } from './../../model/cart-detail';
import {Component, Input, OnChanges} from '@angular/core';

@Component({
  selector: 'app-cart-detail',
  templateUrl: './cart-detail.component.html',
  styleUrls: ['./cart-detail.component.css']
})
export class CartDetailComponent implements OnChanges {

  @Input()
  cartDetail: CartDetail;

  @Input()
  idx: number;

  constructor(private cartService: CartService) {}

  ngOnChanges() { }

  addMovie() {
    this.cartDetail = this.cartService.addMovie(this.cartDetail.movie);
  }

  removeMovie() {
    this.cartDetail = this.cartService.removeMovie(this.cartDetail.movie);
  }
}
