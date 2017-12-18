import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { catchError, map, tap } from 'rxjs/operators';
import { User } from '../model/user';
import { Response } from '@angular/http/src/static_response';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJpZFwiOjEsXCJuYW1lXCI6XCJhcHBcIixcInJvbGVzXCI6W1wiUk9MRV9BUFBcIl19In0.DJnQ-R-nWxjwQ1Xt9j7EEI5LJUf8TsCpV8LAvf1M5DQgXGUigorVsmS0gcoKnxped99pmXyXNQa04kU0C30A8A'
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

}
