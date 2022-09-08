import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormComponent } from './form/form.component';
import { PostDetailsComponent } from './post/post-details/post-details.component';
import { PostComponent } from './post/post.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: FormComponent
  },
  {
    path: 'post',

    children: [
      {
        path: ':isActive',
        component: PostComponent
      },
      {
        path: 'dettagli/:id',
        component: PostDetailsComponent
      }
    ]
  },
  {
    path: '**',
    redirectTo: ''
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
