import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { UsersService } from '../users.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private userSvc: UsersService) { }

  login(token: string): boolean {
    let u = this.userSvc.getUsers().find(user => user.name === token)
    if (u){
      localStorage.setItem('access', JSON.stringify(u))
      return true
    }
    return false;
  }

  logout(): void {
    localStorage.removeItem('access')
  }

  getLoggedToken(): User {
    let db = localStorage.getItem('access')
    return db ? JSON.parse(db) : null;
  }

  isLogged(): boolean | null {
    return localStorage.getItem('access') != null;
  }
}
