import { Component, Input, OnInit } from '@angular/core';
import {User} from "../../model/user";
import {ActivatedRoute} from "@angular/router";
import {AuthenticateService} from "../../service/authenticate.service";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  user: User;
  userId: string;
  finished = false;
  error: string;

  constructor(private userService: UserService,
      private authenticateService: AuthenticateService,
      private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.userId = params['id']
    });
  }

  ngOnInit() {
    this.userService.find(this.userId, this.authenticateService.get().token).subscribe(
      value => this.user = value,
      error => this.error = 'movieService.find error',
      () => this.finished = true
    );
  }

}
