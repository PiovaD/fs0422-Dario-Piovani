import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CardComponent } from './card/card.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ErrorHttpInterceptor } from './error-http.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
        {
          provide:HTTP_INTERCEPTORS,
          useClass:ErrorHttpInterceptor,
          multi: true
        }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
