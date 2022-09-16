import { NgModule } from '@angular/core';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { SharedNzFormModule } from 'src/app/shared/shared-nz-form.module';


@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    LoginRoutingModule,
    SharedNzFormModule
  ]
})
export class LoginModule { }
