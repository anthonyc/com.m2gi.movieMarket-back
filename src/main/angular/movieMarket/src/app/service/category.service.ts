import { Category } from '../model/category';
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class CategoryService {
  categories: Category[] = [];

  constructor(private http: Http) { }

  public all(from: number = 0, to: number = 20): Observable<Category[]> {
    return this.http.get(
      '/api/categories?from=' + String(from) + "&to=" + String(to))
      .map(res => res.json()
    );
  }

}
