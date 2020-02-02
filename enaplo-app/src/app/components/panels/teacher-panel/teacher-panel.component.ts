import { Component, OnInit } from '@angular/core';
import { Teacher } from 'src/app/model/teacher';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';
import { ClassroomService } from 'src/app/service/classroom.service';
import { TeacherService } from 'src/app/service/teacher.service';

@Component({
  selector: 'app-teacher-panel',
  templateUrl: './teacher-panel.component.html',
  styleUrls: ['./teacher-panel.component.scss']
})
export class TeacherPanelComponent implements OnInit {

  currentUser: any = {};
  teacher = new Teacher();
  isDataAvailable: boolean = false;

  constructor(private userService: UserService, private router: Router, 
    private classroomService: ClassroomService, private teacherService: TeacherService) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.teacherService.findByUserId(this.currentUser.id).subscribe(data => {
        this.teacher = data;
        this.isDataAvailable = true;
      })
    });
  }

  classrooms() {
    this.router.navigate(['/classroom/all']);
  }

  update() {
    this.teacherService.findByUserId(this.currentUser.id).subscribe(data => this.router.navigate(['student/update', data.id]));
  }

  details() {
    this.teacherService.findByUserId(this.currentUser.id).subscribe(data => this.router.navigate(['student/details', data.id]));
  }
}
