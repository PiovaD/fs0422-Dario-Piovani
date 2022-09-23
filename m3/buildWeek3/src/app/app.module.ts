import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { it_IT } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import it from '@angular/common/locales/it';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavBarComponent } from './nav/nav-bar/nav-bar.component';
import { HomeComponent } from './pages/home/home.component';
import { NgZorroModule } from './shared/ng-zorro/ng-zorro.module';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { ModaleComponent } from './nav/modale/modale.component';
import { FormModaleModule } from './nav/modale/form-modale/form-modale.module';
import { ShowPostModule } from './Model/show-post/show-post.module';
import { AuthInterceptor } from './Auth/auth.interceptor';
registerLocaleData(it);

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    ModaleComponent,
  ],
  imports: [
    NzModalModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NgZorroModule,
    FormModaleModule,
    ShowPostModule
  ],
  providers: [
    { provide: NZ_I18N, useValue: it_IT },
    {
      provide:HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
