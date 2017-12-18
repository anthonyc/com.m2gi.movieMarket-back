import { Movie } from './movie';

export class CartDetail {
    id: number;
    movie: Movie;
    quantity: number;

    constructor(movie: Movie, quantity: number = 1) {
        this.movie = movie;
        this.quantity = quantity;
    }
}
