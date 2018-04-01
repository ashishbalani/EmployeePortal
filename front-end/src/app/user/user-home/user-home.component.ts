import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {

  viewAll: string = 'true';

  constructor() { }

  ngOnInit() {

  }

  changeView($event) {
    this.viewAll = $event;
    console.log(this.viewAll);
  }

}
