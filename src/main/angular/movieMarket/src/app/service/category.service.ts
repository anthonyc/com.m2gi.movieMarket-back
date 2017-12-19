import { Category } from '../model/category';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable()
export class CategoryService {
  categories: Category[] = [];

  constructor(private http: HttpClient) { }

  public all(from: number = 0, to: number = 20): Observable<Category[]> {
    return this.http.get<Category[]>(
      '/api/categories?from=' + String(from) + "&to=" + String(to), httpOptions)
      .map(res => res
    );
  }

}
