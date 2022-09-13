import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormComponent } from './reactive-form/reactive-form.component';
import { TdFormComponent } from './td-form/td-form.component';

const routes: Routes = [
  {
    path: '',
    component: TdFormComponent
  },
  {
    path: 'reactive',
    component: ReactiveFormComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
