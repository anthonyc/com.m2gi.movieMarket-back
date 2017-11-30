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
  @Input() public movies: Movie[];

  // @Input() public nbLines: number;
  private nbColumns: number;

  public iteratorCol: number[] = [];

  constructor() {
  }

  ngOnInit() {
    // this.nbColumns = Math.round(this.movies.length / this.nbLines);


    for (let i = 0; i < this.movies.length; i++) {
      this.iteratorCol[i] = i;
    }
  }
}
