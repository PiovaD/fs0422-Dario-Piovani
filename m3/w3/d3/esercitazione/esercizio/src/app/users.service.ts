import { Injectable } from '@angular/core';
import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  private users:User[] =[
    {
      email:'c@fff.com',
      id:1,
      name:"carlo",
      role:'user'
    },
    {
      email:'luc@fff.com',
      id:2,
      name:"luca",
      role:'admin'
    }
  ]

  constructor() { }

  getUsers(){
    return this.users
  }

  getUser(id:number){
    return this.users.find(user=>user.id==id)
  }

  saveUser(user:User){
    user.id = (this.users[this.users.length - 1].id + 1)
    console.log(user)
    this.users.push(user)
  }
}
