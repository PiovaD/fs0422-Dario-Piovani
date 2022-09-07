import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormComponent } from './form/form.component';
import { ActiveComponent } from './post/active/active.component';
import { InactiveComponent } from './post/inactive/inactive.component';

const routes: Routes = [
  {
    path:'',
    component: FormComponent
  },
  {
    path:'post/active',
    component: ActiveComponent
  }
  ,
  {
    path:'post/inactive',
    component: InactiveComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
