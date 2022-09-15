import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-logged-home',
  templateUrl: './logged-home.component.html',
  styleUrls: ['./logged-home.component.scss']
})
export class LoggedHomeComponent implements OnInit {

  constructor(private authSvc: AuthService) { }

  user: any;

  ngOnInit(): void {

    this.user = this.authSvc.getLoggedUser()

  }


}
