import { Component, OnInit } from '@angular/core';
import { Post } from '../post';
import { PostService } from '../post.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.scss']
})
export class PostsComponent implements OnInit {

  constructor(private postSvc: PostService) { }

  posts: Post[] = []

  formAction: string = 'create'

  newPost: Post = new Post('', '')

  ngOnInit(): void {
    this.postSvc.getAllPost()
      .subscribe(data => this.posts = data)
  }

  save() {
    this.postSvc.addPost(this.newPost).subscribe(res => {
      this.posts.push(res);
      this.newPost = new Post('', '')
    })
  }

  select(post: Post) {

    this.newPost = Object.assign(post);
    this.formAction = 'edit'

  }

  editPost() {
    this.postSvc.editPost(this.newPost)
      .subscribe(res => {
        let index = this.posts.findIndex(p => p.id == this.newPost.id)
        this.posts.splice(index, 1, this.newPost)

        this.newPost = new Post('', '')

        this.formAction = 'create'
      })
  }

  deletePost(post: Post) {
    this.postSvc.deletePost(post)
      .subscribe(res => {
        let index = this.posts.findIndex(p => p.id == post.id)
        this.posts.splice(index, 1)
      })
  }

}
