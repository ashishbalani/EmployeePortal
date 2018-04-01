import { Component, OnInit, Output, EventEmitter,ElementRef } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../models/Employee';


@Component({
  selector: 'emp-display',
  templateUrl: './emp-display.component.html',
  styleUrls: ['./emp-display.component.css'],

})
export class EmpDisplayComponent implements OnInit {

  @Output() viewChange = new EventEmitter<boolean>();
  view: boolean = false;
  imageToShow: any;
  employee: Employee = new Employee();
  isImageLoading: boolean = false;
  constructor(private empService: EmployeeService  ) { }

  
  ngOnInit() {
    this.view = true;
    this.empService.currentEmployee.subscribe(
      employee => {
        this.employee = employee;
      });
  }

  
  viewAllEmps() {
    this.view = false;
    this.viewChange.emit(!this.view);
  }

}
