import { NgModule } from '@angular/core';
import { ActivePostsPage } from '../active-posts.page';
import { ActiveRoutingModule } from './active-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';



@NgModule({
  declarations: [
    ActivePostsPage
  ],
  imports: [
    ActiveRoutingModule,
    SharedModule
  ]
})
export class ActiveModule { }
