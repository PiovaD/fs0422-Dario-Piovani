import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UtentiNewComponent } from './utenti/utenti-new/utenti-new.component';
import { UtentiListComponent } from './utenti/utenti-list/utenti-list.component';
import { UtentiEditComponent } from './utenti/utenti-edit/utenti-edit.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    UtentiNewComponent,
    UtentiListComponent,
    UtentiEditComponent
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
