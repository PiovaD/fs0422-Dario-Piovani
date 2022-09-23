import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Auth/auth.service';

@Component({
  selector: 'app-modale',
  templateUrl: './modale.component.html',
  styleUrls: ['./modale.component.scss']
})
export class ModaleComponent implements OnInit {

  isVisible = false

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  handleCancel(): void {
    this.isVisible = false;
  }

  toggle() {
    this.isVisible = !this.isVisible;

    this.authService.refreshData()

  }

}
