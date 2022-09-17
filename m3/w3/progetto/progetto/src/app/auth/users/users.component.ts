import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  isLoading:boolean = false;

  constructor(private authSvc:AuthService,private router: Router) { }

  ngOnInit(): void {
  }

  logout(){
    this.authSvc.removeAccess()
    this.router.navigate(['/login'])
  }

  deleteUser(){}

}
