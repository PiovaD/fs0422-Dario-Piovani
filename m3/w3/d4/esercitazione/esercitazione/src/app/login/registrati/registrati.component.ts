import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { IUser } from 'src/app/Model/user';

@Component({
  selector: 'app-registrati',
  templateUrl: './registrati.component.html',
  styleUrls: ['./registrati.component.scss']
})
export class RegistratiComponent implements OnInit {

  @ViewChild('form') form!: NgForm;

  user!: IUser;

  constructor(private authSvc: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm) {
    if (form.valid) {

      this.user = form.value
      console.log(this.user)

      this.authSvc.register(this.user)
        .subscribe(res => {
          console.log(res);
          this.router.navigate(['/login']);
        })

      form.reset()

    }
  }

}
