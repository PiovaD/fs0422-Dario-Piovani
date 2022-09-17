import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-my-user',
  templateUrl: './my-user.component.html',
  styleUrls: ['./my-user.component.scss']
})
export class MyUserComponent implements OnInit {

  isLoading:boolean = false;

  constructor(private authSvc:AuthService,private router: Router) { }

  ngOnInit(): void {
  }

  logout(){
    this.authSvc.removeAccess()
    this.router.navigate(['/login'])
  }

}
