import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Address} from "../model/address";
import {Observable} from "rxjs/Observable";
import {Cart} from "../model/cart";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};


@Injectable()
export class OrderService {

  constructor(private http: HttpClient) { }

  public add(cart: Cart, userId: string, addressId: string, jwtToken: string): Observable<Address> {
    httpOptions.headers = httpOptions.headers.append('Authorization', 'Bearer ' + jwtToken);

    return this.http.patch<Address>(
      '/api/address/user/' + userId + '/address/' + addressId, cart,
      httpOptions);
  }
}
