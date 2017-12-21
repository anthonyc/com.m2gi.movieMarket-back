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

  add: string;
  remove: string;

  constructor(private cartService: CartService) {}


  ngOnChanges() {
  }

  ngOnInit() {
    this.shortDesc = this.cartDetail.movie.description.substring(0, 300);
    if (this.shortDesc.length < this.cartDetail.movie.description.length) {
      let i: number;
      for (i = this.shortDesc.length; this.shortDesc[i] !== ' '; i--) {}
      this.shortDesc = this.shortDesc.substring(0, i);
      this.shortDesc += '...';
    }

    this.updateQuantityButtons();
  }

  addMovie() {
    if (this.cartDetail === null) {
      return;
    }
    if (this.cartDetail.quantity < this.cartDetail.movie.quantity) {
      this.cartDetail = this.cartService.addMovie(this.cartDetail.movie);
      this.updateQuantityButtons();
    }
    return this.cartDetail;
  }

  removeMovie() {
    if (this.cartDetail === null) {
      return;
    }
    if (this.cartDetail.quantity > 1) {
      this.cartDetail = this.cartService.removeMovie(this.cartDetail.movie);
      this.updateQuantityButtons();
    }
    return this.cartDetail;
  }

  removeAllMovies() {
    do {
      this.cartDetail = this.cartService.removeMovie(this.cartDetail.movie);
    } while (this.cartDetail != null);
  }

  private updateQuantityButtons() {
    console.log('Updating quantity : ' + this.cartDetail.quantity);
    this.add = (this.cartDetail.quantity >= this.cartDetail.movie.quantity) ? 'disabled' : '';
    this.remove = (this.cartDetail.quantity === 1) ? 'disabled' : '';
  }
}
