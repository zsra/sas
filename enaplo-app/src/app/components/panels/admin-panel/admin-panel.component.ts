import { Component, OnInit, OnDestroy } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.scss']
})
export class AdminPanelComponent implements OnInit {

  constructor(private authService: AuthService, private userService: UserService,
     private router: Router) { }

  ngOnInit() {

  }

  createStudent() {
    this.router.navigate(['/student/create']);
  }

  createTeacher() {
    this.router.navigate(['/teacher/create']);
  }

  createCourse() {
    this.router.navigate(['/course/create']);
  }

  createClassroom() {
    this.router.navigate(['/classroom/create']);
  }

  getAllUser() {
    this.router.navigate(['/user/all']);
  }

  getAllClassroom() {
    this.router.navigate(['/classroom/all']);
  }

  getAllCourse() {
    this.router.navigate(['/course/all']);
  }
}
