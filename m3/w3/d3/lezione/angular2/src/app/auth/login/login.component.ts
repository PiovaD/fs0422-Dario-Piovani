import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../auth.service';
import { ILogin } from '../Models/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private auth:AuthService, private router:Router) { }

  loginData: ILogin = {
    email: 'wanajovab@mailinator.com',
    password: 'Pa$$w0rd!'
  }

  ngOnInit(): void {
  }

  save(){
    this.auth.login(this.loginData)
    .subscribe(data => {
      console.log(data)
      this.auth.saveAccessData(data);
      this.router.navigate(['/dashboard'])
    })
  }

}
