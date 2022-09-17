import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IUser } from './iuser';

export type AuthData = {
  accessToken: string,
  user: {
    id: string,
    email: string,
    username: string,
    name: string
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

  updateUser(userData: IUser): Observable<IUser> {
    return this.http.patch<IUser>(this.API + '/users/' + userData.id, userData);
  }

  saveAccess(data: AuthData, rememberMe: boolean): void {
    if (rememberMe) {
      localStorage.setItem('token', JSON.stringify(data.accessToken))
      localStorage.setItem('access', JSON.stringify(data.user))
    } else {
      sessionStorage.setItem('token', JSON.stringify(data.accessToken))
      sessionStorage.setItem('access', JSON.stringify(data.user))
    }
  }

  removeAccess() {
    localStorage.removeItem('access')
    localStorage.removeItem('token')
    sessionStorage.removeItem('access')
    sessionStorage.removeItem('token')
  }

  isLogged(): boolean {
    return (localStorage.getItem('access') != null) || (sessionStorage.getItem('access') != null)
  }

  getLoggedUser(): IUser | undefined {
    let db = JSON.parse(String(localStorage.getItem('access')))
    if (!db) db = JSON.parse(String(sessionStorage.getItem('access')))

    return db
  }

  getAllUser(): Observable<IUser[]> {
    return this.http.get<IUser[]>(this.API + '/users')
  }
}
