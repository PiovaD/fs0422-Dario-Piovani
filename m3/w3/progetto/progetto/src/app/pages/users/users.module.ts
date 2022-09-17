import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsersRoutingModule } from './users-routing.module';
import { UsersComponent } from './users.component';
import { SharedNzFormModule } from 'src/app/shared/shared-nz-form.module';
import { MyUserComponent } from './my-user/my-user.component';


@NgModule({
  declarations: [
    UsersComponent,
    MyUserComponent,
  ],
  imports: [
    CommonModule,
    UsersRoutingModule,
    SharedNzFormModule
  ]
})
export class UsersModule { }
