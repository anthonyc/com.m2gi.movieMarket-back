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
      '/ws/movies')
      .map(res => res.json()
    );
  }
}
