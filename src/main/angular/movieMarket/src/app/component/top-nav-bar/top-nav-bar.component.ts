import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../../service/category.service';
import { Category } from '../../model/category';
import { CartService } from './../../service/cart.service';
import {AuthenticateService} from "../../service/authenticate.service";

@Component({
  selector: 'app-top-nav-bar',
  templateUrl: './top-nav-bar.component.html',
  styleUrls: ['./top-nav-bar.component.css']
})
export class TopNavBarComponent implements OnInit {
  categories: Category[];
  error = null;
  finished = false;

  constructor(private categoryService: CategoryService,
      public cartService: CartService,
      public authenticateService: AuthenticateService) { }

  ngOnInit() {
    this.categoryService.all().subscribe(
      value => this.categories = value,
      error => this.error = 'movieService.all error',
      () => this.finished = true
    );
  }

}
