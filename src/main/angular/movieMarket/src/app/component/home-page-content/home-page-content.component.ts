import { Category } from './../../model/category';
import { CategoryService } from './../../service/category.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page-content',
  templateUrl: './home-page-content.component.html',
  styleUrls: ['./home-page-content.component.css']
})
export class HomePageContentComponent implements OnInit {
    name: String;
    categories: Category[];
    error = null;
    finished = false;

    sections: String[] = ['Featured', 'Pour vous'];

    constructor(private categoryService: CategoryService) {
        this.name = 'home Page';
    }

    ngOnInit() {
        this.categoryService.all(0, 5).subscribe(
            value => this.categories = value,
            error => this.error = 'movieService.all error',
            () => {
                this.finished = true;
            }
        );
    }
}
