import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {FormsHelperService} from "../../service/forms-helper.service";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  token = null;
  error = null;
  finished = false;

  constructor(private formBuilder: FormBuilder,
    public formsHelper: FormsHelperService,
    private userService: UserService) {

    this.loginForm = this.formBuilder.group({
      'email': ['', Validators.email],
      'password': ['', Validators.minLength(6)]
    });
  }

  ngOnInit() {
  }

  login() {
    if (this.loginForm.valid) {
      console.log(this.loginForm.get('email').value);
      this.userService.login(this.loginForm.get('email').value, this.loginForm.get('password').value).subscribe(
        data => console.log(data),
        err => {
          this.error = "Une erreur serveur est survenu. Veuillez réessayer dans quelques instants";

          if (err.status === 400) {
            this.error = "Veuillez remplir tous les champs obligatoire du formulaire";
          }
        }
      );
    }
  }

}
