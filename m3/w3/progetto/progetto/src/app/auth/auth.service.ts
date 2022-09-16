import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IUser } from '../user/iuser';

type AuthData = {
  accessToken: string,
  user: {
    email: string,
    username: string
  }
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  API:string = 'http://localhost:3000'

  constructor(private http:HttpClient) { }

  register(userData: IUser): Observable<AuthData> {
    return this.http.post<AuthData>(this.API + '/register', userData)
  }

  login(userData: IUser): Observable<AuthData> {
    return this.http.post<AuthData>(this.API + '/login', userData)
  }

  saveAccess(data: AuthData, rememberMe: boolean):void {

    rememberMe && localStorage.setItem('access',JSON.stringify(data))

    sessionStorage.setItem('access',JSON.stringify(data))

  }

  getLoggedUser(): AuthData | null{
    let db = sessionStorage.getItem('access')
    return db ? JSON.parse(db) : null
  }

  getAllUser(): Observable<IUser[]> {
   return this.http.get<IUser[]>(this.API+'/users')
  }
}
