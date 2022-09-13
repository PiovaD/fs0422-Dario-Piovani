import { Component, OnInit } from '@angular/core';
import { NgForm, NgModel } from '@angular/forms';

type hero = {
  name: string,
  alterEgo: string,
  supePower: string,
  enemy: string,
  planet: string,
  weakness: string
}

@Component({
  selector: 'app-td-form',
  templateUrl: './td-form.component.html',
  styleUrls: ['./td-form.component.scss']
})
export class TdFormComponent implements OnInit {

  constructor() { }

  arrHeros: hero[] = []

  ngOnInit(): void {
  }

  submit(form: NgForm) {

    if (form.valid) {
      this.arrHeros.push(form.value)
      form.reset()
    }

    console.log(this.arrHeros)
  }

  isValid(field: NgModel): boolean | null {
    return field.invalid && (field.touched || field.dirty)
  }

}
