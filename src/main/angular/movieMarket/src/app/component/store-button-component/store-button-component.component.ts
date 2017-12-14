import { CartService } from './../../service/cart.service';
import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../../model/movie';

@Component({
  selector: 'app-store-button-component',
  templateUrl: './store-button-component.component.html',
  styleUrls: ['./store-button-component.component.css']
})
export class StoreButtonComponentComponent implements OnInit {

  @Input() movie: Movie;

  constructor(private cs: CartService) { }

  ngOnInit() {
  }

  test(event) {
    this.cs.addMovie(this.movie);
    console.log(this.cs.get().toString());
  }
}
