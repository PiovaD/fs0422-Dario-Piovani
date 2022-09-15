import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-modla-content',
  templateUrl: './modla-content.component.html',
  styleUrls: ['./modla-content.component.scss']
})
export class ModlaContentComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<ModlaContentComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {}

  ngOnInit(): void {
  }

}
