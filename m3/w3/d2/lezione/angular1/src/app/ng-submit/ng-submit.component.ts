import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-ng-submit',
  templateUrl: './ng-submit.component.html',
  styleUrls: ['./ng-submit.component.scss']
})
export class NgSubmitComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  submit(form:NgForm) {
    console.log(form.value)
  }
}
