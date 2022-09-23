import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/Auth/auth.service';
import { IPost } from 'src/app/Model/ipost';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.scss']
})
export class MyProfileComponent implements OnInit {

  userId!: number | string

  posts: IPost[] = []

  constructor(private authService: AuthService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe({
      next: (res) => {
        this.userId = res['id']

        this.authService.getAllUsers()
          .subscribe(users => {
            this.authService.getAllPost()
              .subscribe({
                next: posts => {

                  posts = posts.filter(post => post.userId == this.userId || post.parentId)

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

      },
      error: (err) => {
        console.error(err)
        this.router.navigate(['/'])
      }
    })

  }


}
