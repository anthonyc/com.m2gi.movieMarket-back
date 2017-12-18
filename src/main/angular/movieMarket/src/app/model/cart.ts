import { Movie } from './movie';
import { CartDetail } from './cart-detail';

export class Cart {
    id: number;
    cartDetails: CartDetail[] = [];

    constructor () {}

    public addMovie(movie: Movie) {
        for (const cartDetail of this.cartDetails) {
            if (movie.id === cartDetail.movie.id) {
                cartDetail.quantity++;
                return;
            }
        }

        const cartDetail = new CartDetail(movie);
        this.cartDetails.push(cartDetail);
    }

    public addMovies(movies: Movie[]) {
        for (const m of movies) {
            this.addMovie(m);
        }
    }

    public hasMovie(): boolean {
      if (this.cartDetails.length > 0) {
        return true;
      }

      return false;
    }

    public setCartDetail(movies: CartDetail[]) {
        this.cartDetails = movies;
    }

    public removeMovie(movie: Movie) {
        this.cartDetails.forEach((cartDetail, key) => {
            if (cartDetail.movie.id === movie.id && cartDetail.quantity > 1) {
                cartDetail.quantity--;

                return true;
            }

            if (cartDetail.movie.id === movie.id && cartDetail.quantity == 1) {
                this.cartDetails.splice(key, 1);

                return true;
            }
        });
    }

    public toString(): String {
        let s: String = '';

        for (const m of this.cartDetails) {
            s += m.movie.name + ', ';
        }

        return 'id : ' + String(this.id) + ' ; movies : ' + s;
    }

    public numberOfItem(): number {
        let nb = 0;

        for (const cartDetail of this.cartDetails) {
            nb += cartDetail.quantity;
        }

        return nb;
    }

    public copy(cart: Cart) {
        this.id = cart.id;
        this.cartDetails = cart.cartDetails;
    }
}
