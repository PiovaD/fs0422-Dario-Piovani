import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-primi-list',
  templateUrl: './primi-list.component.html',
  styleUrls: ['./primi-list.component.scss']
})
export class PrimiListComponent implements OnInit {

  primi: string[] = [
    'Penne alla carbonara',
    'spaghetti allo scoglio',
    'pasta al pomodoro'
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
