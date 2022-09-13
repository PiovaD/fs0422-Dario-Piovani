import { Component, OnInit } from '@angular/core';

type user={
  name: string,
  lastName: string,
}

@Component({
  selector: 'app-forms',
  templateUrl: './forms.component.html',
  styleUrls: ['./forms.component.scss']
})
export class FormsComponent implements OnInit {


  constructor() { }

  ngOnInit(): void {
  }

  userData: user = {
    name: 'Rossana',
    lastName: 'Bianchi'
  }

}
