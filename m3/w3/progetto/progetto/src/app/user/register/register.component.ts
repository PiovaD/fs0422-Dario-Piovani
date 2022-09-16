import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormGroup, FormBuilder, ValidationErrors, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  validateForm!: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private authSvc: AuthService) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      name: [null, [Validators.required, Validators.minLength(3)]],
      username: [null, [Validators.required, Validators.pattern('[^ ]*'), Validators.minLength(3)], this.usernameValidator],
      email: [null, [Validators.email, Validators.required], this.emailValidator],
      password: [null, [Validators.required, Validators.minLength(5)]]
    });
  }

  submitForm(): void {
    if (this.validateForm.valid) {

      this.authSvc.register(this.validateForm.value)
        .subscribe(
          res => console.log('HTTP response', res),
          err => console.log('HTTP Error', err),
          () => this.router.navigate(['/login'])


        )

    } else {
      Object.values(this.validateForm.controls).forEach(control => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });
    }
  }

  emailValidator = (control: AbstractControl) => {
    return new Promise<ValidationErrors | null>((resolve) => {
      this.authSvc.getAllUser()
        .subscribe(res => {
          if (res.find(user => user.email == control.value)) {
            resolve({ prohibitedData: true, warning: true })
          } else {
            resolve(null)
          }
        })
    })
  }

  usernameValidator = (control: AbstractControl) => {
    return new Promise<ValidationErrors | null>((resolve) => {
      this.authSvc.getAllUser()
        .subscribe(res => {
          if (res.find(user => user.username.toUpperCase() == control.value.toUpperCase())) {
            resolve({ prohibitedData: true, warning: true })
          } else {
            resolve(null)
          }
        })
    })
  }

}


