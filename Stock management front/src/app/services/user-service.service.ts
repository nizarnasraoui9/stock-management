import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';



@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private usersUrl = "http://127.0.0.1:8081/users/list";

  constructor(private http: HttpClient) { }

  getAll(): Observable<User[]> {
    //return this.http.get<User[]>(`${this.usersUrl}`);
    return this.http.get<User[]>(this.usersUrl);
  }
}
