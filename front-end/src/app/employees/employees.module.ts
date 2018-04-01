import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmpDisplayComponent } from './emp-display/emp-display.component';
import { EmpAllDisplayComponent } from './emp-all-display/emp-all-display.component';
import { EmployeeService } from './services/employee.service'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [EmpAllDisplayComponent, EmpDisplayComponent],
  declarations: [EmpDisplayComponent, EmpAllDisplayComponent],
  providers: [EmployeeService]
})
export class EmployeesModule { }
