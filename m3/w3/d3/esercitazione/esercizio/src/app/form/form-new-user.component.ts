import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-form-new-user',
  template: `
  <form class="container" (ngSubmit)="save(form)" #form="ngForm">
      <input type="text" ngModel name="name" placeholder="Nome" class="form-control" required>
      <input type="email" ngModel name="email" placeholder="Email" class="form-control" required>
      <select name="role" ngModel class="form-control" required>
        <option value="user">User</option>
        <option value="admin">Admin</option>
      </select>
      <button class="btn btn-primary">Salva</button>
  </form>
  `,
  styles: [
  ]
})
export class FormNewUserComponent implements OnInit {

  @ViewChild('form') form!: NgForm;

  constructor(private userSvc: UsersService) { }

  ngOnInit(): void {
  }

  save(form: NgForm){
    if(form.valid){
      this.userSvc.saveUser(form.value)

      form.reset()

    }
  }
}
