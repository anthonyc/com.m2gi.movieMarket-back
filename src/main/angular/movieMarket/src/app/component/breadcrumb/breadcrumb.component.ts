import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-breadcrumbs',
  templateUrl: './breadcrumb.component.html',
  styleUrls: ['./breadcrumb.component.css']
})
export class BreadcrumbComponent implements OnInit {

  breadcrumbs: string[];

  constructor() {
    this.breadcrumbs = [
      'MON',
      'FIL',
      'D\'ARIANE',
      'EST',
      'NON',
      'FONCTIONNEL'
    ];
   }

  ngOnInit() {
  }

}
