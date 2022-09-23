import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormModaleComponent } from './form-modale.component';
import { NzSharedFormModule } from 'src/app/shared/ng-zorro/nz-shared-form.module';



@NgModule({
  declarations: [
    FormModaleComponent
  ],
  imports: [
    CommonModule,
    NzSharedFormModule
  ],
  exports: [
    FormModaleComponent
  ]
})
export class FormModaleModule { }
