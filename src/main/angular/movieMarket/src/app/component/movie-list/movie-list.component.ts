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
  filter: String ;
  sub;
  movies: Movie[] = [];
  finished: Boolean = false;
  error: string;
  from = 0;
  to = 200;

  constructor( private movieService: MovieService, private route: ActivatedRoute, private router: Router) {

    this.route.queryParams.subscribe(params => {
      this.categoryName = params['category'];
      this.filter = params['order'];

      this.ngOnInit();
    });
  }

  changeFilter(event) {
    console.log(event.target.value);
    this.filter = event.target.value;
  }

  filtre() {
    this.router.navigate(['/category/movie/'], { queryParams: { category: this.categoryName, order: this.filter } });
  }

  ngOnInit() {
    if (!this.filter) {
      this.filter = '';

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

    if (this.filter === 'date') {
      this.movieService.allByCategoryFilterByPriceDesc(this.categoryName, this.from, this.to).subscribe(
        value => this.movies = value,
        error => this.error = 'movieService.all error',
        () => this.finished = true
      );
    }
  }
}
