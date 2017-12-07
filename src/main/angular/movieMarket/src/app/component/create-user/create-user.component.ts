import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { Gender } from '../../model/person';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  user: User = new User();
  genders: String[];
  gender: Gender;
  error = null;
  finished = false;

  constructor(private userService: UserService) { }

  create() {
    console.log(this.user.username);
    this.userService.create(this.user).subscribe(
      value => console.log(value),
      error => this.error = 'movieService.all error',
      () => this.finished = true
  );
  }

  ngOnInit() {
    
  }
}
