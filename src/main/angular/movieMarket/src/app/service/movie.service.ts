import { Movie } from '../model/movie';
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class MovieService {
  movies: Movie[] = [];

  constructor(private http: Http) { }

  public all(from: number = 0, to: number = 20): Observable<Movie[]> {
    return this.http.get(
      '/api/movies?' + String(from) + "&" + String(to))
      .map(res => res.json()
    );
  }

  public find(id: string): Observable<Movie> {
    return this.http.get(
      'api/movies/' + id)
      .map(res => {
        const resu = res.json();
        console.log(resu);
        return resu;
      }
    );
  }
}
