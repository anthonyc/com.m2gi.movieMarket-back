import { Movie } from './movie';
import { Cart } from './cart';

export class CartDetail {
    movie: Movie;
    quantity: number;

    constructor(m: Movie) {
        this.movie = m;
        this.quantity = 1;
    }
}
