import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { catchError, map, tap } from 'rxjs/operators';
import { User } from '../model/user';
import { Response } from '@angular/http/src/static_response';
import {log} from "util";
import {Authenticate} from "../model/authenticate";
import {Movie} from "../model/movie";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

const httpOptionsForm = {
  headers: new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded'
  })
};

@Injectable()
export class UserService {

  constructor(private http: HttpClient) { }

  public create(user: User): Observable<User> {
    return this.http.post<User>(
      '/api/user', user,
      httpOptions);
  }

  public login(login: string, password: string): Observable<Authenticate> {
    const body = new HttpParams()
      .set('login', login)
      .set('password', password);

    return this.http.post<Authenticate>(
      '/api/authenticate', body.toString(),
      httpOptionsForm
    );
  }

  public find(id: string, jwtToken): Observable<User> {
    if (!httpOptions.headers.has('Authorization')) {
      httpOptions.headers = httpOptions.headers.append('Authorization', 'Bearer ' + jwtToken);
    }

    return this.http.get<User>(
      'api/user/' + id,
        httpOptions
      )
      .map(res => {
        let user: User = res;
        user.jwtToken = jwtToken;

        return user;
      }
    );
  }
}
