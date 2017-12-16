import { CartDetail } from './../../model/cart-detail';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-cart-detail',
  templateUrl: './cart-detail.component.html',
  styleUrls: ['./cart-detail.component.css']
})
export class CartDetailComponent implements OnInit {

  @Input()
  element: CartDetail;

  constructor() {
  }

  ngOnInit() {
  }


}
