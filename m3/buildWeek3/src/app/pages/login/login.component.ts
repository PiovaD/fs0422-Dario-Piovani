import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { AuthService } from 'src/app/Auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  validateForm!: FormGroup;
  isLoading: boolean = false;

  passwordVisible = false;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private errorNotification: NzNotificationService
  ) {}

  ngOnInit(): void {
    this.validateForm = this.formBuilder.group({
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required]],
      remember: [true, [Validators.required]],
    });
  }

  submitForm(): void {
    if (this.validateForm.valid) {
      this.isLoading = true;
      this.authService.login(this.validateForm.value).subscribe({
        next: (res) => this.authService.saveAccess(res, this.validateForm.value.remember),
        complete: () => this.router.navigate(['/']),
        error: (err) => {
          console.error(this.validateForm.value);
          console.error('httpError', err.error);
          this.isLoading = false;
          this.errorNotification.create(
            'error',
            'Qualcosa è andato storto',
            'Non è stato possibile effettuare il login, email o password errati. Ricontrolla i dati e riprova',
            { nzPlacement: 'top' }
          );
        },
      });
    } else {
      Object.values(this.validateForm.controls).forEach((control) => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });
    }
  }
}
