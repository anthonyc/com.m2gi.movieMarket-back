import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Http, HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LocalStorageModule } from 'angular-2-local-storage';

import { AppComponent } from './app.component';
import { MovieComponent } from './component/movie/movie.component';
import { MovieListComponent } from './component/movie-list/movie-list.component';
import { MovieService } from './service/movie.service';
import { MovieDetailComponent } from './component/movie-detail/movie-detail.component';
import { TopNavBarComponent } from './component/top-nav-bar/top-nav-bar.component';
import { HomePageContentComponent } from './component/home-page-content/home-page-content.component';
import { BreadcrumbComponent } from './component/breadcrumb/breadcrumb.component';
import { SearchResultContentComponent } from './component/search-result-content/search-result-content.component';
import { MovieHorizontalScrollComponent } from './component/movie-horizontal-scroll/movie-horizontal-scroll.component';
import { NgxCarouselModule } from 'ngx-carousel';
import { CategoryService } from './service/category.service';
import { CartService } from './service/cart.service';
import { CreateUserComponent } from './component/create-user/create-user.component';
import 'hammerjs';
import { UserService } from './service/user.service';
import { HttpClientModule } from '@angular/common/http';

export const appRoutes: Routes = [
  { path: '', component: HomePageContentComponent },
  { path: 'movies', component: SearchResultContentComponent },
  { path: 'movies/:id', component: MovieDetailComponent },
  { path: 'user/create', component: CreateUserComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    MovieComponent,
    MovieListComponent,
    MovieDetailComponent,
    TopNavBarComponent,
    HomePageContentComponent,
    BreadcrumbComponent,
    SearchResultContentComponent,
    MovieHorizontalScrollComponent,
    CreateUserComponent
  ],
  imports: [
    LocalStorageModule.withConfig({
      prefix: 'movie-market',
      storageType: 'localStorage'
    }),
    BrowserModule,
    HttpModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    NgxCarouselModule
  ],
  providers: [
    MovieService,
    CategoryService,
    UserService,
    CartService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
