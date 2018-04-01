import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserRegisterComponent } from './user-register/user-register.component'
import { UserLoginComponent } from './user-login/user-login.component'
import { UserHomeComponent } from './user-home/user-home.component'
import { AuthGuard } from './gaurd/auth.gaurd'

const userRoutes: Routes = [
  {
    path: 'register', component: UserRegisterComponent
  },
  {
    path: 'login', component: UserLoginComponent
  },
  {
    path: '', component: UserHomeComponent, canActivate: [AuthGuard]
  },
  {
    path: '**', redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(userRoutes)],
  exports: [RouterModule]
})

export class UserRoutingModule { }
