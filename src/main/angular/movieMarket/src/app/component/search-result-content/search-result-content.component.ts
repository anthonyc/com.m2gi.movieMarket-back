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
  searchText: string = '';

  characters = [
    'Finn the human',
    'Jake the dog',
    'Princess bubblegum',
    'Lumpy Space Princess',
    'Beemo1',
    'Beemo2'
  ]

  constructor(private movieService: MovieService) { }

  ngOnInit() {

      this.movieService.all(0, 200).subscribe(
        value => this.movies = value,
        error => this.error = 'movieService.all error',
        () => this.finished = true
      );
  }

  searchVisibility() {
    if (this.searchText.length >= 3) {
      console.log('plop');
    }
  }

}
