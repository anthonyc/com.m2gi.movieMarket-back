import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Http, HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

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
import 'hammerjs';
import { CategoryService } from './service/category.service';

export const appRoutes: Routes = [
  { path: 'movies', component: SearchResultContentComponent },
  { path: 'movies/:id', component: MovieDetailComponent },
  { path: '', component: HomePageContentComponent }
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
    MovieHorizontalScrollComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    NgxCarouselModule
  ],
  providers: [
    MovieService,
    CategoryService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
