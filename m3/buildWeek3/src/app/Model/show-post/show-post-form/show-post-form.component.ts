import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { AuthService } from 'src/app/Auth/auth.service';

@Component({
  selector: 'app-show-post-form',
  templateUrl: './show-post-form.component.html',
  styleUrls: ['./show-post-form.component.scss']
})
export class ShowPostFormComponent implements OnInit {

  @Input() loggedUser: any;
  @Input() item: any;
  @Output() update: EventEmitter<any> = new EventEmitter

  contentValue = '';
  isLoading = false;

  constructor(
    private authService: AuthService,
    private formBuilder: FormBuilder,
    private errorNotification: NzNotificationService) { }

  ngOnInit(): void {
  }

  handleSubmit(): void {
    this.isLoading = true;
    const content: FormGroup = this.formBuilder.group({
      parentId: this.item.id,
      userId: this.loggedUser.user.id,
      title: '',
      content: this.contentValue,
      date: new Date(),
      allLikeId: [[]],
      allDislikeId: [[]]
    });


    this.authService.addPost(content.value)
  .subscribe({
    next: () => this.isLoading = false,
    complete: () => this.update.emit(this.item),
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

  }

}

