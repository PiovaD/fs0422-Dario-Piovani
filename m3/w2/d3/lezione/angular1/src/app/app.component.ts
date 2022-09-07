import { Component, ElementRef, ViewChild } from '@angular/core';
import { User } from './Models/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular1';

  @ViewChild('pippo') pippo!: ElementRef;

  allUsers: User[] = []

  visible: boolean = true
  visibleCss: boolean = true

  addUser(event: User) {
    let userCopy = Object.assign({}, event)
    this.allUsers.push(userCopy)
  }

  log(){
    console.log(this.pippo)
    //this.pippo.style.color = 'red'
  }
}
