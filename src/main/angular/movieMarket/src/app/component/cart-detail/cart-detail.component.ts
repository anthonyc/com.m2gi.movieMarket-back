import { CartService } from './../../service/cart.service';
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

  @Input()
  idx: number;

  constructor(private cs: CartService) {
  }

  ngOnInit() {
    console.log(this.idx);
  }

  test(event) {
    console.log(event);
  }

  valueChanged(event) {
    console.log(event.target.value);
    this.element.quantity = event.target.value;
  }
}
