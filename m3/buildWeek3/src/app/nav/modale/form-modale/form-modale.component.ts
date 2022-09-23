import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { AuthService } from 'src/app/Auth/auth.service';


@Component({
  selector: 'app-form-modale',
  templateUrl: './form-modale.component.html',
  styleUrls: ['./form-modale.component.scss']
})
export class FormModaleComponent implements OnInit {

  @Output() isVisible = new EventEmitter<boolean>()

  isLoading: boolean = false
  postForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private errorNotification: NzNotificationService
  ) { }

  ngOnInit(): void {
    this.postForm = this.formBuilder.group({
      userId: this.authService.getLoggedUser()?.user.id,
      title: [null, [Validators.required, Validators.minLength(2)]],
      content: [null, [Validators.required, Validators.minLength(10)]],
      date: new Date(),
      allLikeId: [[]],
      allDislikeId: [[]]
    });
  }

  onSubmit(): void {
    if (this.postForm.valid) {
      this.isLoading = true;
      this.postForm.patchValue({ date: new Date() })

      this.authService.addPost(this.postForm.value)
        .subscribe({
          complete: () => {
            this.isVisible.emit(false)
          },
          error: (err) => {
            console.error('httpError', err)
            this.isLoading = false;
            this.errorNotification.create(
              'error',
              'Qualcosa è andato storto',
              'Non è stato possibile Pubblicare il post, riprova più tardi',
              { nzPlacement: 'top' }
            );
          }
        })
    } else {
      Object.values(this.postForm.controls).forEach((control) => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });
    }

  }

}

