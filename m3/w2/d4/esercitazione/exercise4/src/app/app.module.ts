import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';
import { HeaderComponent } from './header/header.component';
import { PostCardComponent } from './Models/post-card/post-card.component';
import { PostComponent } from './post/post.component';
import { TxtMaiuscPipe } from './Models/txt-maiusc.pipe';
import { PostDetailsComponent } from './post/post-details/post-details.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FormComponent,
    PostCardComponent,
    PostComponent,
    TxtMaiuscPipe,
    PostDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
