import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class AuthServiceService {

  constructor(private http: HttpClient) { }
  private apiUrl = "http://localhost:8080/api/users"
  login(username: string, password: string) {
    return this.http.post<any>(this.apiUrl + '/login', { username: username, password: password })
      .map(user => {
        if (user) {
          console.log(user);
          localStorage.setItem('currentUser', JSON.stringify(user));
        }
        return user;
      });
  }

  logout() {
    localStorage.removeItem('currentUser');
  }
}
