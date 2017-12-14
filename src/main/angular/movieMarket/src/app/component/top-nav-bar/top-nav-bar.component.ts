import { CartService } from './../../service/cart.service';
import { Component, OnInit } from '@angular/core';
import { Cart } from '../../model/cart';

@Component({
  selector: 'app-top-nav-bar',
  templateUrl: './top-nav-bar.component.html',
  styleUrls: ['./top-nav-bar.component.css']
})
export class TopNavBarComponent implements OnInit {

  title;

  constructor(private cs: CartService) {
    this.title = 'Movie Market';
  }

  ngOnInit() {
  }
}
