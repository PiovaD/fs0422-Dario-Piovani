import { Component, OnInit } from '@angular/core';
import { LoginService } from '../auth/login.service';
import { User } from '../models/user';
import { UsersService } from '../users.service';

@Component({
  template: `
    <div class="container mt-4">
      <form class="mb-3">
        <input *ngIf="isLogged()" class="form-control" type="text" [(ngModel)]="name" name="name" placeholder="username">
        <button class="btn btn-primary"  (click)="isLogged() ? login() : logout()" [innerText]="isLogged() ? 'Login' : 'Logout'"></button>

      </form>
      <ul class="list-group">
        <li [routerLink]="[user.id]" routerLinkActive="active"   class="list-group-item" *ngFor="let user of users">
          {{ user.name }}
        </li>
      </ul>
      <hr/>
      <router-outlet></router-outlet>
    </div>
  `,
  styles: [],
})
export class UsersPage implements OnInit {
  users!: User[];
  constructor(private usersSrv: UsersService, private loginSrv: LoginService) {}

  name!:string;

  ngOnInit(): void {
    this.users = this.usersSrv.getUsers();
  }

  login(){
    this.loginSrv.login(this.name);
    this.name = '';
  }

  logout(){
    this.loginSrv.logout();
  }

  isLogged():boolean | null{
    return !(this.loginSrv.isLogged())
  }
}
