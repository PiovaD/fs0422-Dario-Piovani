import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PostDetailsPage } from '../post-details.page';
import { InactivePostsPage } from '../inactive-posts.page';

const routes: Routes = [
  {
    path: '',
    component: InactivePostsPage
  },
  {
    path:":id",
    component:PostDetailsPage
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InactiveRoutingModule { }
