import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PrimiDetailComponent } from './primi-detail/primi-detail.component';
import { PrimiListComponent } from './primi-list/primi-list.component';
import { PrimiComponent } from './primi/primi.component';

const routes: Routes = [

  {
    path: '',
    component: PrimiComponent,
    children: [
      {
        path: '',
        component: PrimiListComponent
      }
    ]
  },
  {
    path: 'detail/:id',
    component: PrimiDetailComponent
  }


]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class PrimiRoutingModule { }
