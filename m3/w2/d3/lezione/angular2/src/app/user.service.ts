import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  allUsers: User[] = [
    {
      id:1,
      name: 'Mario',
      lastName: 'Rossi',
      active: true
    },
    {
      id:2,
      name: 'Maria',
      lastName: 'Rosa',
      active: true
    },
    {
      id:3,
      name: 'Mariano',
      lastName: 'Rossi',
      active: false
    }
  ];

  addNewUser(user: User): void {
    let userCopy = Object.assign({}, user);
    this.allUsers.push(userCopy);
  }

  deleteUser(id: string | number):void {
    let index = this.allUsers.findIndex(user => user.id === id);
    this.allUsers.splice(index, 1);
  }

  getUserbyId(id: string | number): User {
    return this.allUsers.find(u => u.id == id) || new User('','');
  }

  geActiveUser(): User[]{
    return this.allUsers.filter(u => u.active == true)
  }

  geInactiveUser(): User[]{
    return this.allUsers.filter(u => u.active == false)
  }

}
