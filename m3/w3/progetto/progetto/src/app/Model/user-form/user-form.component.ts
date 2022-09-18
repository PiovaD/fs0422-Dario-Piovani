import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { AbstractControl, FormGroup, FormBuilder, ValidationErrors, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent implements OnInit {
  validateForm!: FormGroup;
  @Output() isLoading = new EventEmitter<boolean>(false);
  errorMsg = false;

  constructor(private fb: FormBuilder, private router: Router, private authSvc: AuthService) { }

  ngOnInit(): void {

    if (this.authSvc.isLogged()) {

      let currentUser = this.authSvc.getLoggedUser()

      this.validateForm = this.fb.group({
        id: [currentUser?.id],
        name: [currentUser?.name, [Validators.required, Validators.minLength(3)]],
        username: [currentUser?.username, [Validators.required, Validators.pattern('[^ ]*'), Validators.minLength(3)], this.usernameValidator],
        email: [currentUser?.email, [Validators.email, Validators.required], this.emailValidator],
        password: [null, [Validators.required, Validators.minLength(5)]]
      })

    } else {
      this.validateForm = this.fb.group({
        name: [null, [Validators.required, Validators.minLength(3)]],
        username: [null, [Validators.required, Validators.pattern('[^ ]*'), Validators.minLength(3)], this.usernameValidator],
        email: [null, [Validators.email, Validators.required], this.emailValidator],
        password: [null, [Validators.required, Validators.minLength(5)]]
      });
    }
  }

  submitForm(): void {
    this.errorMsg = false

    if (this.validateForm.valid) {
      this.isLoading.emit(true);

      if (this.authSvc.isLogged()) {
        this.updateUser()
      } else {
        this.newUser()
      }

    } else {
      Object.values(this.validateForm.controls).forEach(control => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });
    }
  }

  newUser() {
    this.authSvc.register(this.validateForm.value)
      .subscribe({
        next: (res) => console.log('HTTP response', res),
        complete: () => this.router.navigate(['/login']),
        error: (err) => {
          this.errorMsg = true
          this.isLoading.emit(false);
          console.log('HTTP Error', err)
        }
      })
  }

  updateUser() {
    this.authSvc.updateUser(this.validateForm.value)
      .subscribe({
        next: (res) => {
          res.password = '#######';
          if (localStorage.getItem('access')) {
            localStorage.setItem('access', JSON.stringify(res))
          }
          if (sessionStorage.getItem('access')) {
            sessionStorage.setItem('access', JSON.stringify(res))
          }
        },
        complete: () => this.router.navigate(['/']),
        error: (err) => {
          this.errorMsg = true
          this.isLoading.emit(false);
          console.log('HTTP Error', err)
        }
      })

  }

  emailValidator = (control: AbstractControl) => {
    let currentUser = this.authSvc.getLoggedUser()
    return new Promise<ValidationErrors | null>((resolve) => {
      this.authSvc.getAllUser()
        .subscribe(res => {
          if (res.find(user =>
            (user.email == control.value) &&
            (user.email != currentUser?.email))) {
            resolve({ prohibitedData: true, warning: true })
          } else {
            resolve(null)
          }
        })
    })
  }

  usernameValidator = (control: AbstractControl) => {
    let currentUser = this.authSvc.getLoggedUser()
    return new Promise<ValidationErrors | null>((resolve) => {
      this.authSvc.getAllUser()
        .subscribe(res => {
          if (res.find(user =>
            (user.username.toUpperCase() == control.value.toUpperCase()) &&
            (user.username.toUpperCase() != currentUser?.username.toUpperCase())
          )) {
            resolve({ prohibitedData: true, warning: true })
          } else {
            resolve(null)
          }
        })
    })
  }

}

