import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './section/home/home.component';
import { IntervalComponent } from './section/interval/interval.component';
import { Interval2Component } from './section/interval2/interval2.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    IntervalComponent,
    Interval2Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
