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
      '/api/movies?from=' + String(from) + '&to=' + String(to))
      .map(res => res.json()
    );
  }

  public allByCategory(category: String, from: number = 0, to: number = 20): Observable<Movie[]> {
    return this.http.get(
      '/api/movies?category=' + category + '&from=' + String(from) + '&to=' + String(to))
      .map(res => res.json()
    );
  }

  public allByCategoryFilterByName(category: String, from: number = 0, to: number = 20): Observable<Movie[]> {
    return this.http.get(
      '/api/movies?category=' + category + '&order=name' + '&from=' + String(from) + '&to=' + String(to))
      .map(res => res.json()
    );
  }

  public allByCategoryFilterByPriceAsc(category: String, from: number = 0, to: number = 20): Observable<Movie[]> {
    return this.http.get(
      '/api/movies?category=' + category + '&order=price&sort=asc' + '&from=' + String(from) + '&to=' + String(to))
      .map(res => res.json()
    );
  }

  public allByCategoryFilterByPriceDesc(category: String, from: number = 0, to: number = 20): Observable<Movie[]> {
    return this.http.get(
      '/api/movies?category=' + category + '&order=price&sort=desc' + '&from=' + String(from) + '&to=' + String(to))
      .map(res => res.json()
    );
  }

  public find(id: string): Observable<Movie> {
    return this.http.get(
      'api/movies/' + id)
      .map(res => res.json()
    );
  }
}
