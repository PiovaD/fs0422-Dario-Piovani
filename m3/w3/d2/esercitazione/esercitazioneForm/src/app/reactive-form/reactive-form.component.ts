import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, NgModel, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.scss']
})
export class ReactiveFormComponent implements OnInit {

  constructor() { }

  arrHeros: any[] = []

  form!: FormGroup;

  ngOnInit(): void {
    this.form = new FormGroup({
      name: new FormControl(null, [Validators.required]),
      alterEgo: new FormControl(null, [Validators.required]),
      enemy: new FormControl(null, [Validators.maxLength(10)]),
      planet: new FormControl(null, [Validators.required, Validators.minLength(5)]),
      superPower: new FormArray([], [Validators.required]),
      weakness: new FormArray([])
    })
  }

  submit() {

    if (this.form.valid) {

      this.arrHeros.push(this.form.value)

      this.form.reset();

      let sP = <FormArray>this.form.get('superPower')
      sP.clear()

      let weak = <FormArray>this.form.get('weakness')
      weak.clear()

      console.log(this.arrHeros)

    }
  }

  getControl(name: string) {
    return this.form.get(name)
  }

  isValid(field: string): boolean | undefined {
    return this.getControl(field)?.invalid && (this.getControl(field)?.touched || this.getControl(field)?.dirty)
  }

  addElement(name: string) {
    let control: FormControl = new FormControl(null, [Validators.required]);
    let newElement = <FormArray>this.form.get(name);
    newElement.push(control)
  }

  getElement(name: string) {
    return (this.form.get(name) as FormArray).controls
  }

  removeElement(name: string, index: number) {
    let element = <FormArray>this.form.get(name);
    element.removeAt(index);
  }

}
