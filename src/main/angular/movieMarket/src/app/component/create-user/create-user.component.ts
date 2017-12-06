import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { Gender } from '../../model/person';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  user: User = new User();
  genders: String[];
  gender: Gender;

  constructor() { }

  create() {
    console.log(this.user.username);
  }

  ngOnInit() {
    for (let gender in Gender) {
      if (isNaN(Number(gender))) {
        console.log('plop' + Gender[gender]);
        //this.genders.push(gender);
      }
    }
  }
}
