import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Models/user';

@Component({
  selector: 'app-utenti',
  templateUrl: './utenti.component.html',
  styleUrls: ['./utenti.component.css']
})
export class UtentiComponent implements OnInit {

  utenti: User[] = [
    {
      "id": 1,
      "name": "Leanne Graham",
      "email": "Sincere@april.biz"
    },
    {
      "id": 2,
      "name": "Ervin Howell",
      "email": "Shanna@melissa.tv"
    },
    {
      "id": 3,
      "name": "Clementine Bauch",
      "email": "Nathan@yesenia.net"
    }
  ];

  constructor() { }

  newUser:User = new User('','');

  addUser():void{
    let userCopy = Object.assign({}, this.newUser);
    this.utenti.push(userCopy);
    this.newUser = new User('','')
  }

  ngOnInit(): void {
  }

}
