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

  roles: [
    'ROLE_STUDENT',
    'ROLE_TEACHER',
    'ROLE_ADMIN',
    'ROLE_HEADTEACHER'
  ];

  constructor(private userService: UserService, private authService: AuthService, 
    private router: Router) { }

  ngOnInit() {
    this.user = this.userService.getMyInfo();
  }

  userRole() {
    this.user.subscribe(data => {
      return data.authorities[0].authority;
    });
  }

  teacherPanel() {

  }

  adminPanel() {

  }

  headTeacherPanel() {

  }

  studentPanel() {
    
  }

}
