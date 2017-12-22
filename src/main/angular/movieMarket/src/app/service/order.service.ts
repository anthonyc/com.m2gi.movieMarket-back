import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Cart} from '../model/cart';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};


@Injectable()
export class OrderService {

  constructor(private http: HttpClient) { }

  public add(cart: Cart, userId: string, addressId: string, jwtToken: string): Observable<number> {
    httpOptions.headers = httpOptions.headers.append('Authorization', 'Bearer ' + jwtToken);

    return this.http.patch<number>(
      '/api/order/user/' + userId + '/address/' + addressId, cart,
      httpOptions);
  }

  public all(userId, jwtToken): Observable<Order[]> {
    httpOptions.headers = httpOptions.headers.append('Authorization', 'Bearer ' + jwtToken);

    return this.http.get<Order[]>(
      '/api/order/user/' + userId, httpOptions)
      .map(res => res
    );
  }
}
