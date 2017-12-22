import { BrowserModule } from '@angular/platform-browser';
import {ModuleWithProviders, NgModule} from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { MovieComponent } from './component/movie/movie.component';
import { MovieListComponent } from './component/movie-list/movie-list.component';
import { MovieService } from './service/movie.service';
import { MovieDetailComponent } from './component/movie-detail/movie-detail.component';
import { TopNavBarComponent } from './component/top-nav-bar/top-nav-bar.component';
import { HomePageContentComponent } from './component/home-page-content/home-page-content.component';
import { BreadcrumbComponent } from './component/breadcrumb/breadcrumb.component';
import { SearchResultContentComponent } from './component/search/search.component';
import { MovieHorizontalScrollComponent } from './component/movie-horizontal-scroll/movie-horizontal-scroll.component';
import { NgxCarouselModule } from 'ngx-carousel';
import { CategoryService } from './service/category.service';
import { CartService } from './service/cart.service';
import { CreateUserComponent } from './component/create-user/create-user.component';
import { UserService } from './service/user.service';
import { ShowErrorsComponent } from './component/show-errors/show-errors.component';
import { FormsHelperService } from './service/forms-helper.service';
import { HttpClientModule } from '@angular/common/http';
import { StoreButtonComponentComponent } from './component/store-button-component/store-button-component.component';
import { CartComponent } from './component/cart/cart.component';
import { CartDetailComponent } from './component/cart-detail/cart-detail.component';
import { LoginComponent } from './component/login/login.component';
import {AuthenticateService} from './service/authenticate.service';
import { UserAccountComponent } from './component/user-account/user-account.component';
import { UserMenuComponent } from './component/user-menu/user-menu.component';
import { AddressComponent } from './component/address/address.component';
import { UserAddressComponent } from './component/user-address/user-address.component';
import { UserProfileComponent } from './component/user-profile/user-profile.component';
import { FormAddressComponent } from './component/form-address/form-address.component';
import {AddressService} from './service/address.service';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FooterComponent } from './component/footer/footer.component';
import { OrderComponent } from './component/order/order.component';
import 'hammerjs';
import { SearchResultComponent } from './component/search-result/search-result.component';
import {OrderService} from "./service/order.service";
import { UserOrderComponent } from './component/user-order/user-order.component';


export const routes: Routes = [
  {
    path: '',
    component: HomePageContentComponent,
  },
  {
    path: 'category/movie',
    component: MovieListComponent,
    data: {
      breadcrumb: 'Liste de films'
    },
  },
  {
    path: 'movies/:id',
    component: MovieDetailComponent,
    data: {
      breadcrumb: 'Détail'
    }
  },
  { path: 'cart', component: CartComponent, data: {
      breadcrumb: 'Panier'
    }
  },
  {
    path: 'search',
    component: SearchResultComponent, data: {
      breadcrumb: 'Recherche'
    }
  },
  {
    path: 'user/create',
    component: CreateUserComponent, data: {
      breadcrumb: 'Création utilisateur'
    }
  },
  {
    path: 'account/:id',
    data: {
      breadcrumb: 'Compte'
    },
    children: [
      {
        path: 'profile',
        component: UserProfileComponent,
        data: {
          breadcrumb: 'Profile'
        }
      },
      {
        path: 'address',
        component: UserAddressComponent,
        data: {
          breadcrumb: 'Adresse'
        }
      },
      {
        path: 'order',
        component: UserOrderComponent,
        data: {
          breadcrumb: 'Achat'
        }
      }
    ]
  }
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
    CreateUserComponent,
    ShowErrorsComponent,
    StoreButtonComponentComponent,
    CartComponent,
    CartDetailComponent,
    LoginComponent,
    UserAccountComponent,
    UserMenuComponent,
    AddressComponent,
    UserAddressComponent,
    UserProfileComponent,
    FormAddressComponent,
    FooterComponent,
    OrderComponent,
    SearchResultComponent,
    UserOrderComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule,
    NgxCarouselModule,
    Ng2SearchPipeModule
  ],
  providers: [
    MovieService,
    CategoryService,
    UserService,
    CartService,
    FormsHelperService,
    AuthenticateService,
    AddressService,
    OrderService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
