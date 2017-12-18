import { Category } from './category';

export class Movie {
    id: number;
    categories: Category[];
    img: string;
    name: string;
    description: string;
    price: number;
    quantity: number;
    releaseYear: number;
}
