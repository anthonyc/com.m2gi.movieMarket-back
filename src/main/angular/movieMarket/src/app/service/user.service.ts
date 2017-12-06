import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class UserService {

  constructor(private http:Http) { }

  public create() {
    this.http.put(
      '/api/user', {
        'gender': 0,
        'lastname': 'toto',
        'firstname': 'totof',
        'username': 'username',
        'email': 'email',
        'password': 'monpass'
      });
  }

}
