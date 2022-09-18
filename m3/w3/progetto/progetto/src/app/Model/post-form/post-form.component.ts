import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/auth/auth.service';
import { IPost } from 'src/app/auth/ipost';
import { IUser } from 'src/app/auth/iuser';

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.scss']
})
export class PostFormComponent implements OnInit {

  postForm!: FormGroup;

  user?: IUser;
  @Input() data!: IPost[];
  @Output() newData: EventEmitter<IPost> = new EventEmitter<IPost>();

  constructor(private authSvc: AuthService) { }

  ngOnInit(): void {

    this.postForm = new FormGroup({
      comment: new FormControl(null, [Validators.required, Validators.maxLength(100)])
    })

    this.user = this.authSvc.getLoggedUser()
  }

  onSubmit(): void {
    if (this.user && this.postForm.valid) {

      let post: IPost = {
        author: this.user.username,
        avatar: this.user.id,
        content: this.postForm.value.comment,
        datetime: new Date()
      }
      this.authSvc.newPost(post)
        .subscribe({
          next: (res) => this.newData.emit(res),
          complete: () => {

            this.postForm.reset()
          },
          error: (err) => console.log('HTTP Error', err)

        })

    } else if (!this.user) {
      console.error("Utente non loggato")
    }
  }

}
