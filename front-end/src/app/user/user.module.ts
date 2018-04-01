import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserService } from './services/user.service';
import { AlertService } from './services/alert.service';
import { AuthServiceService } from './services/auth-service.service'
import { FormsModule } from '@angular/forms';
import { UserHomeComponent } from './user-home/user-home.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { AlertComponent } from './alert/alert.component';
import { AuthGuard } from './gaurd/auth.gaurd';
import { EmployeesModule } from '../employees/employees.module';
import { NavComponent } from './nav/nav.component';
@NgModule({
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule,
    EmployeesModule
  ],
  exports: [
    UserRegisterComponent,
    UserHomeComponent,
    UserLoginComponent,
    AlertComponent,
    NavComponent
  ],
  declarations: [UserRegisterComponent, UserHomeComponent, UserLoginComponent, AlertComponent, NavComponent],
  providers: [
    UserService,
    AuthServiceService,
    AlertService,
    AuthGuard
  ]
})
export class UserModule { }
