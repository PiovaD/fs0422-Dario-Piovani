import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/Models/post';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  API: string = 'http://localhost:3000/post'

  newPost: Post = new Post('', '', 'news', false, '');

  constructor() { }

  ngOnInit(): void {
  }

  addPost(): void {

    let options = {
      method: "POST",
      body: JSON.stringify(this.newPost),
      headers: {
        "content-type": "application/json"
      }
    }

    fetch(this.API, options)
      .then(res => {
        this.newPost = new Post('', '', 'news', false, '');
      })

  }
}
