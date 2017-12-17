import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../../service/category.service';
import { Category } from '../../model/category';

@Component({
  selector: 'app-top-nav-bar',
  templateUrl: './top-nav-bar.component.html',
  styleUrls: ['./top-nav-bar.component.css']
})
export class TopNavBarComponent implements OnInit {
  categories: Category[];
  error = null;
  finished = false;

  constructor(private categoryService: CategoryService) { }

  ngOnInit() {
    this.categoryService.all().subscribe(
      value => this.categories = value,
      error => this.error = 'movieService.all error',
      () => this.finished = true
  );
  }

}
