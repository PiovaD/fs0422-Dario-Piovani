import { NgModule } from '@angular/core';
import { SharedModule } from 'src/app/shared/shared.module';
import { InactivePostsPage } from '../inactive-posts.page';
import { InactiveRoutingModule } from './inactive-routing.module';



@NgModule({
  declarations: [
    InactivePostsPage
  ],
  imports: [
    InactiveRoutingModule,
    SharedModule
  ]
})
export class InactiveModule { }
