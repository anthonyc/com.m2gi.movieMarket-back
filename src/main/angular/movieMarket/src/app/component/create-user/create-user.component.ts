import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { UserService } from '../../service/user.service';
declare var $ :any;

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  user: User = new User();
  info = null;
  error = null;
  finished = false;

  constructor(private userService: UserService) { }

  create() {
    this.userService.create(this.user).subscribe(
      data => {
        this.info = "Utilisateur créé";
        $("#alert-info").show();
      },
      err => {
        this.error = "Une erreur serveur est survenu. Veuillez réessayer dans quelques instants";

        if (err.status === 400) {
          this.error = "Veuillez remplir tous les champs obligatoire du formulaire";
        }

        $("#alert-danger").show();
      }
  );
  }

  ngOnInit() {
    $("#alert-danger").hide()
    $("#alert-info").hide();
  }
}
