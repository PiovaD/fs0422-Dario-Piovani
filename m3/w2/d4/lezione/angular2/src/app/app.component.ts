import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  persona = {
    nome: 'Mario',
    cognome: 'Rossi'
  }
}
