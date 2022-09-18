import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  isLoading: boolean = false;
  deleteLoading: boolean = false;

  constructor(private authSvc: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  logout() {
    this.authSvc.removeAccess()
    this.router.navigate(['/login'])
  }

  deleteUser() {
    let user = JSON.parse(String(sessionStorage.getItem('access'))) || JSON.parse(String(localStorage.getItem('access')))
    this.deleteLoading = true
    this.authSvc.deleteUser(user)
      .subscribe({
        complete: () => {
          this.authSvc.removeAccess()
          this.router.navigate(['/posts'])
        },
        error: (err) => {
          console.log('HTTP Error', err);
          this.deleteLoading = false
        }

      })
  }

  loading(isLoading: boolean) {
    this.isLoading = isLoading;
  }

}
