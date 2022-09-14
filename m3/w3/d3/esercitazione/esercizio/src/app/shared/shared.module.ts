import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostCardComponent } from '../components/post-card.component';
import { HighlightDirective } from '../directives/highlight.directive';
import { MaiuscoloPipe } from '../pipes/maiuscolo.pipe';
import { PostDetailsPage } from '../pages/post-details.page';



@NgModule({
  declarations: [
    PostCardComponent,
    MaiuscoloPipe,
    HighlightDirective,
    PostDetailsPage
  ],
  imports: [
    CommonModule
  ],
  exports: [
    CommonModule,
    PostCardComponent,
    MaiuscoloPipe,
    HighlightDirective
  ]
})
export class SharedModule { }
