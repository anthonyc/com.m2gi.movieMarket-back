import { Movie } from '../../model/movie';
import { MovieService } from '../../service/movie.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {
  movies: Movie[] = [];
  finished: boolean = false;
  error: string;

  constructor(private movieService: MovieService) { }

  ngOnInit() {
    this.movieService.all().subscribe(
      value => this.movies = value,
      error => this.error = "movieService.all error",
      () => this.finished = true
    );
  }

}
