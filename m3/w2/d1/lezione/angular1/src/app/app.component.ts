import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})

export class AppComponent implements OnInit {

  ngOnInit(): void {
    this.getAllUsers();
  }

  title = 'Home';
  titleColor = 'red';

  arr: any[] = ['Mario', 'Luisa', 'Franco'];

  users: any[] = [];

  getAllUsers() {

    fetch('https://jsonplaceholder.typicode.com/users')
      .then((res) => res.json())
      .then((res) => (this.users = res));

  }

  deleteUser(id: string) {
    let index = this.users.findIndex((user) => user.id === id);
    this.users.splice(index, 1);
  }

  returnNames(): string[] {
    return this.arr;
  }
}
