import { Component, OnInit, OnDestroy } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { AuthService } from 'src/app/service/auth.service';
import { Router } from '@angular/router';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {

  user: any;
  isDataAvailable:boolean = false;

  constructor(private userService: UserService, private messageService: MessageService) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.user = data;
      
    }).then(() => this.isDataAvailable = true);
  }

  ngOnDestroy() {
    this.user = null;
  }

  userRole(): string {
    return this.user.authorities[0].authority + '';
  }

  create() {

  }

  update(id: number) {

  }

  delete(id: number) {

  }

}
