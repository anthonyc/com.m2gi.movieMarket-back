import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  authors = ['Anthony CHAVOUTIER', 'Lucas BARALLON', 'Sylvain MARION', 'Loïc MOTTET',  'Julien NAVAILS'];

  constructor() { }

  ngOnInit() {
  }

}
