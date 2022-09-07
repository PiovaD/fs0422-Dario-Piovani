import { Component, EventEmitter, Output } from '@angular/core';
import { User } from '../Models/user';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {

  newUser:User = new User('', '')

  @Output() onNewUserCreated = new EventEmitter<User>()

  constructor() { }

  sendDataToParent(){
    this.onNewUserCreated.emit(this.newUser)//invio dati al genitore
  }

}
