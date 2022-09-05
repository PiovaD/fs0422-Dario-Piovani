import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-foto',
  templateUrl: './foto.component.html',
  styleUrls: ['./foto.component.css']
})

export class FotoComponent implements OnInit {

  constructor() { }

  API: string = "https://jsonplaceholder.typicode.com/albums/1/photos"

  arrFoto: any[] = []

  arrLike: string[] = []

  like: number = 0

  ngOnInit(): void {
    fetch(this.API)
      .then(res => res.json())
      .then(arrFoto => {
        this.arrFoto = arrFoto
      })
  }

  deletePhoto(id: string): void {
    let index = this.arrFoto.findIndex((foto) => foto.id === id)
    this.arrFoto.splice(index, 1)

    let likeIndex = this.arrLike.findIndex((like) => like === id)
    if (likeIndex >= 0) this.removeLike(likeIndex)
  }

  likePhoto(id: string, event: Event): void {

    let index: number | undefined = this.arrLike.findIndex((elem) => elem === id)

    if (index > -1) {

      (event!.target as HTMLElement).classList.replace('btn-warning', 'btn-success')

      this.removeLike(index)

    } else {

      (event!.target as HTMLElement).classList.replace('btn-success', 'btn-warning')

      this.arrLike.push(id)

    }

  }

  removeLike(index: number): void {

    this.arrLike.splice(index, 1);
  }

}
