import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoggedHomeComponent } from './logged-home.component';

const routes: Routes = [{ path: '', component: LoggedHomeComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoggedHomeRoutingModule { }
