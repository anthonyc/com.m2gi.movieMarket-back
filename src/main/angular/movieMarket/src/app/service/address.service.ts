import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Address} from '../model/address';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};


@Injectable()
export class AddressService {

  constructor(private http: HttpClient) { }

  public add(address: Address, userId: string, jwtToken: string): Observable<number> {
    httpOptions.headers = httpOptions.headers.append('Authorization', 'Bearer ' + jwtToken);

    return this.http.post<number>(
      '/api/address/user/' + userId, address,
      httpOptions);
  }

  public remove(address: Address, userId: string, jwtToken: string) {
    httpOptions.headers = httpOptions.headers.append('Authorization', 'Bearer ' + jwtToken);
    this.http.delete<Address>('/api/address/' + address.id + '/user/' + userId, httpOptions);
  }
}
