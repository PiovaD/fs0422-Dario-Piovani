import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegisterRoutingModule } from './register-routing.module';
import { RegisterComponent } from './register.component';
import { SharedNzFormModule } from 'src/app/shared/shared-nz-form.module';
import { UserFormComponent } from '../user-form/user-form.component';


@NgModule({
  declarations: [
    RegisterComponent,
    UserFormComponent
  ],
  imports: [
    CommonModule,
    RegisterRoutingModule,
    SharedNzFormModule
  ]
})
export class RegisterModule { }
