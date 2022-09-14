import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActivePostsPage } from '../active-posts.page';
import { PostDetailsPage } from '../post-details.page';

const routes: Routes = [
  {
    path: '',
    component: ActivePostsPage
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
export class ActiveRoutingModule { }
