import { CartService } from './../../service/cart.service';
import { Component, OnInit, Input } from '@angular/core';
import { Cart } from '../../model/cart';

@Component({
  selector: 'app-top-nav-bar',
  templateUrl: './top-nav-bar.component.html',
  styleUrls: ['./top-nav-bar.component.css']
})
export class TopNavBarComponent implements OnInit {

  title;

  constructor(private cartService: CartService) {
    this.title = 'Movie Market';
  }

  ngOnInit() {
  }
}
