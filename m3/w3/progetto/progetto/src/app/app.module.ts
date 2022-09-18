import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { it_IT } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import it from '@angular/common/locales/it';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { HeaderComponent } from './nav/header/header.component';
import { NzGridModule } from 'ng-zorro-antd/grid';
import { NzMenuModule } from 'ng-zorro-antd/menu';
import { PostsComponent } from './pages/posts/posts.component';
import { LoginButtonComponent } from './nav/login-button/login-button.component';
import { NzAvatarModule } from 'ng-zorro-antd/avatar';
import { NzSkeletonModule } from 'ng-zorro-antd/skeleton';
import { NzEmptyModule } from 'ng-zorro-antd/empty';
import { PostComponent } from './Model/post/post.component';
import { NzCommentModule } from 'ng-zorro-antd/comment'
import { NzListModule } from 'ng-zorro-antd/list';
import { PostFormModule } from './Model/post-form/post-form.module';

registerLocaleData(it);

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PostsComponent,
    LoginButtonComponent,
    PostComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NzLayoutModule,
    NzMenuModule,
    NzButtonModule,
    NzIconModule,
    NzGridModule,
    NzAvatarModule,
    NzSkeletonModule,
    NzEmptyModule,
    NzCommentModule,
    NzListModule,
    PostFormModule

  ],
  providers: [
    { provide: NZ_I18N, useValue: it_IT }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
