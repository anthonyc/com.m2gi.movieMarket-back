import { Movie } from './../../model/movie';
import { MovieService } from './../../service/movie.service';
import { Component, OnInit, Input } from '@angular/core';
import { NgxCarousel } from 'ngx-carousel';

@Component({
  selector: 'app-movie-horizontal-scroll',
  templateUrl: './movie-horizontal-scroll.component.html',
  styleUrls: ['./movie-horizontal-scroll.component.css']
})
export class MovieHorizontalScrollComponent implements OnInit {
  @Input() categoryName: String;
  @Input() from: number;
  @Input() to: number;
  @Input() title: String;

  movies: Movie[] = [];
  error = null;
  finished = false;

  public carouselTile: NgxCarousel;

  constructor(private movieService: MovieService) { }

  ngOnInit() {

    this.carouselTile = {
      grid: {xs: 2, sm: 3, md: 3, lg: 5, all: 0},
      slide: 2,
      speed: 400,
      animation: 'lazy',
      point: {
        visible: true
      },
      load: 2,
      touch: true,
      easing: 'ease',
    };

    this.movieService.allByCategory(this.categoryName, this.from, this.to).subscribe(
      value => this.movies = value,
      error => this.error = 'movieService.all error',
      () => this.finished = true
    );
  }

  carouselTileLoad(evt: any) {

  }
}
