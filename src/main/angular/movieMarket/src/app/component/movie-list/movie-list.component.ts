import { Movie } from '../../model/movie';
import { MovieService } from '../../service/movie.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {
  finished = false;
  error: string;

  @Input() public titre: String;
  @Input() public movies: Array<Movie>;

  // @Input() public nbLines: number;
  public iteratorCol: number[] = [];

  constructor() {
  }

  ngOnInit() {
    for (let i = 0; i < this.movies.length; i++) {
      this.iteratorCol[i] = i;
    }
  }
}
