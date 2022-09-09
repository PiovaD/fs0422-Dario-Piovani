import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompletedComponent } from './section/todos/completed/completed.component';
import { TodosComponent } from './section/todos/todo/todos.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'todo'
  },
  {
    path: 'todo',
    children: [
      {
        path: '',
        component: TodosComponent
      },
      {
        path: 'completed',
        component: CompletedComponent
      }
    ]
  },
  {
    path: '**',
    redirectTo: 'todo'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
