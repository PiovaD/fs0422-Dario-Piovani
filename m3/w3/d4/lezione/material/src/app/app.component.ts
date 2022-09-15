import { Component } from '@angular/core';

import {MatDialog} from '@angular/material/dialog';
import { ModlaContentComponent } from './modla-content/modla-content.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'material';

  constructor(public dialog: MatDialog) { }

  name!:string

  openDialog() {
    const dialogRef = this.dialog.open(ModlaContentComponent, {
      width: '250px',
      data: {name: this.name}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }




  items = Array.from({length: 100000}).map((_, i) => `Item #${i}`);
}
