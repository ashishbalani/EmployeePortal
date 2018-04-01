import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { AlertService } from '../services/alert.service';


@Component({
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {

  user: User = new User();
  loading = false;

  constructor(private router: Router,
    private userService: UserService,
    private alertService: AlertService) { }

  saveUser(): void {
    this.loading = true;
    this.userService.saveUser(this.user).subscribe(
      data => {
        this.router.navigate(['/login']);
      }),
      error => {
        this.alertService.error(error);
        this.loading = false;
      }
      ;
  };

  ngOnInit() {

  }

}
