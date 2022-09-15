import { Component, OnInit } from '@angular/core';

type Slide = {
  image: number;
  title: string;
  body: string;
}

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.scss']
})
export class CarouselComponent implements OnInit {

  constructor() { }

  images: Slide[] = [
    {
      image: 944,
      title: 'First slide label',
      body: 'Nulla vitae elit libero, a pharetra augue mollis interdum.'
    },
    {

      image: 1011,
      title: 'Second slide label',
      body: 'Nulla vitae elit libero, a pharetra augue mollis interdum.'
    },
    {

      image: 984,
      title: 'Third slide label',
      body: 'Nulla vitae elit libero, a pharetra augue mollis interdum.'
    }
  ]

  ngOnInit(): void {
  }

}
