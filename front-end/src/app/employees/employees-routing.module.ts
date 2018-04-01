import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpAllDisplayComponent } from './emp-all-display/emp-all-display.component'
import { EmpDisplayComponent } from './emp-display/emp-display.component'

const userRoutes: Routes = [
  
];

@NgModule({
  imports: [RouterModule.forRoot(userRoutes)],
  exports: [RouterModule]
})

export class UserRoutingModule { }
