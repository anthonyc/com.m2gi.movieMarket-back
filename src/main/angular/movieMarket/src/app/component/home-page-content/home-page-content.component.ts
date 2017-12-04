import { Movie } from './../../model/movie';
import { MovieService } from './../../service/movie.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page-content',
  templateUrl: './home-page-content.component.html',
  styleUrls: ['./home-page-content.component.css']
})
export class HomePageContentComponent implements OnInit {
    name: String;

    sections: String[] = ['Featured', 'Pour vous'];

    constructor(private movieService: MovieService) {
        this.name = 'home Page';
    }

    ngOnInit() {
    }
}
