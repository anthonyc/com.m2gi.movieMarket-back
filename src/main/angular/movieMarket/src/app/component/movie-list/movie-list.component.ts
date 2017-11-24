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

  @Input() public nbLines: number;
  public nbColumns: number;

  public iteratorLines: number[] = [];
  public columnLength: Array<number[]> = [];

  constructor() {
  }

  ngOnInit() {
    this.nbColumns = Math.round(this.movies.length / this.nbLines);

    console.log(this.titre + ' ' + this.movies.length.toString());
    for (let i = 0; i < this.nbLines; i++) {
      this.iteratorLines[i] = i;
      this.columnLength[i] = new Array();
    }

    for (let i = 0; i < this.movies.length; i++) {
      const line = Math.trunc(i / this.nbColumns);
      // console.log('i = ' + i.toString() + ' ; nbCol = ' + this.nbColumns.toString());
      this.columnLength[line][i % this.nbColumns] = i;
      console.log(this.columnLength[line]);
    }

  }

}
