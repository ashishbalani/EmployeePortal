import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../services/auth-service.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})

export class NavComponent implements OnInit {
  returnUrl: string = '';

  constructor(private authService: AuthServiceService, private router: Router) { }

  ngOnInit() {
  }

  logout() {
    this.router.navigate(['/login']);
  }

}
