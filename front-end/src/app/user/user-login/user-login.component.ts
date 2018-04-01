import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthServiceService } from '../services/auth-service.service';
import { AlertService } from '../services/alert.service'

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  user: User = new User();
  loading = false;
  returnUrl: string;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthServiceService,
    private alertService: AlertService) { }


  login() {
    this.loading = true;
    this.authenticationService.login(this.user.email, this.user.password)
      .subscribe(
      data => {
        if (data.fname === null) {
          this.alertService.error('User cred not valid');
          this.loading = false;
        } else {
          console.log(this.returnUrl);
          this.router.navigate([this.returnUrl]);
        }
      },
      error => {
        this.alertService.error("User credentials are invalid");
        this.loading = false;
      });
  }
  ngOnInit() {
    this.authenticationService.logout();
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

}
