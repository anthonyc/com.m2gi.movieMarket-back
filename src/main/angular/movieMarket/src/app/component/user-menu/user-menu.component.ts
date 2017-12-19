import { Component, OnInit, Input } from '@angular/core';
import {User} from "../../model/user";

@Component({
  selector: 'app-user-menu',
  templateUrl: './user-menu.component.html',
  styleUrls: ['./user-menu.component.css']
})
export class UserMenuComponent implements OnInit {
  @Input() user: User;
  @Input() classActive: string;

  constructor() { }

  ngOnInit() {
  }

  isActive(element: string) {
    if (element === this.classActive) {
      return 'active';
    }

    return null;
  }
}
