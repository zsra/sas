import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.scss']
})
export class AdminPanelComponent implements OnInit {

  constructor(private router: Router) { }

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
