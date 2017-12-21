import { AddressService } from './../../service/address.service';
import { Component, OnInit } from '@angular/core';
import {AuthenticateService} from '../../service/authenticate.service';
import {UserService} from '../../service/user.service';
import {ActivatedRoute} from '@angular/router';
import {User} from '../../model/user';
import {Address} from '../../model/address';

@Component({
  selector: 'app-user-address',
  templateUrl: './user-address.component.html',
  styleUrls: ['./user-address.component.css']
})
export class UserAddressComponent implements OnInit {
  user: User;
  addresses: Address[];
  userId: string;
  finished = false;
  error: string;

  constructor(private userService: UserService,
              private authenticateService: AuthenticateService,
              private addressService: AddressService,
              private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.userId = params['id']
    });
  }

  ngOnInit() {
    this.userService.find(this.userId, this.authenticateService.get().token).subscribe(
      value => {
        this.user = value;
        this.addresses = this.user.addresses;
      },
      error => this.error = 'movieService.find error',
      () => this.finished = true
    );
  }

  removeAddress(index: number) {
    console.log(index);
    this.addressService.remove(this.addresses[index], this.user.id.toString(), this.user.jwtToken);
  }

}
