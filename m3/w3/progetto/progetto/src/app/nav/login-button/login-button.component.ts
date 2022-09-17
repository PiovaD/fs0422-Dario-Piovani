import { Component, OnInit } from '@angular/core';
import { NzButtonSize } from 'ng-zorro-antd/button';
import { AuthService, AuthData } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-login-button',
  templateUrl: './login-button.component.html',
  styleUrls: ['./login-button.component.scss']
})
export class LoginButtonComponent implements OnInit {

  size: NzButtonSize = 'large';

  user?: AuthData;


  constructor(private authSvc: AuthService) { }

  ngOnInit(): void {
  }

  ngDoCheck(){
    this.user = this.authSvc.getLoggedUser()
    console.table(this.user)
  }

  logout(){}


}
