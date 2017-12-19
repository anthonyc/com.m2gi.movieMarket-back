import {Component, OnInit} from '@angular/core';
import { User } from '../../model/user';
import { UserService } from '../../service/user.service';
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators} from "@angular/forms";
import {FormsHelperService} from "../../service/forms-helper.service";
import {Gender} from "../../model/person";
import 'rxjs/add/observable/of';
declare var $ :any;


@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  user: User = new User();
  userForm: FormGroup;
  info = null;
  error = null;
  finished = false;

  constructor(private userService: UserService,
      private formBuilder: FormBuilder,
      public formsHelper: FormsHelperService) {
    this.createForm();
  }

  createForm() {
    this.userForm = this.formBuilder.group({
      'gender': ['', Validators.required ],
      'lastname': ['', Validators.required ],
      'firstname': ['', Validators.required ],
      'username': ['', Validators.required ],
      'birthday': ['', Validators.required ],
      'email': ['', Validators.email ],
      'passwords': this.formBuilder.group({
        'password': [''],
        'confirmPassword': ['']
      }, {validator: this.passwordConfirming})
    });

    this.user.gender = Gender.MR;
  }


  passwordConfirming(control: AbstractControl) {
    if ((control.get('password').value !== control.get('confirmPassword').value) ||
      control.get('password').value.length < 6 && control.get('confirmPassword').value.length < 6) {
      return { passwordConfirming: true };
    }
    return null;
  }

  create() {
    if (this.userForm.valid) {
      this.userService.create(this.user).subscribe(
        data => {
          this.info = "Utilisateur créé";
          $("#alert-info").show();
        },
        err => {
          this.error = "Une erreur serveur est survenue. Veuillez réessayer dans quelques instants";

          if (err.status === 400) {
            this.error = "Veuillez remplir tous les champs obligatoires du formulaire";
          }

          $("#alert-danger").show();
        }
      );
    } else {
      Object.keys(this.userForm.controls).forEach(field => {
        const control = this.userForm.get(field);
        if (control.pristine) {
          control.markAsTouched({ onlySelf: true });
          control.markAsDirty({ onlySelf: true });
        }
      });
    }
  }

  ngOnInit() {
    $("#alert-danger").hide()
    $("#alert-info").hide();

  }
}
