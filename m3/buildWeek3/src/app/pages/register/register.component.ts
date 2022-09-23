import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { AuthService } from 'src/app/Auth/auth.service';
import { ValidatorService } from 'src/app/Model/validator.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
  validateForm!: FormGroup;
  isLoading: boolean = false;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private errorNotification: NzNotificationService,
    private validationService: ValidatorService
  ) {}

  ngOnInit(): void {
    this.validateForm = this.formBuilder.group({
      name: [null, [Validators.required, Validators.minLength(3)]],
      username: [
        null,
        [Validators.required, Validators.minLength(3)],
        this.validationService.usernameValidator,
      ],
      email: [
        null,
        [Validators.email, Validators.required],
        this.validationService.emailValidator,
      ],
      password: [null, [Validators.required, Validators.minLength(5)]],
      confirm: ['', [this.confirmValidator]],
    });
  }

  submitForm(): void {
    this.isLoading = true;
    delete this.validateForm.value.confirm
    this.authService.register(this.validateForm.value)
    .subscribe({
      complete: () => this.router.navigate(['/login']),
      error: (err) => {
        console.error('httpError', err.error);
        this.isLoading = false;
        this.errorNotification.create(
          'error',
          'Qualcosa è andato storto',
          'Non è stato possibile registrati riprova più tardi',
          { nzPlacement: 'top' }
          );
      },
    });
  }

  resetForm(): void {
    this.validateForm.reset();
  }

  confirmValidator = (
    control: FormControl
  ): { [s: string]: boolean } | null => {
    if (control.value && control.value != this.validateForm.value.password) {
      return { error: true };
    }
    return null;
  };

}
