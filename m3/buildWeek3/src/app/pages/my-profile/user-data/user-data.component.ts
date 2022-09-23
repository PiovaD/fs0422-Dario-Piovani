import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { AuthService } from 'src/app/Auth/auth.service';
import { IUser } from 'src/app/Model/iuser';
import { ValidatorService } from 'src/app/Model/validator.service';

@Component({
  selector: 'app-user-data',
  templateUrl: './user-data.component.html',
  styleUrls: ['./user-data.component.scss']
})
export class UserDataComponent implements OnInit {

  editMode: boolean = false;
  updateForm!: FormGroup;

  displayEditMode: boolean = true;

  user: IUser = {
    id: -1,
    name: '',
    username: '',
    email: '',
    avatar: ''
  }

  constructor(
    private authService: AuthService,
    private route: ActivatedRoute,
    private router: Router,
    private errorNotification: NzNotificationService,
    private formBuilder: FormBuilder,
    private validationService: ValidatorService
  ) { }

  ngOnInit(): void {

    this.createForm()
    this.updateForm.disable()

    this.route.params.subscribe(res => {
      this.authService.getUserById(res['id'])
        .subscribe({
          next: (res) => {
            if (this.authService.getLoggedUser()?.user.id == res.id) {
              this.user = res

              this.updateForm.setValue({
                id: res.id,
                name: res.name,
                username: res.username,
                email: res.email
              })

            } else if(this.route.snapshot.parent?.routeConfig?.path == 'user'){

              this.user = res

              this.updateForm.setValue({
                id: res.id,
                name: res.name,
                username: res.username,
                email: res.email
              })

              this.displayEditMode = false

            }else{
              this.router.navigate(['/'])
          }

          }
        })
    })
  }

  resetForm() {
    this.updateForm.setValue({
      id: this.updateForm.value.id,
      name: this.user.name,
      username: this.user.username,
      email: this.user.email
    })
  }

  createForm() {
    this.updateForm = this.formBuilder.group({
      id: '',
      name: ['',
        [Validators.required, Validators.minLength(3)]],

      username: ['',
        [Validators.required, Validators.minLength(3)],
        this.validationService.usernameValidator],

      email: ['',
        [Validators.email, Validators.required],
        this.validationService.emailValidator]
    })
  }

  toggleActive(): void {
    if (!this.editMode) {
      this.editMode = !this.editMode

      this.updateForm.enable()

    } else {
      delete this.user.password

      if (this.updateForm.valid) {
        this.updateUser();
      }
    }
  }

  updateUser(): void {
    this.authService.updateUser(this.updateForm.value)
      .subscribe({
        next: (res) => {
          let currStore = JSON.parse(String(localStorage.getItem('access')))
          if (currStore) {
            currStore.user.name = res.name;
            currStore.user.email = res.email;
            currStore.user.username = res.username;

            localStorage.setItem('access', JSON.stringify(currStore))

          } else {
            currStore = JSON.parse(String(sessionStorage.getItem('access')))

            currStore.user.name = res.name;
            currStore.user.email = res.email;
            currStore.user.username = res.username;

            sessionStorage.setItem('access', JSON.stringify(currStore))
          }

          this.user = res;

        },
        complete: () => {
          this.editMode = false
          this.updateForm.disable()
        },
        error: (err) => {
          console.error('httpError', err);
          this.errorNotification.create(
            'error',
            'Qualcosa è andato storto',
            'Non è stato possibile salvare i cambiamenti riprova più tardi',
            { nzPlacement: 'top' }
          );
        },

      })
  }

  deleteUser(){
    this.authService.deleteUser(this.user)
    .subscribe({
      complete: () =>{
        this.authService.removeAccess();
         this.router.navigate(['/'])}
    })
  }
}
