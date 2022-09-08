import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from 'src/app/Models/post';
import { PostsService } from 'src/app/Models/posts.service';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.css']
})
export class PostDetailsComponent implements OnInit {

  currentPost!: Post;

  constructor(
    private activeRoute: ActivatedRoute,
    private postsSvc: PostsService,
    private router: Router
  ) { }

  ngOnInit(): void {

    let id: number = Number(this.activeRoute.snapshot.paramMap.get('id'))

    if (this.postsSvc.allPost != undefined) {

      this.currentPost = this.postsSvc.getPostById(id);

    }else{

      this.router.navigate(['/'])

    }


  }

}
