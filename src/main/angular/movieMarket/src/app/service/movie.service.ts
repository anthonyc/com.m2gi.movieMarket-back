import { Movie } from '../model/movie';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable()
export class MovieService {
  movies: Movie[] = [];

  constructor(private http: HttpClient) { }

  public all(from: number = 0, to: number = 20): Observable<Movie[]> {
    return this.http.get<Movie[]>(
      '/api/movies?from=' + String(from) + '&to=' + String(to), httpOptions)
      .map(res => res
    );
  }

  public allByCategory(category: String, from: number = 0, to: number = 20): Observable<Movie[]> {
    return this.http.get<Movie[]>(
      '/api/movies?category=' + category + '&from=' + String(from) + '&to=' + String(to), httpOptions)
      .map(res => res
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
    return this.http.get<Movie>(
      'api/movies/' + id)
      .map(res => res
    );
  }
}
