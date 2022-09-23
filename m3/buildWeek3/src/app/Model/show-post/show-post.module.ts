import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShowPostComponent } from './show-post.component';
import { NzCommentModule } from 'ng-zorro-antd/comment';
import { NzAvatarModule } from 'ng-zorro-antd/avatar';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzListModule } from 'ng-zorro-antd/list';
import { NzToolTipModule } from 'ng-zorro-antd/tooltip';
import { ShowPostFormComponent } from './show-post-form/show-post-form.component';
import { NzDividerModule } from 'ng-zorro-antd/divider';
import { NzCollapseModule } from 'ng-zorro-antd/collapse';
import { NzSharedFormModule } from 'src/app/shared/ng-zorro/nz-shared-form.module';
import { RouterModule } from '@angular/router';
import { NzTypographyModule } from 'ng-zorro-antd/typography';
import { NzSkeletonModule } from 'ng-zorro-antd/skeleton';

@NgModule({
  declarations: [
    ShowPostComponent,
    ShowPostFormComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    NzCommentModule,
    NzAvatarModule,
    NzIconModule,
    NzListModule,
    NzToolTipModule,
    NzDividerModule,
    NzCollapseModule,
    NzSharedFormModule,
    NzTypographyModule,
    NzSkeletonModule

  ],
  exports: [
    ShowPostComponent
  ]
})
export class ShowPostModule { }
