import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from 'src/app/auth.guard';
import { UsersDetailsPage } from '../users-details.page';
import { UsersPage } from '../users.page';

const routes: Routes = [

  {
    path: "",
    component: UsersPage,
  },
  {
    path: ":id",
    component: UsersDetailsPage,
    canActivate: [AuthGuard]
  }

]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
