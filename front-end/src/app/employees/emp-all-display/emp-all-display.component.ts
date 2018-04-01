import { Component, OnInit ,Output,EventEmitter,Input} from '@angular/core';
import { Employee } from '../models/Employee';
import { EmployeeService } from '../services/employee.service';


@Component({
  selector: 'emp-all-display',
  templateUrl: './emp-all-display.component.html',
  styleUrls: ['./emp-all-display.component.css']
})
export class EmpAllDisplayComponent implements OnInit {

  constructor(private empService: EmployeeService) { }
  employees: Employee[] = [];
  employee: Employee = new Employee();
  @Output() viewChange = new EventEmitter<boolean>();
  view: boolean = true;

  ngOnInit() {
    this.getEmployees();
  }

  getEmployees() {
    this.empService.getAll().subscribe(
      employees => {
        this.employees = employees;
      }
    )
  }

  sortEmpBy(data) {
    console.log(data.value.select);
    this.empService.sortEmpsBy({
      "sortBy": data.value.select,
      "order": data.value.order
    }).subscribe(
      employees => {
        this.employees = employees;
      }
    )
  }

  viewEmp(emp) {
    console.log(emp);
    this.empService.changeEmployee(emp);
    this.view = false;
    this.viewChange.emit(this.view);
  }
}
