import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoggedHomeRoutingModule } from './logged-home-routing.module';
import { LoggedHomeComponent } from './logged-home.component';


@NgModule({
  declarations: [
    LoggedHomeComponent
  ],
  imports: [
    CommonModule,
    LoggedHomeRoutingModule
  ]
})
export class LoggedHomeModule { }
