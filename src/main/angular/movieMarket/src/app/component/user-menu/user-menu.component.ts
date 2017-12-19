import { Component, OnInit, Input } from '@angular/core';
import {User} from "../../model/user";

@Component({
  selector: 'app-user-menu',
  templateUrl: './user-menu.component.html',
  styleUrls: ['./user-menu.component.css']
})
export class UserMenuComponent implements OnInit {
  @Input() user: User;

  constructor() { }

  ngOnInit() {
  }

}
