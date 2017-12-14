import { Movie } from './movie';

export class Cart {
    id: number;
    movies: Movie[] = [];

    public addMovie(movie: Movie) {
        this.movies.push(movie);
    }

    public addMovies(movies: Movie[]) {
        this.movies = movies;
    }

    public toString() {
        let s: String = '';
        for (const m of this.movies) {
            s += m.name + ', ';
        }
        return 'id : ' + String(this.id) + ' ; movies : ' + s;
    }
}
