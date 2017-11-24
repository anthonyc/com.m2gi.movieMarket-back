import { ContentSpace } from './../../model/content-space';
import { ArianeComponent } from './../ariane/ariane.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page-content',
  templateUrl: './home-page-content.component.html',
  styleUrls: ['./home-page-content.component.css']
})
export class HomePageContentComponent implements OnInit, ContentSpace {
    ariane: ArianeComponent;
    name: String;

    constructor() {
        this.name = 'homePage';
    }

    ngOnInit() {
    }

}
