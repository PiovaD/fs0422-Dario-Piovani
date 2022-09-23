import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/Auth/auth.service';
import { IPost } from 'src/app/Model/ipost';
import { IUser } from 'src/app/Model/iuser';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  postsFind: IPost[] = [];
  userFind: IUser[] = [];

  contentValue = '';

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  find() {

    if (this.contentValue) {
      this.filterPost();
      this.filterUser();
    }
  }

  filterPost() {
    this.authService.getAllPost()
      .subscribe(post => {
        this.postsFind = post.filter(post => post.title.toLowerCase().includes(this.contentValue.toLowerCase()))
      })
  }

  filterUser() {
    this.authService.getAllUsers()
      .subscribe(user => {
        this.userFind = user.filter(user => user.username.toLowerCase().includes(this.contentValue.toLowerCase()))
      })
  }

  getAvatar(user: IUser): string {
    return `https://i.pravatar.cc/150?img=${user.id}`
  }

}
