import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { IPost } from 'src/app/auth/ipost';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.scss']
})
export class PostsComponent implements OnInit {

  isLoading: boolean = true;

  data: IPost[] = []

  constructor(private authSvc: AuthService) { }

  ngOnInit(): void {

    this.isLoading = true;
    this.authSvc.getAllPost()
      .subscribe({
        next: (res) => this.data = res.reverse(),
        complete: () => this.isLoading = false,
        error: (err) => {
          this.isLoading = false;
          console.log('HTTP Error', err)
        }

      })

  }

  update(newData: IPost): void {
    this.data.unshift(newData)
    this.ngOnInit();
  }

  isLogged(): boolean{
    return this.authSvc.isLogged()
  }

}
