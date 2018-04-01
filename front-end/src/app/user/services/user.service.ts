import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { User } from '../models/User';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
};

@Injectable()
export class UserService {
  private apiUrl = "http://localhost:8080/api/users"

  constructor(private http: HttpClient) { }

  public saveUser(user: User) {
    return this.http.post(this.apiUrl+'/register', user);
  }
}
