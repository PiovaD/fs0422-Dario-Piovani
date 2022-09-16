import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  validateForm!: FormGroup;
  isLoading = false;
  errorMsg = false;

  constructor(private fb: FormBuilder,private router: Router ,private authSvc: AuthService) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      email: [null, [Validators.required]],
      password: [null, [Validators.required]],
      remember: [true]
    });
  }

  submitForm(): void {
    this.errorMsg = false
    if (this.validateForm.valid) {
      this.isLoading = true;

      this.authSvc.login(this.validateForm.value)
      .subscribe({
        next: (res) =>{
          this.authSvc.saveAccess(res, this.validateForm.value.remember)
        },
        complete: () => this.router.navigate(['/posts']),
        error: (err) => {
          this.errorMsg = true;
          this.isLoading = false;
          console.log('HTTP Error', err)
        }
      })

    } else {
      Object.values(this.validateForm.controls).forEach(control => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });
    }
  }

}
