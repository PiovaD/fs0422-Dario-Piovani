import { Component, OnInit } from '@angular/core';
import { interval, map, multicast, Subject } from 'rxjs';
import { IPhoto } from '../Models/iphoto';
import { PhotoService } from '../Models/photo.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {

  photos: IPhoto[] = [];

  allLike: number = 0;

  likeSbj = new Subject<number>()


  constructor(private photoSVC: PhotoService) { }

  ngOnInit(): void {
    this.photoSVC.getPhotos()
      .pipe(
        map(phots => phots.filter(photo => photo.albumId == 1))
      )
      .subscribe(res => this.photos = res)

    this.likeSbj.subscribe({
      next: (n) => this.allLike += n,
    })
  }

  deletePhoto(photo: IPhoto): void {
    this.photoSVC.deletePhotos(photo)
      .subscribe({
        error: error => console.error(error),
        complete: () => {
          console.log('Eliminato')
          this.photos = this.photos.filter((p: IPhoto) => p.id != photo.id)
        }
      })

  }

  like(photo: IPhoto) {

    this.likeSbj.next(1)

  }

}
