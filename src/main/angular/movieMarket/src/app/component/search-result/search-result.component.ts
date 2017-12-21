import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {MovieService} from "../../service/movie.service";
import {Movie} from "../../model/movie";

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {
  movies: Movie[];
  info = null;
  error = null;
  finished = false;
  searchText: String;

  constructor(private route: ActivatedRoute, private movieService: MovieService) {
    this.route.queryParamMap.subscribe(
      params => {
        this.searchText = params.get('name');
        this.ngOnInit();
      }
    );
  }

  ngOnInit() {
    this.movieService.search(this.searchText).subscribe(
      value => this.movies = value,
      err => this.error = err,
      () => this.finished
    );
  }

}
