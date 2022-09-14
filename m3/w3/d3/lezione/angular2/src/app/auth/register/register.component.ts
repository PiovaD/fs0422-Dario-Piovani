import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../auth.service';
import { IRegister } from '../Models/register';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerData: IRegister = {
    email: '',
    password: ''
  };

  constructor(private authSvc: AuthService) { }

  ngOnInit(): void {
  }

  save(){
    this.authSvc.register(this.registerData)
    .subscribe(res => {
      alert(`utente ${res.user.email} registrato`)
      this.registerData = {
        email: '',
        password: ''
      };
    })
  }

}
