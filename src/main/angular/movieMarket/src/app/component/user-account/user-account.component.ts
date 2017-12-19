import { Component, OnInit } from '@angular/core';
import {User} from '../../model/user';
import {UserService} from '../../service/user.service';
import {AuthenticateService} from '../../service/authenticate.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-user-account',
  templateUrl: './user-account.component.html',
  styleUrls: ['./user-account.component.css']
})
export class UserAccountComponent implements OnInit {
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
