import { Movie } from './../../model/movie';
import { MovieService } from './../../service/movie.service';
import { Component, OnInit, Input } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-search-result-content',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchResultContentComponent implements OnInit {
  categoryName: String = 'Action';
  movies: Movie[] = [];
  error = null;
  finished = false;
  searchText: string = '';

  constructor(private movieService: MovieService, private router: Router) { }

  ngOnInit() {

      this.movieService.all(0, 200).subscribe(
        value => this.movies = value,
        error => this.error = 'movieService.all error',
        () => this.finished = true
      );
  }

  search(linkText: string) {
    let name = this.searchText;
    this.searchText = '';

    if (linkText) {
      name = linkText;
    }

    this.router.navigate(['/search'], { queryParams: { name: name } });
  }

}
