import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { NzSharedFormModule } from 'src/app/shared/ng-zorro/nz-shared-form.module';



@NgModule({
  declarations: [
    LoginComponent,

  ],
  imports: [
    CommonModule,
    LoginRoutingModule,
    NzSharedFormModule
  ]
})
export class LoginModule { }
