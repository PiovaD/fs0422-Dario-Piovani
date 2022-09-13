import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsComponent } from './forms/forms.component';
import { NgModelGroupComponent } from './ng-model-group/ng-model-group.component';
import { NgSubmitComponent } from './ng-submit/ng-submit.component';
import { ReactiveFormsComponent } from './reactive-forms/reactive-forms.component';

const routes: Routes = [
  {
  path:'',
  component: FormsComponent
},
{
  path:'ngSubmit',
  component: NgSubmitComponent
},
{
  path:'ngModelGroup',
  component: NgModelGroupComponent
},
{
  path:'reactiveForms',
  component: ReactiveFormsComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
