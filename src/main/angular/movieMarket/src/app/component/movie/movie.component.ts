import { Movie } from '../../model/movie';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {
  @Input() public movie: Movie;

  constructor() { }

  ngOnInit() {
  }

}
