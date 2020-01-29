import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/model/student';
import { StudentService } from 'src/app/service/student.service';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-panel',
  templateUrl: './student-panel.component.html',
  styleUrls: ['./student-panel.component.scss']
})
export class StudentPanelComponent implements OnInit {

  currentUser: any = {};
  student = new Student();
  isDataAvailable: boolean = false;

  constructor(private userService: UserService, private router: Router, 
    private studentService: StudentService) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
    }).then(() => this.isDataAvailable = true);
  }

  summary() {
    this.studentService.findByUserId(this.currentUser.id).subscribe(data => this.router.navigate(['student/summary', data.id]));
  }

  timetable() {
    this.studentService.findByUserId(this.currentUser.id).subscribe(data => this.router.navigate(['timetable/view', data.id]));
  }

  reports() {
  }

  update() {
    this.studentService.findByUserId(this.currentUser.id).subscribe(data => this.router.navigate(['student/update', data.id]));
  }

  details() {
    this.studentService.findByUserId(this.currentUser.id).subscribe(data => this.router.navigate(['student/details', data.id]));
  }
}
