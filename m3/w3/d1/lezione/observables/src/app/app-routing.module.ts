import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './section/home/home.component';
import { IntervalComponent } from './section/interval/interval.component';
import { Interval2Component } from './section/interval2/interval2.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'interval',
    component: IntervalComponent
  },
  {
    path: 'interval2',
    component: Interval2Component
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
