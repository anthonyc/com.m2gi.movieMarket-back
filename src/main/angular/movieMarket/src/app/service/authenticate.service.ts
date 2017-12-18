import { Injectable } from '@angular/core';
import {Authenticate} from "../model/authenticate";

@Injectable()
export class AuthenticateService {

  constructor() { }

  public get(): Authenticate {
    const authenticateStorage = localStorage.getItem('authenticate');

    if (authenticateStorage == null) {
      return new Authenticate();
    }

    let authenticate = (JSON.parse(authenticateStorage) as Authenticate);

    return authenticate;
  }

  public set(authenticate: Authenticate) {
    localStorage.setItem('authenticate', JSON.stringify(authenticate));
  }

  public getName() {
    console.log('plop : '+this.get().name);
    return this.get().name;
  }
}
