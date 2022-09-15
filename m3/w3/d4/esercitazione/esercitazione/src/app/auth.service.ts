import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IUser } from './Model/user';

type userData = {
  accessToken: string,
  user: IUser
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  API:string = 'http://localhost:3000'

  constructor(private http:HttpClient) { }

  register(userData: IUser) {
    return this.http.post<userData>(this.API + '/register', userData)
  }

  login(userData: IUser) {
    return this.http.post<userData>(this.API + '/login', userData)
  }

  saveAccess(data: userData){
    localStorage.setItem('access',JSON.stringify(data))
  }

  getLoggedUser(): userData | null{
    let db = localStorage.getItem('access')
    return db ? JSON.parse(db) : null
  }
}
