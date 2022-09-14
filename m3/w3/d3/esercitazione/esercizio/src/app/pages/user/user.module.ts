import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { UsersDetailsPage } from '../users-details.page';
import { UsersPage } from '../users.page';
import { UserRoutingModule } from './user-routing.module';



@NgModule({
  declarations: [
    UsersPage,
    UsersDetailsPage
  ],
  imports: [
    UserRoutingModule,
    SharedModule,
    FormsModule
  ]
})
export class UserModule { }
