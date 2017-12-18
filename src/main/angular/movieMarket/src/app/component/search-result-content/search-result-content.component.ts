import { Movie } from './../../model/movie';
import { MovieService } from './../../service/movie.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-search-result-content',
  templateUrl: './search-result-content.component.html',
  styleUrls: ['./search-result-content.component.css']
})
export class SearchResultContentComponent implements OnInit {
  categoryName: String = 'Action';
  movies: Movie[] = [];
  error = null;
  finished = false;

  constructor(private movieService: MovieService) { }

  ngOnInit() {

    // this.movieService.allByCategory(this.categoryName, this.from, this.to).subscribe(
    //   value => this.movies = value,
    //   error => this.error = 'movieService.all error',
    //   () => this.finished = true
    // );
  }

}
