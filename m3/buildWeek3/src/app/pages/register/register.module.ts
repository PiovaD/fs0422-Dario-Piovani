import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegisterRoutingModule } from './register-routing.module';
import { RegisterComponent } from './register.component';
import { NzSharedFormModule } from 'src/app/shared/ng-zorro/nz-shared-form.module';


@NgModule({
  declarations: [
    RegisterComponent
  ],
  imports: [
    CommonModule,
    RegisterRoutingModule,
    NzSharedFormModule
  ]
})
export class RegisterModule { }
