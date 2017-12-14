import { Movie } from './movie';
import { CartDetail } from './cart-detail';

export class Cart {
    id: number;
    cartDetails: CartDetail[] = [];

    constructor () {
    }

    public addMovie(movie: Movie) {
        for (const cartDetail of this.cartDetails) {
            if (movie === cartDetail.movie) {
                cartDetail.quantity++;
                return;
            }
        }
        const cd = new CartDetail(movie);
        this.cartDetails.push(cd);
    }

    public addMovies(movies: Movie[]) {
        for (const m of movies) {
            this.addMovie(m);
        }
    }

    public setCartDetail(movies: CartDetail[]) {
        this.cartDetails = movies;
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
}
