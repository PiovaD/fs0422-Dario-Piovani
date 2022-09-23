import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SearchRoutingModule } from './search-routing.module';
import { SearchComponent } from './search.component';
import { NzSharedFormModule } from 'src/app/shared/ng-zorro/nz-shared-form.module';
import { ShowPostModule } from 'src/app/Model/show-post/show-post.module';
import { NzDividerModule } from 'ng-zorro-antd/divider';
import { NzEmptyModule } from 'ng-zorro-antd/empty';
import { NzAvatarModule } from 'ng-zorro-antd/avatar';
import { NzListModule } from 'ng-zorro-antd/list';
import { NzTypographyModule } from 'ng-zorro-antd/typography';

@NgModule({
  declarations: [
    SearchComponent
  ],
  imports: [
    CommonModule,
    SearchRoutingModule,
    NzSharedFormModule,
    ShowPostModule,
    NzDividerModule,
    NzEmptyModule,
    NzAvatarModule,
    NzListModule,
    NzTypographyModule
  ]
})
export class SearchModule { }
