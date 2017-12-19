import { Movie } from '../../model/movie';
import { MovieService } from '../../service/movie.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {
  categoryName: String = this.route.snapshot.paramMap.get('category');
  movies: Movie[] = [];
  finished: Boolean = false;
  error: string;
  from: 0;
  to: 20;

  constructor(private movieService: MovieService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.movieService.allByCategory(this.categoryName, this.from, this.to).subscribe(
      value => this.movies = value,
      error => this.error = 'movieService.all error',
      () => this.finished = true
    );
  }
}
