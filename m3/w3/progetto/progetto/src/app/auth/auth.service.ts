import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IUser } from '../user/iuser';

export type AuthData = {
  accessToken: string,
  user: {
    id: string,
    email: string,
    username: string
  }
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  API: string = 'http://localhost:3000'

  constructor(private http: HttpClient) { }

  register(userData: IUser): Observable<AuthData> {
    return this.http.post<AuthData>(this.API + '/register', userData)
  }

  login(userData: IUser): Observable<AuthData> {
    return this.http.post<AuthData>(this.API + '/login', userData)
  }

  saveAccess(data: AuthData, rememberMe: boolean): void {

    if (rememberMe) {
      localStorage.setItem('access', JSON.stringify(data))
    } else {
      sessionStorage.setItem('access', JSON.stringify(data))
    }
  }

  getLoggedUser(): AuthData | undefined {
    let db = JSON.parse(String(localStorage.getItem('access')))
    if (!db) db = JSON.parse(String(sessionStorage.getItem('access')))

    return db
  }

  getAllUser(): Observable<IUser[]> {
    return this.http.get<IUser[]>(this.API + '/users')
  }
}
