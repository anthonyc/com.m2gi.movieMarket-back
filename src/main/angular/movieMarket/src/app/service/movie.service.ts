import { Movie } from '../model/movie';
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class MovieService {
  movies: Movie[] = [];

  constructor(private http: Http) { }

  public all(): Observable<Movie[]> {
    return this.http.get (
      'http://localhost:8080/movieMarket-0.0.1/ws/movies')
      .map(res => {
        let resultat = res.json();

        return resultat._embedded.movies;
      });
  }
}
