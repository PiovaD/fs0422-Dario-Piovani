import { Injectable } from '@angular/core';
import { Post } from './post';

@Injectable({
  providedIn: 'root'
})
export class PostsService {

  allPost!: Post[];

  API: string = 'http://localhost:3000/post'

  constructor() { }

  async getAllPost(): Promise<Post[]> {

    let response = await fetch(this.API)

    this.allPost = await response.json()

    return this.allPost

  }

  changeActive(id: number): Post[] {

    let index: number = this.allPost.findIndex(p => p.id == id)

    let post: Post = this.allPost[index]

    console.log(post)

    post.active = !post.active

    console.log(post)

    let options = {
      method: 'PUT',
      body: JSON.stringify(post),
      headers: {
        "content-type": "application/json"
      }
    }

    fetch(this.API + '/' + post.id, options)
      .then(response => response.json())
      .then(response => {
        console.log(response)
      })

    return this.allPost
  }

  activeFilter(array: Post[], isActive: boolean): Post[] {
    return array.filter(p => p.active === isActive)
  }



}
