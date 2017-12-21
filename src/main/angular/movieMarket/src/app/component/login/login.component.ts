import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {FormsHelperService} from "../../service/forms-helper.service";
import {UserService} from "../../service/user.service";
import {Authenticate} from "../../model/authenticate";
import {AuthenticateService} from "../../service/authenticate.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  authenticate: Authenticate;
  loginForm: FormGroup;
  token = null;
  error = null;
  finished = false;
  loginFailed = false;

  constructor(private formBuilder: FormBuilder,
    public formsHelper: FormsHelperService,
    private userService: UserService,
    private authenticateService: AuthenticateService) {

    this.loginForm = this.formBuilder.group({
      'email': ['', Validators.email],
      'password': ['', Validators.minLength(6)]
    });
  }

  ngOnInit() {
  }

  login() {
    if (this.loginForm.valid) {
      this.userService.login(this.loginForm.get('email').value, this.loginForm.get('password').value).subscribe(
        data => {
          this.authenticate = data;
          this.authenticateService.set(this.authenticate);
        },
        err => {
          this.error = "Une erreur serveur est survenue. Veuillez réessayer dans quelques instants";

          if (err.status === 404) {
            this.loginFailed = true;
          }
        },
        () => this.finished = true
      );
    }
  }

}
