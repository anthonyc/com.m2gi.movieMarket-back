import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {AddressService} from "../../service/address.service";
import {ActivatedRoute} from "@angular/router";
import {AuthenticateService} from "../../service/authenticate.service";
import {User} from "../../model/user";
import {Address} from "../../model/address";
import Order = jasmine.Order;
import {OrderService} from "../../service/order.service";

@Component({
  selector: 'app-user-order',
  templateUrl: './user-order.component.html',
  styleUrls: ['./user-order.component.css']
})
export class UserOrderComponent implements OnInit {
  user: User;
  orders: Order[];
  userId: string;
  finished = false;
  error: string;

  constructor(private userService: UserService,
              private authenticateService: AuthenticateService,
              private orderService: OrderService,
              private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.userId = params['id']
    });
  }

  ngOnInit() {
  }

}
