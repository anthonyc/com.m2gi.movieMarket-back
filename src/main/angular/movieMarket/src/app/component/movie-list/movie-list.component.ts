import { Movie } from '../../model/movie';
import { MovieService } from '../../service/movie.service';
import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Subject } from 'rxjs/Subject';


@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {
  @Input() categoryName: String = this.route.snapshot.paramMap.get('category');
  @Input() filter: String = this.route.snapshot.paramMap.get('filter');
  movies: Movie[] = [];
  finished: Boolean = false;
  error: string;
  from: 0;
  to: 20;


  constructor(private movieService: MovieService, private route: ActivatedRoute, private router: Router) {
    this.route.params.subscribe(params => {
      this.categoryName = params['category'];
      this.filter = params['filter'];
      this.ngOnInit();
    });
   }

  ngOnInit() {
    if (!this.filter) {
      this.movieService.allByCategory(this.categoryName, this.from, this.to).subscribe(
        value => this.movies = value,
        error => this.error = 'movieService.all error',
        () => this.finished = true
      );
    }

    if (this.filter === 'name') {
      this.movieService.allByCategoryFilterByName(this.categoryName, this.from, this.to).subscribe(
        value => this.movies = value,
        error => this.error = 'movieService.all error',
        () => this.finished = true
      );
    }

    if (this.filter === 'priceasc') {
      this.movieService.allByCategoryFilterByPriceAsc(this.categoryName, this.from, this.to).subscribe(
        value => this.movies = value,
        error => this.error = 'movieService.all error',
        () => this.finished = true
      );
    }

    if (this.filter === 'pricedesc') {
      this.movieService.allByCategoryFilterByPriceDesc(this.categoryName, this.from, this.to).subscribe(
        value => this.movies = value,
        error => this.error = 'movieService.all error',
        () => this.finished = true
      );
    }
  }
}
