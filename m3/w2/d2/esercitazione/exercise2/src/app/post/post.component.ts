import { getSafePropertyAccessString } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../Models/post';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  API: string = 'http://localhost:3000/post'
  isActive!: boolean;

  allPost: Post[] = []

  constructor(private route: ActivatedRoute) {
  }




  ngOnInit(): void {

    this.isActive = this.route.snapshot.params['id'] == 'active';

    fetch(this.API)
      .then(res => res.json())
      .then(res => {

        this.allPost = res;

      })

  }

}
