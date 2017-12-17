import { Movie } from './movie';
import { Cart } from './cart';

export class CartDetail {
    movie: Movie;
    quantity: number;

    constructor(m: Movie, qt: number = 1) {
        this.movie = m;
        this.quantity = qt;
    }
}
