import { Injectable } from '@angular/core';
import {Authenticate} from '../model/authenticate';

@Injectable()
export class AuthenticateService {

  constructor() { }

  public get(): Authenticate {
    const authenticateStorage = localStorage.getItem('authenticate');

    if (authenticateStorage == null) {
      return new Authenticate();
    }

    const authenticate = (JSON.parse(authenticateStorage) as Authenticate);

    return authenticate;
  }

  public set(authenticate: Authenticate) {
    localStorage.setItem('authenticate', JSON.stringify(authenticate));
  }

  public loggout() {
    localStorage.removeItem('authenticate');
  }

  public getName() {
    return this.get().name;
  }

  public isLogged(): boolean {
    return this.get().token ? true : false;
  }
}
