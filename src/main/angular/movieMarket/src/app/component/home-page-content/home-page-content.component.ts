import { Movie } from './../../model/movie';
import { MovieService } from './../../service/movie.service';
import { ContentSpace } from './../../model/content-space';
import { ArianeComponent } from './../ariane/ariane.component';
import { TopNavBarComponent } from '../top-nav-bar/top-nav-bar.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page-content',
  templateUrl: './home-page-content.component.html',
  styleUrls: ['./home-page-content.component.css']
})
export class HomePageContentComponent implements OnInit, ContentSpace {
    ariane: ArianeComponent;
    name: String;

    all_movies: Movie[] = [];
    error = null;
    finished = false;

    sections: String[] = ['Featured', 'Pour vous'];
    section_movies: Movie[][] = [[]];

    constructor(private movieService: MovieService) {
        this.name = 'home Page';
    }

    ngOnInit() {
        // Only for testing purposes
        const all_movies: Movie[] = [];
        for (let i = 0; i < 19; i++) {
            const m = new Movie();
            m.description = i.toString();
            m.id = i;
            m.name = i.toString();
            m.img = '';
            all_movies[i] = m;
        }
        /*this.movieService.all().subscribe(
            value => all_movies = value,
            error => this.error = 'movieService.all error',
            () => this.finished = true
          );
          */

        // Cut the list into smaller sub arrays to feed to sections for testing purposes
        const nb_movie_per_section = 10;
        for (let i = 0, j = all_movies.length; i * nb_movie_per_section < j; i++) {
        this.section_movies[i] = all_movies.slice(i * nb_movie_per_section,
            Math.min((i + 1) * nb_movie_per_section, all_movies.length));
        }
    }
}
