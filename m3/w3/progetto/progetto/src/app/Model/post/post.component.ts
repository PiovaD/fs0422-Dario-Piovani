import { Component, Input, OnInit } from '@angular/core';
import { formatDistance } from 'date-fns';
import { IPost } from 'src/app/auth/ipost';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']
})
export class PostComponent implements OnInit {

  @Input() data: IPost[] = []

  constructor() { }

  ngOnInit(): void {
  }

  passedDays(date: Date): string {
    date = new Date(date)
    return formatDistance(new Date(), date)
  }

}
