import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { AuthService } from 'src/app/service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  user: any;

  constructor(private userService: UserService, private authService: AuthService, 
    private router: Router) { }

  ngOnInit() {
    this.userService.getMyInfo().subscribe(data => console.log(data));
  }

  userRole() {

  }

}
