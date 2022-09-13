import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive-forms',
  templateUrl: './reactive-forms.component.html',
  styleUrls: ['./reactive-forms.component.scss']
})
export class ReactiveFormsComponent implements OnInit {

  constructor() { }

  form!: FormGroup

  ngOnInit(): void {

    this.form = new FormGroup({
      name: new FormControl(null, [Validators.required, this.UserNameValidator]),
      lastname: new FormControl(null, [Validators.required, Validators.minLength(2)]),
      email: new FormControl(null, [Validators.required, Validators.email], [this.emailAllowedValidator]),
      userAddress: new FormGroup({
        address: new FormControl(),
        city: new FormControl(),
        zipcode: new FormControl()
      }),
      sports: new FormArray([])

    })

  }

  getControl(name: string) {
    return this.form.get(name)
  }

  checkFullValidity(name: string) {
    return this.getControl(name)?.invalid && this.getControl(name)?.dirty && this.getControl(name)?.touched
  }

  submit() {

    console.log(this.form)

  }

  addSport(){
    let control:FormControl = new FormControl(null)
    let sports = <FormArray>this.form.get('sports')
    sports.push(control)
  }

  getSports(){
    return (this.form.get('sports') as FormArray).controls
  }

  /** custom validation*/

  usernameProibiti: string[] = ['admin', 'administrator'];

  UserNameValidator = (control: FormControl) => {
    if (this.usernameProibiti.includes(control.value?.toLowerCase())) {
      return { proibito: true }
    }
    return null
  }

  // validatore async

  emailProibiti: string[] = ['admin@admin.it', 'administrator@administrator.it']
  emailAllowedValidator = (control: AbstractControl) => {
    return new Promise<ValidationErrors | null>((resolve)=>{
      setTimeout(()=>{

        if(this.emailProibiti.includes(control.value)){
          resolve({emailProibiti: true})
        }else{
          resolve(null)
        }

      },2000)
    })
  }


}
