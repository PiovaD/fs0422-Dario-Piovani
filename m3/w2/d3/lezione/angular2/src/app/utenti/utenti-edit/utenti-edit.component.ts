import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-utenti-edit',
  templateUrl: './utenti-edit.component.html',
  styleUrls: ['./utenti-edit.component.scss']
})
export class UtentiEditComponent implements OnInit {

  constructor(private userService: UserService, private route:ActivatedRoute) { }

  user: User = new User('','');

  ngOnInit(): void {
   let userId = this.route.snapshot.params['id'];
   this.user = this.userService.getUserbyId(userId)
  }

  save(){}

}
