import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { catchError, map, tap } from 'rxjs/operators';
import { User } from '../model/user';
import { Response } from '@angular/http/src/static_response';
import { RequestOptions } from '@angular/http/src/base_request_options';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

  constructor(private http:HttpClient) { }

  public create(user: User): Observable<any> {
    return this.http.put(
      '/api/user', user,
      httpOptions)
      .map(res => res
    );
  }

}
