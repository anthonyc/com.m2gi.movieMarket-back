import { Movie } from './movie';
import { CartDetail } from './cart-detail';

export class Cart {
    id: number;
    cartDetails: CartDetail[] = [];

    counter: number;

    constructor () {
        this.counter = 0;
    }

    public addMovie(movie: Movie) {
        for (const cartDetail of this.cartDetails) {
            // Not a good way to check if movies are equal but works
            if (movie.name === cartDetail.movie.name) {
                cartDetail.quantity++;
                return;
            }
        }
        const cd = new CartDetail(movie);
        this.cartDetails.push(cd);
        this.counter++;
    }

    public addMovies(movies: Movie[]) {
        for (const m of movies) {
            this.addMovie(m);
        }
    }

    public setCartDetail(movies: CartDetail[]) {
        this.cartDetails = movies;
    }

    public changeMovieQuantity(movie: CartDetail | Movie, quantity) {
        // get the actual film we want to increase the quantity of within the cart
        let film: Movie;
        if (movie instanceof CartDetail) {
            console.log('PLOP');
            film = movie.movie;
        } else {
            film = movie;
        }

        // get the cartDetail associated with the film
        for (const cartDetail of this.cartDetails) {
            if (cartDetail.movie.name === film.name) {
                cartDetail.quantity = quantity;
                return;
            }
        }
        // Potentially an error
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

    public copy(c: Cart) {
        this.id = c.id;
        this.cartDetails = c.cartDetails;
        this.counter = c.counter;
    }
}
