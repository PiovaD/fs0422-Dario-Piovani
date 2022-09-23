import { Injectable } from '@angular/core';
import { AbstractControl, ValidationErrors } from '@angular/forms';
import { AuthService } from '../Auth/auth.service';
import { IUser } from './iuser';

@Injectable({
  providedIn: 'root'
})
export class ValidatorService {

  constructor(private authService: AuthService) { }

  emailValidator = (control: AbstractControl): Promise<ValidationErrors | null> => {
    let currentUser = this.authService.getLoggedUser()
    return new Promise<ValidationErrors | null>((resolve) => {
      this.authService.getAllUsers()
        .subscribe((res) => {
          if (res.find((user: IUser) =>
            (user.email == control.value) &&
            (user.email != currentUser?.user.email))) {
            resolve({ prohibitedData: true, warning: true })
          } else {
            resolve(null)
          }
        });
    });
  };

  usernameValidator = (control: AbstractControl) => {
    let currentUser = this.authService.getLoggedUser()
    return new Promise<ValidationErrors | null>((resolve) => {
      this.authService.getAllUsers().subscribe((res) => {
        if (res.find((user: IUser) =>

          (user.username.toUpperCase() == control.value.toUpperCase()) &&
          (user.username.toUpperCase() != currentUser?.user.username.toUpperCase())
        )) {
          resolve({ prohibitedData: true, warning: true })
        } else {
          resolve(null)
        }
      });
    });
  };
}
