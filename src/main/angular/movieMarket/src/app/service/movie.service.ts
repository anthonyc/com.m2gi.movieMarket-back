import { Movie } from '../model/movie';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json',
    'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJpZFwiOjEsXCJuYW1lXCI6XCJhcHBcIixcInJvbGVzXCI6W1wiUk9MRV9BUFBcIl19In0.DJnQ-R-nWxjwQ1Xt9j7EEI5LJUf8TsCpV8LAvf1M5DQgXGUigorVsmS0gcoKnxped99pmXyXNQa04kU0C30A8A'})
};

@Injectable()
export class MovieService {
  movies: Movie[] = [];
  
  constructor(private http: HttpClient) { }

  public all(from: number = 0, to: number = 20): Observable<any> {
    return this.http.get(
      '/api/movies?from=' + String(from) + "&to=" + String(to), httpOptions)
      .map(res => res
    );
  }

  public allByCategory(category: String, from: number = 0, to: number = 20): Observable<any> {
    return this.http.get(
      '/api/movies?category=' + category +'&from=' + String(from) + "&to=" + String(to), httpOptions)
      .map(res => res
    );
  }

  public find(id: string): Observable<any> {
    return this.http.get(
      'api/movies/' + id)
      .map(res => res
    );
  }
}
