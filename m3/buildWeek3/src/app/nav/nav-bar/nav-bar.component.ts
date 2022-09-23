import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Auth/auth.service';
import { ModaleComponent } from '../modale/modale.component';

@Component({
  selector: '.app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss'],
})
export class NavBarComponent implements OnInit {
  constructor(private authService: AuthService, private router: Router) {}

  isLogged: boolean = false;
  userId?: number;

  @ViewChild(ModaleComponent) modal:any;

  ngOnInit(): void {}

  getUserName(): string {
    let user = this.authService.getLoggedUser();
    if (user) {
      this.isLogged = true;
      this.userId = user.user.id;
      return user.user.username;
    } else {
      this.isLogged = false;
      return 'Utente';
    }
  }

  logout(){
    this.authService.removeAccess()
    this.authService.refreshData()
  }

  showModal(): void {
    this.modal.isVisible = true;
  }


}

