import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/Auth/auth.service';
import { IPost } from 'src/app/Model/ipost';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  posts: IPost[] = [];

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.authService.getAllUsers()
      .subscribe(users => {
        this.authService.getAllPost()
          .subscribe({
           next: posts => {
              posts = posts.map(post => {
                let user = users.find(user => user.id == post.userId)
                post.userObj = user
                post.replayForm = false
                return post
              })
              this.posts = posts.reverse()
            }
          })
      })
  }


}
