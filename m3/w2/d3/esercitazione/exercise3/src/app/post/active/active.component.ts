import { style } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/Models/post';
import { PostsService } from 'src/app/Models/posts.service';

@Component({
  selector: 'app-active',
  templateUrl: './active.component.html',
  styleUrls: ['./active.component.css']
})
export class ActiveComponent implements OnInit {

  allPost: Post[] = []

  constructor(private postSvc: PostsService) {
  }

  async ngOnInit(): Promise<void> {

    let posts = await this.postSvc.getAllPost();

    this.allPost = this.postSvc.activeFilter(posts, true)

  }

  changeActive(id: number): void {
    this.allPost = this.postSvc.activeFilter(this.postSvc.changeActive(id), true)
  }

  styleByType(type: string): string {

    let styles!: string

    switch (type) {
      case 'news':
        styles = 'bg-warning '
        break
      case 'education':
        styles = 'bg-info '
        break
      case 'politic':
        styles = 'bg-dark text-light '
        break

    }

    styles += 'container my-2 py-2'

    return styles

  }

}
