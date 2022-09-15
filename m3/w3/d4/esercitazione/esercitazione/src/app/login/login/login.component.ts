import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { IUser } from 'src/app/Model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @ViewChild('form') form!: NgForm;

  constructor(private authSvc: AuthService, private router:Router) { }

  user!: IUser;

  ngOnInit(): void {
  }

  onSubmit(form: NgForm){
    if (form.valid) {

      this.user = form.value

      this.authSvc.login(this.user)
        .subscribe(res => {
          this.authSvc.saveAccess(res);
          this.router.navigate(['home'])
        })

      form.reset()

    }
  }

}
