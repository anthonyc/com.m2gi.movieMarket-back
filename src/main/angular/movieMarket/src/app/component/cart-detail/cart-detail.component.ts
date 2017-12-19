import { CartComponent } from './../cart/cart.component';
import { CartService } from './../../service/cart.service';
import { CartDetail } from './../../model/cart-detail';
import {Component, Input, OnChanges, Output, EventEmitter, OnInit} from '@angular/core';

@Component({
  selector: 'app-cart-detail',
  templateUrl: './cart-detail.component.html',
  styleUrls: ['./cart-detail.component.css']
})
export class CartDetailComponent implements OnChanges, OnInit {

  @Input()
  cartDetail: CartDetail;

  shortDesc: string;

  constructor(private cartService: CartService) {}

  ngOnChanges() { }

  ngOnInit() {
    this.shortDesc = this.cartDetail.movie.description.substring(0, 300);
    if (this.shortDesc.length < this.cartDetail.movie.description.length) {
      let i: number;
      for (i = this.shortDesc.length; this.shortDesc[i] !== ' '; i--) {}
      this.shortDesc = this.shortDesc.substring(0, i);
      this.shortDesc += '...';
    }

  }

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
