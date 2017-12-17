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
        const cartDetailIdx = this.getCartDetailIdx(movie);
        if (cartDetailIdx !== -1) {
            this.cartDetails[cartDetailIdx].quantity = quantity;
        }
    }

    public removeMovie(movie: CartDetail | Movie) {
        const cartDetailIdx = this.getCartDetailIdx(movie);
        console.log(typeof movie);
        if (cartDetailIdx !== -1) {
            this.cartDetails.splice(cartDetailIdx, 1);
        }
    }

    private getCartDetailIdx(movie: CartDetail | Movie): number {
        let film: Movie;

        if (movie instanceof CartDetail) {
            console.log('PLOP');
            film = movie.movie;
        } else {
            film = movie;
        }

        // get the cartDetail associated with the film
        for (let i = 0; i < this.cartDetails.length; i++) {
            if (this.cartDetails[i].movie.name === film.name) {
                return i;
            }
        }
        return -1;
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
