import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-login-button',
  templateUrl: './login-button.component.html',
  styleUrls: ['./login-button.component.scss']
})
export class LoginButtonComponent implements OnInit {

  user?: any;

  constructor(private authSvc: AuthService) { }

  ngOnInit(): void {
  }

  ngDoCheck(){
    this.user = this.authSvc.getLoggedUser()
  }


}
