import { Injectable } from '@angular/core';
import { Post } from './Models/post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor() { }

  allPosts: Post[] = []

  lastId: number = 0;

  getAllPosts(): Post[] {
    return this.allPosts
  }

  getPostById(id: number): Post | null {

    let foundPost = this.allPosts.find((post: Post) => post.id === id) || null;

    return foundPost;
  }

  addPost(post: Post): void {
    this.lastId++
    post.id = this.lastId
    post = Object.assign({}, post)
    this.allPosts.push(post)
  }
  deletePost(id: number): void{
    this.allPosts = this.allPosts.filter((p: Post) => p.id != id)
  }

  editPost(post: Post): void{
    let index = this.allPosts.findIndex((p: Post) => p.id == post.id)
    this.allPosts.splice(index, 1, post)
  }
}
