import { Person } from './person';
import {Address} from './address';

export class User extends Person {
    username: String;
    email: String;
    password: String;
    addresses: Address[];
    jwtToken: string;
}
