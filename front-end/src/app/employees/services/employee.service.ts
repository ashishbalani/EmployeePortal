import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ResponseContentType } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Employee } from '../models/Employee';

@Injectable()
export class EmployeeService {

  private empSource = new BehaviorSubject<Employee>(new Employee());
  currentEmployee = this.empSource.asObservable();

  constructor(private http:HttpClient) {

  }

  private apiUrl = "http://localhost:8080/api/employees";

  getAll(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  sortEmpsBy(object): Observable<any> {
    console.log(object);
    return this.http.post(this.apiUrl, object);
  }

  changeEmployee(employee: Employee) {
    this.empSource.next(employee);
  }

  viewEmp(empId): Observable<any> {
    console.log(empId);
    return this.http.post(this.apiUrl + '/emp', empId);
  }

  getImages(employee: Employee): Observable<Blob> {
    return this.http.get(this.apiUrl + "/empImage/empId=" + employee.id,{ responseType: "blob" });
  }


  }

