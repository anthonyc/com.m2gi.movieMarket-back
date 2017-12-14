import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../../model/movie';

@Component({
  selector: 'app-store-button-component',
  templateUrl: './store-button-component.component.html',
  styleUrls: ['./store-button-component.component.css']
})
export class StoreButtonComponentComponent implements OnInit {

  @Input() movie: Movie;
  priceString: String;

  constructor() { }

  ngOnInit() {
        // TODO: check what currency the user is using

    this.priceString = this.movie.price.toString();
    if (this.priceString.indexOf('.') <= 0) {
      this.priceString += '.00';
      console.log(this.priceString);
    }
    this.priceString += '€';
  }

}
