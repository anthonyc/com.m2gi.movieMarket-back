import { CartService } from './../../service/cart.service';
import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../../model/movie';
import { Cart } from '../../model/cart';

@Component({
  selector: 'app-store-button-component',
  templateUrl: './store-button-component.component.html',
  styleUrls: ['./store-button-component.component.css']
})
export class StoreButtonComponentComponent implements OnInit {

  @Input() movie: Movie;
  inCart: number;
  private cs: CartService;

  constructor() {
    this.cs = new CartService();
  }

  ngOnInit() {
    this.updateNumber();
  }

  addMovie(event) {
    this.cs.addMovie(this.movie);
    this.updateNumber();
  }

  private updateNumber() {
    for (const cartDetail of this.cs.get().cartDetails) {
      if (cartDetail.movie.name === this.movie.name) {
        this.inCart = cartDetail.quantity;
        return;
      }
    }
    this.inCart = 0;
  }


}
