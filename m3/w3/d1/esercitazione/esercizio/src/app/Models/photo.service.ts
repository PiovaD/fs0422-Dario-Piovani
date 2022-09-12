import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IPhoto } from './iphoto';

@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  API: string = "https://jsonplaceholder.typicode.com/photos"

  constructor(private http: HttpClient) { }

  getPhotos(): Observable<IPhoto[]> {
   return this.http.get<IPhoto[]>(this.API)
  }

  deletePhotos(photo: IPhoto): Observable<IPhoto>{
    return this.http.delete<IPhoto>(this.API + '/' + photo.id)
  }

}
