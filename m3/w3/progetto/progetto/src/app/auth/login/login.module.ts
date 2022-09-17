import { NgModule } from '@angular/core';
import { UserFormModule } from 'src/app/Model/user-form/user-form.module';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';


@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    LoginRoutingModule,
    UserFormModule
  ]
})
export class LoginModule { }
