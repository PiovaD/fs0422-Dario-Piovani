import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { API } from 'src/environments/environment';
import { IPost } from '../Model/ipost';
import { IUser } from '../Model/iuser';

type AuthRes = {
  accessToken: string;
  user: {
    avatar?: string;
    name: string;
    username: string;
    email: string;
    id: number;
  };
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient,private router: Router,) {}

  register(user: IUser): Observable<IUser> {
    return this.http.post<IUser>(API + '/register', user);
  }

  login(user: IUser): Observable<AuthRes> {
    return this.http.post<AuthRes>(API + '/login', user);
  }

  deleteUser(user: IUser): Observable<IUser> {
    return this.http.delete<IUser>(API + '/users/' + user.id);
  }

  updateUser(user: IUser): Observable<IUser> {
    return this.http.patch<IUser>(API + '/users/' + user.id, user);
  }

  saveAccess(data: AuthRes, remember: boolean): void {
    this.removeAccess();

    if (remember) {
      localStorage.setItem('access', JSON.stringify(data));
    } else {
      sessionStorage.setItem('access', JSON.stringify(data));
    }
  }

  removeAccess(): void {
    localStorage.removeItem('access');
    sessionStorage.removeItem('access');
  }

  getLoggedUser(): AuthRes | null {
    return JSON.parse(
      String(localStorage.getItem('access') || sessionStorage.getItem('access'))
    );
  }

  getUserById(id: number | string): Observable<IUser> {
    return this.http.get<IUser>(API + '/users/' + id);
  }

  getAllUsers(): Observable<IUser[]> {
    return this.http.get<IUser[]>(API + '/users');
  }

  /*----POST-----*/

  getAllPost(): Observable<IPost[]>{
    return this.http.get<IPost[]>(API + '/posts')
  }

  getPostsByUserId(userId: number | string): Observable<IPost[]>{
    return this.http.get<IPost[]>(API + '/posts?userId=' + userId)
  }

  addPost(post:IPost): Observable<IPost>{
    return this.http.post<IPost>(API + '/posts', post)
  }

  editPost(post:IPost): Observable<IPost>{
    return this.http.patch<IPost>(API + '/posts/' + post.id, post)
  }

  deletePost(post:IPost): Observable<IPost>{
    return this.http.delete<IPost>(API + '/posts/' + post.id)
  }

  refreshData():void {
        //accrocchio? serve a ricaricare per mostrare il post aggiunto dopo l'invio della modale
        const currentUrl = this.router.url;
        this.router.navigateByUrl('/search', {skipLocationChange: true}).then(()=>{
        this.router.navigate([currentUrl])
      });
  }

}
