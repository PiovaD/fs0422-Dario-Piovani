import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-ng-model-group',
  templateUrl: './ng-model-group.component.html',
  styleUrls: ['./ng-model-group.component.scss']
})
export class NgModelGroupComponent implements OnInit {

  @ViewChild('form') form!: NgForm

  constructor() { }

  ngOnInit(): void {
  }

  userForm: any = {

    name: '',
    lastName: '',
    street: '',
    city: '',
    zipcode: ''
  }

  submit(form: NgForm): void {
    console.log(form);
    this.form.reset()
  }

  riempi() {
    console.log(this.form)
    this.form.form.setValue({
      name: 'Rossana',
      lastName: 'Bianchi',
      userAddres: {
        street: 'Via Roma 5',
        city: 'Mialno',
        zipcode: '22122'
      }
    })
  }

  aggiorna() {
    this.form.form.patchValue({
      userAddres: {
        street: 'Via Roma 5',
        city: 'Mialno',
        zipcode: '22122'
      }
    })
  }
}
