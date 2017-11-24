import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ariane',
  templateUrl: './ariane.component.html',
  styleUrls: ['./ariane.component.css']
})
export class ArianeComponent implements OnInit {

  chaine: String;

  constructor() {
    this.chaine = '/MON/FIL/D/ARIANE/EST/NON/FONCTIONNEL';
   }

  ngOnInit() {
  }

}
